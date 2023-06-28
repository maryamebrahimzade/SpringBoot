package com.trans.telepardaz.mappers;

import com.trans.telepardaz.dtos.TransactionDto;
import com.trans.telepardaz.models.Transaction;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransactionMapper extends BaseMapper<TransactionDto, Transaction> {
}
