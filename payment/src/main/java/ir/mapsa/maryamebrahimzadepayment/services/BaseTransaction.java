package ir.mapsa.maryamebrahimzadepayment.services;

import ir.mapsa.maryamebrahimzadepayment.dto.TransactionDto;
import ir.mapsa.maryamebrahimzadepayment.exceptions.ServiceException;

public interface BaseTransaction {
    void transfer(TransactionDto dto) throws ServiceException;
    Boolean resolve(TransactionDto dto) throws ServiceException;

}
