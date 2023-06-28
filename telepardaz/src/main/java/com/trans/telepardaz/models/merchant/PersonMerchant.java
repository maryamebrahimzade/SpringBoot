package com.trans.telepardaz.models.merchant;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@ToString
@NoArgsConstructor
@DiscriminatorValue("PERSON")
public class PersonMerchant extends Merchant {


}
