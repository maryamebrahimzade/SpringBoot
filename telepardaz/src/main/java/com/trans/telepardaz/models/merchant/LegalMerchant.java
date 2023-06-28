package com.trans.telepardaz.models.merchant;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@ToString
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("LEGAL")
public class LegalMerchant extends Merchant {
    private String postalCode;
    private String description;
    private String address;

}
