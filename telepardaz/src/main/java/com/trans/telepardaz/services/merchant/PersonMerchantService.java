package com.trans.telepardaz.services.merchant;

import com.trans.telepardaz.utills.responses.MerchantResponse;
import com.trans.telepardaz.enums.MerchantType;
import com.trans.telepardaz.exceptions.ServiceException;
import com.trans.telepardaz.models.merchant.Merchant;
import com.trans.telepardaz.models.merchant.PersonMerchant;
import com.trans.telepardaz.repositories.merchant.PersonMerchantRepository;
import com.trans.telepardaz.services.BaseService;
import com.trans.telepardaz.services.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PersonMerchantService extends BaseService<PersonMerchantRepository, PersonMerchant> implements BaseMerchant {
    @Autowired
    private LinkService linkService;

    @Value("${base-url}")
    private String baseUrl;

    @Override
    public <T extends Merchant> MerchantResponse createMerchant(T merchant) throws ServiceException {
        return getMerchantResponse((PersonMerchant) savePersonMerchant((PersonMerchant) merchant));
    }

    private Merchant savePersonMerchant(PersonMerchant personMerchant) throws ServiceException {
        PersonMerchant savedNewMerchant = repository.save(personMerchant);
        savedNewMerchant.setCode(linkService.generateLink(savedNewMerchant, MerchantType.PERSON));
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
