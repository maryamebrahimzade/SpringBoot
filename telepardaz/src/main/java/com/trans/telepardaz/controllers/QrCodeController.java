package com.trans.telepardaz.controllers;

import com.trans.telepardaz.dtos.QRCodeDto;
import com.trans.telepardaz.exceptions.ServiceException;
import com.trans.telepardaz.models.QrCode;
import com.trans.telepardaz.services.QrCodeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.zxing.WriterException;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.awt.image.BufferedImage;

@RestController
@RequestMapping("/qrcode")
public class QrCodeController extends BaseController<QrCode, QRCodeDto, QrCodeService> {

    @PostMapping(value = "/create",produces = MediaType.IMAGE_PNG_VALUE)
    @Transactional
    public ResponseEntity<BufferedImage> create(@Valid @RequestBody QRCodeDto dto) throws ServiceException, WriterException, JsonProcessingException {
        return service.okResponse(service.generateQRCodeImage(dto));
    }
}
