package com.trans.telepardaz.dtos.merchant;

import lombok.*;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MerchantBaseInfo {
    private String name;
    private Long id;
}
