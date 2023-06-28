package com.trans.telepardaz.services;

import com.trans.telepardaz.config.ApplicationConfig;
import com.trans.telepardaz.dtos.merchant.MerchantBaseInfo;
import com.trans.telepardaz.dtos.QRCodeDto;
import com.trans.telepardaz.exceptions.ServiceException;
import com.trans.telepardaz.models.merchant.Merchant;
import com.trans.telepardaz.models.QrCode;
import com.trans.telepardaz.repositories.QRCodeRepository;
import com.trans.telepardaz.services.merchant.MerchantService;
import com.trans.telepardaz.utills.UuIdGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;
import java.util.Optional;

@Service
public class QrCodeService extends BaseService<QRCodeRepository, QrCode> {
    @Autowired
    private MerchantService merchantService;
    @Autowired
    private ObjectMapper mapper;
    @Autowired
    private ApplicationConfig QRCodeWriter;

    public BufferedImage generateQRCodeImage(QRCodeDto dto) throws ServiceException, WriterException, JsonProcessingException {
        Optional<Merchant> merchant = merchantService.findById(dto.getId());
        if (merchant.isEmpty()) {
            throw new ServiceException("this-merchandise-is-not-registered-in-the-system");
        }
        QrCode terminalId = repository.findByTerminalId(dto.getTerminalId());
        if (terminalId != null) {
            throw new ServiceException("the-terminal-iD-is-registered-in-the-system");
        }
        saveQrCode(dto, merchant);
        MerchantBaseInfo response = getShowMerchant(merchant);
        String infoSavedOnQr = mapper.writeValueAsString(response);
        BitMatrix bitMatrix = QRCodeWriter.barcodeWriter().encode(String.valueOf(infoSavedOnQr), BarcodeFormat.QR_CODE, 200, 200);
        return MatrixToImageWriter.toBufferedImage(bitMatrix);
    }

    private MerchantBaseInfo getShowMerchant(Optional<Merchant> merchant) {
        return MerchantBaseInfo.builder()
                .id(merchant.get().getId())
                .name(merchant.get().getName()).build();
    }

    private void saveQrCode(QRCodeDto dto, Optional<Merchant> merchant) {
        QrCode qrCode = QrCode.builder()
                .merchant(merchant.get())
                .terminalId(dto.getTerminalId())
                .qrCodeId(UuIdGenerator.generateUuID()).build();
        repository.save(qrCode);
    }

    public ResponseEntity<BufferedImage> okResponse(BufferedImage image) {
        return new ResponseEntity<>(image, HttpStatus.OK);
    }
}
