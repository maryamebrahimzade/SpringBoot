package com.trans.telepardaz.mappers.merchant;

import com.trans.telepardaz.dtos.merchant.PersonMerchantDto;
import com.trans.telepardaz.mappers.BaseMapper;
import com.trans.telepardaz.models.merchant.PersonMerchant;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMerchantMapper extends BaseMapper<PersonMerchantDto, PersonMerchant> {
}
