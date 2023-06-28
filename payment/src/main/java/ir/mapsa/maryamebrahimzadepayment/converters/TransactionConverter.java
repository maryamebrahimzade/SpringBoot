package ir.mapsa.maryamebrahimzadepayment.converters;

import ir.mapsa.maryamebrahimzadepayment.dto.TransactionDto;
import ir.mapsa.maryamebrahimzadepayment.models.Transaction;
import ir.mapsa.maryamebrahimzadepayment.services.BankInfoService;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class TransactionConverter implements BaseConverter<TransactionDto, Transaction> {
    @Autowired
    private BankInfoService bankInfoService;

    @AfterMapping
    public void afterSet(@MappingTarget TransactionDto d, Transaction e) {
        d.setSource(e.getSender().getCardNumber());
        d.setDestination(e.getReceiver().getCardNumber());
    }
    @AfterMapping
    public void afterSet(@MappingTarget Transaction e,TransactionDto d) {
        e.setSender(bankInfoService.findByCardNumber(d.getSource()));
        e.setReceiver(bankInfoService.findByCardNumber(d.getDestination()));
    }

}
