package com.trans.telepardaz.models;

import com.trans.telepardaz.enums.TransactionStatus;
import com.trans.telepardaz.enums.TransferMethod;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "transaction")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transaction extends BaseEntity{
    @Column(unique = true)
    private String trackingId;
    private String walletId;
    private String user;
    private Long amount;
    @Enumerated(value = EnumType.STRING)
    private TransactionStatus status;
    private TransferMethod transferMethod;
}
