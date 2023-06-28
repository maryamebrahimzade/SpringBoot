package com.trans.telepardaz.models.merchant;

import com.trans.telepardaz.models.BaseEntity;
import com.trans.telepardaz.models.QrCode;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "merchant_type",
        discriminatorType = DiscriminatorType.STRING)
@Table(name = "merchant")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Merchant extends BaseEntity {
    private String name;
    private String phone;
    private String mobile;
    private String email;
    private String website;
    private String iban;
    private String code;
    private String cardNumber;
    private String accountNumber;
    private String cvv2;
    private String expireTime;
    @OneToMany(mappedBy = "merchant")
    private List<QrCode> qrCodes;
    private String MerchantId;
}
