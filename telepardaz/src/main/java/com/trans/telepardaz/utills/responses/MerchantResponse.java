package com.trans.telepardaz.utills.responses;

import com.trans.telepardaz.dtos.merchant.MerchantBaseInfo;
import lombok.*;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MerchantResponse extends MerchantBaseInfo {
    private String url;
}
