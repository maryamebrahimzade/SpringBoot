package ir.mapsa.maryamebrahimzadepayment.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
@Entity
@Table(name="TRANSACTION")
@Data
@EqualsAndHashCode(callSuper = true)
@EntityListeners(AuditingEntityListener.class)
@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
public class Transaction extends AbstractEntity {
    private Long amount;
    private Date date;
    @ManyToOne
    @JoinColumn(name = "sender_id")
    private BankInfo sender;
    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private BankInfo receiver;
    @Column(unique = true)
    private String transactionId;
}
