package ir.mapsa.maryamebrahimzadepayment.repositories;

import ir.mapsa.maryamebrahimzadepayment.models.AccountType;
import ir.mapsa.maryamebrahimzadepayment.models.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountTypeRepository extends JpaRepository<AccountType,Long> {
    AccountType findByName(String accountTypeName);
}

