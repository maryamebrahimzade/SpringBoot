package ir.mapsa.maryamebrahimzadepayment.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@EntityListeners(AuditingEntityListener.class)
@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
public class BankInfo extends AbstractEntity {
    private String bankName;
    private String cardNumber;
    private String accountNumber;
    private String shabaNumber;
    private Long balance;
    private String ccv;
    private Date expirationDate;
    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;
    @ManyToOne
    @JoinColumn(name = "accountType_id")
    private AccountType accountType;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @Column(unique = true)
    private String bankInfoId;
}
