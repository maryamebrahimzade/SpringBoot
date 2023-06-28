package com.trans.telepardaz.controllers;

import com.trans.telepardaz.dtos.merchant.MerchantBaseInfo;
import com.trans.telepardaz.dtos.merchant.MerchantDto;
import com.trans.telepardaz.models.merchant.Merchant;
import com.trans.telepardaz.services.LinkService;
import org.springframework.web.bind.annotation.*;
@RestController
public class LinkController extends BaseController<Merchant, MerchantDto, LinkService> {
    @GetMapping("/link")
    public MerchantBaseInfo getMerchant(@RequestParam String code) {
        return service.decode(code);
    }
}
