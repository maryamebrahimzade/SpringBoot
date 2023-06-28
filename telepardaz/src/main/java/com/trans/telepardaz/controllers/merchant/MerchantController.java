package com.trans.telepardaz.controllers.merchant;

import com.trans.telepardaz.controllers.BaseController;
import com.trans.telepardaz.dtos.merchant.MerchantDto;
import com.trans.telepardaz.models.merchant.Merchant;
import com.trans.telepardaz.services.merchant.MerchantService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/merchant")
public class MerchantController extends BaseController<Merchant, MerchantDto, MerchantService> {

}
