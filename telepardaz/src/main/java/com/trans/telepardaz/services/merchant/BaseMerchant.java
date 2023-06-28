package com.trans.telepardaz.services.merchant;

import com.trans.telepardaz.utills.responses.MerchantResponse;
import com.trans.telepardaz.exceptions.ServiceException;
import com.trans.telepardaz.models.merchant.Merchant;

public interface BaseMerchant {
    <T extends Merchant> MerchantResponse createMerchant(T merchant) throws ServiceException;

    <T extends Merchant> MerchantResponse getMerchantResponse(T merchant);
}
