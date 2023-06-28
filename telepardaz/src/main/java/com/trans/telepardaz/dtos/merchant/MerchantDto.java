package com.trans.telepardaz.dtos.merchant;

import com.trans.telepardaz.dtos.BaseDto;
import com.trans.telepardaz.models.QrCode;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class MerchantDto extends BaseDto {
    private String name;
    @Pattern(regexp = "^0[0-9]{2}[0-9]{7,8}$",message = "That doesn’t look right, please re-enter your phone number.(First, enter the city code)")
    private String phone;
    @Pattern(regexp = "^09[0|1|2|3][0-9]{8}$" ,message = "That doesn’t look right, please re-enter your phone number.")
    private String mobile;
    @Pattern(regexp = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$",message = "That doesn’t look right, please re-enter your email.")
    private String email;
    @Pattern(regexp = "^((http|https)://)[-a-zA-Z0-9@:%._\\+~#?&//=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%._\\+~#?&//=]*)$",message = "That doesn’t look right, please re-enter your website")
    private String website;
    @Pattern(regexp = "^[A-Z]{2}(?:[ ]?[0-9]){18,24}$",message = "That doesn’t look right, please re-enter your iban")
    private String iban;
    private String code;
    @Pattern(regexp = "^\\d{16}$",message = "That doesn’t look right, please re-enter your cardNumber")
    private String cardNumber;
    @Pattern(regexp = "^\\d{18}$",message = "That doesn’t look right, please re-enter your accountNumber")
    private String accountNumber;
    @OneToMany(mappedBy = "merchant")
    private List<QrCode> qrCodes;
}
