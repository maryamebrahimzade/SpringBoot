package com.trans.telepardaz.repositories.merchant;

import com.trans.telepardaz.models.merchant.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MerchantRepository extends JpaRepository<Merchant, Long> {
}
