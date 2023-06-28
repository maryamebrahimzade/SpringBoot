package com.trans.telepardaz.controllers.merchant;

import com.trans.telepardaz.controllers.BaseController;
import com.trans.telepardaz.utills.responses.MerchantResponse;
import com.trans.telepardaz.dtos.merchant.PersonMerchantDto;
import com.trans.telepardaz.exceptions.ServiceException;
import com.trans.telepardaz.models.merchant.PersonMerchant;
import com.trans.telepardaz.services.merchant.PersonMerchantService;
import jakarta.validation.Valid;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonMerchantController extends BaseController<PersonMerchant, PersonMerchantDto, PersonMerchantService> {

    @PostMapping("/create")
    @Transactional
    public MerchantResponse create(@Valid @RequestBody PersonMerchantDto dto) throws ServiceException {
        return service.createMerchant(mapper.convertDto(dto));
    }
}
