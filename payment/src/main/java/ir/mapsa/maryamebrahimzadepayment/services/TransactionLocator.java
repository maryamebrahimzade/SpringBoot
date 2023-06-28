package ir.mapsa.maryamebrahimzadepayment.services;

import ir.mapsa.maryamebrahimzadepayment.dto.TransactionDto;
import ir.mapsa.maryamebrahimzadepayment.exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TransactionLocator extends CommonBaseTransaction{
    @Autowired
    private List<BaseTransaction> transfers;
    public void transfer(TransactionDto tDto) throws ServiceException {
        boolean support = true;
        for (BaseTransaction transfer : transfers) {
            if (transfer.resolve(tDto)) {
                transfer.transfer(tDto);
                support=true;
                break;
            } else {
                support = false;
            }
        }
        if (!support) {
            throw new ServiceException("transfer_not_supported");
        }
    }

    @Override
    public Boolean resolve(TransactionDto dto) throws ServiceException {
        return null;
    }

}
