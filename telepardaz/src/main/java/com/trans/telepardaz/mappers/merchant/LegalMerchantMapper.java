package com.trans.telepardaz.mappers.merchant;

import com.trans.telepardaz.dtos.merchant.LegalMerchantDto;
import com.trans.telepardaz.mappers.BaseMapper;
import com.trans.telepardaz.models.merchant.LegalMerchant;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LegalMerchantMapper extends BaseMapper<LegalMerchantDto, LegalMerchant> {
}
