package ir.mapsa.maryamebrahimzadepayment.dto;

import ir.mapsa.maryamebrahimzadepayment.models.BankInfo;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class BranchDto extends AbstractDto{
    private String name;
    private Integer branchCode;
    private String branchId;
    private String bankInfoId;
}
