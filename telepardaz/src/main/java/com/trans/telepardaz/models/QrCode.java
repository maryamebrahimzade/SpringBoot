package com.trans.telepardaz.models;

import com.trans.telepardaz.models.merchant.Merchant;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "qrcode")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QrCode extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "merchant_id")
    private Merchant merchant;

    @Column(unique = true,name = "terminalId")
    private String terminalId;

    @Column(name="qrCodeId")
    private String qrCodeId;
}
