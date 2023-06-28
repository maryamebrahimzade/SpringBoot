package com.trans.telepardaz.mappers.merchant;

import com.trans.telepardaz.dtos.merchant.MerchantDto;
import com.trans.telepardaz.mappers.BaseMapper;
import com.trans.telepardaz.models.merchant.Merchant;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MerchantMapper extends BaseMapper<MerchantDto, Merchant> {
}
