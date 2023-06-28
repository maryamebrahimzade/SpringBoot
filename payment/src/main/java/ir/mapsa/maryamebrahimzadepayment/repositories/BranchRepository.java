package ir.mapsa.maryamebrahimzadepayment.repositories;

import ir.mapsa.maryamebrahimzadepayment.models.BankInfo;
import ir.mapsa.maryamebrahimzadepayment.models.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepository extends JpaRepository<Branch,Long> {
    Branch findByBranchCode(Integer branchCode);
}

