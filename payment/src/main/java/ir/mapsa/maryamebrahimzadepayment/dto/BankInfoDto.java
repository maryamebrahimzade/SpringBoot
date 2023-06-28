package ir.mapsa.maryamebrahimzadepayment.dto;

import ir.mapsa.maryamebrahimzadepayment.models.AccountType;
import ir.mapsa.maryamebrahimzadepayment.models.Branch;
import ir.mapsa.maryamebrahimzadepayment.models.Customer;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class BankInfoDto extends AbstractDto{
    private String bankName;
    private String cardNumber;
    private String accountNumber;
    private String shabaNumber;
    private Long balance;
    private String ccv;
    private Date expirationDate;
    private Integer branchCode;
    private String accountTypeName;
    private String customerId;
    private String bankInfoId;
}
