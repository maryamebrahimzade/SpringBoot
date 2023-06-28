package ir.mapsa.maryamebrahimzadepayment.converters;

import ir.mapsa.maryamebrahimzadepayment.dto.AccountTypeDto;
import ir.mapsa.maryamebrahimzadepayment.models.AccountType;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountTypeConverter extends BaseConverter<AccountTypeDto, AccountType> {

}
