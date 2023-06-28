package com.trans.telepardaz.controllers.merchant;

import com.trans.telepardaz.controllers.BaseController;
import com.trans.telepardaz.dtos.merchant.LegalMerchantDto;
import com.trans.telepardaz.utills.responses.MerchantResponse;
import com.trans.telepardaz.exceptions.ServiceException;
import com.trans.telepardaz.models.merchant.LegalMerchant;
import com.trans.telepardaz.services.merchant.LegalMerchantService;
import jakarta.validation.Valid;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/legal")
public class LegalMerchantController extends BaseController<LegalMerchant, LegalMerchantDto, LegalMerchantService> {

    @PostMapping("/create")
    @Transactional
    public MerchantResponse create(@Valid @RequestBody LegalMerchantDto dto) throws ServiceException {
         return service.createMerchant(mapper.convertDto(dto));
    }

}
