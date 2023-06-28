package ir.mapsa.maryamebrahimzadepayment.services;

import ir.mapsa.maryamebrahimzadepayment.exceptions.ServiceException;
import ir.mapsa.maryamebrahimzadepayment.models.AccountType;
import ir.mapsa.maryamebrahimzadepayment.repositories.AccountTypeRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountTypeService extends AbstractService<AccountTypeRepository, AccountType> {

    public AccountType findByName(String accountTypeName) throws ServiceException {
        AccountType accountType = repository.findByName(accountTypeName);
        if (accountType == null) {
            throw new ServiceException("account_type_id_not_found");
        }
        return accountType;
    }
}
