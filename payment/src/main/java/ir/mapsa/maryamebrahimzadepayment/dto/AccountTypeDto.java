package ir.mapsa.maryamebrahimzadepayment.dto;

import ir.mapsa.maryamebrahimzadepayment.models.BankInfo;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class AccountTypeDto extends AbstractDto{
    private String name;
    private String accountTypeId;
    private String bankInfoId;
}
