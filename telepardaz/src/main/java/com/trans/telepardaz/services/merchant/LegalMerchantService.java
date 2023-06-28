package com.trans.telepardaz.services.merchant;

import com.trans.telepardaz.utills.responses.MerchantResponse;
import com.trans.telepardaz.enums.MerchantType;
import com.trans.telepardaz.exceptions.ServiceException;
import com.trans.telepardaz.models.merchant.LegalMerchant;
import com.trans.telepardaz.models.merchant.Merchant;
import com.trans.telepardaz.repositories.merchant.LegalMerchantRepository;
import com.trans.telepardaz.services.BaseService;
import com.trans.telepardaz.services.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class LegalMerchantService extends BaseService<LegalMerchantRepository, LegalMerchant> implements BaseMerchant {
    @Autowired
    private LinkService linkService;

    @Value("${base-url}")
    private String baseUrl;
    @Override
    public <T extends Merchant> MerchantResponse createMerchant(T merchant) throws ServiceException {
        return getMerchantResponse((LegalMerchant) saveLegalMerchant((LegalMerchant) merchant));
    }

    private Merchant saveLegalMerchant(LegalMerchant legalMerchant) throws ServiceException {
        LegalMerchant savedNewMerchant = repository.save(legalMerchant);
        savedNewMerchant.setCode(linkService.generateLink(savedNewMerchant, MerchantType.LEGAL));
        super.update(savedNewMerchant);
        return savedNewMerchant;
    }

    @Override
    public <T extends Merchant> MerchantResponse getMerchantResponse(T merchant) {
        MerchantResponse response = new MerchantResponse();
        response.setId(merchant.getId());
        response.setName(merchant.getName());
        response.setUrl(baseUrl + "/link?code=" + merchant.getCode());
        return response;
    }

}
