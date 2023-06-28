package com.trans.telepardaz.dtos.merchant;

import jakarta.validation.constraints.Pattern;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
public class LegalMerchantDto extends MerchantDto {
    @Pattern(regexp = "^([a-zA-Z]|\\s){2,40}$")
    private String storeName;
    @Pattern(regexp = "^[0-9]{10}$",message = "That doesn’t look right, please re-enter your postalCode")
    private String postalCode;
    @Pattern(regexp = "^((?!.*\\..*\\.)(?!.*_.*_)[A-Za-z0-9_.])*$")
    private String description;
    @Pattern(regexp = "^([a-zA-z0-9/\\\\''(),\\-\\s]{2,255})$")
    private String address;
}
