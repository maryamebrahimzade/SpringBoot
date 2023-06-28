package ir.mapsa.maryamebrahimzadepayment.services;

import ir.mapsa.maryamebrahimzadepayment.dto.TransactionDto;
import ir.mapsa.maryamebrahimzadepayment.exceptions.ServiceException;
import ir.mapsa.maryamebrahimzadepayment.models.BankInfo;
import ir.mapsa.maryamebrahimzadepayment.models.Customer;
import ir.mapsa.maryamebrahimzadepayment.models.Transaction;
import ir.mapsa.maryamebrahimzadepayment.models.TransactionType;
import ir.mapsa.maryamebrahimzadepayment.services.notifications.NotificationSender;
import ir.mapsa.maryamebrahimzadepayment.services.notifications.NotificationText;
import ir.mapsa.maryamebrahimzadepayment.services.notifications.NotificationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class CardTransactionService extends CommonBaseTransaction {
    @Autowired
    private NotificationSender notificationSender;

    @Override
    @Transactional
    public void transfer(TransactionDto dto) throws ServiceException {
        BankInfo sender = bankInfoService.findByCardNumber(dto.getSource());
        if (sender == null) {
            throw new ServiceException("sender_is_not_valid");
        }
        BankInfo receiver = bankInfoService.findByCardNumber(dto.getDestination());
        if (receiver == null) {
            throw new ServiceException("receiver_is_not_valid");
        }
        resolveTransaction(sender, receiver, dto.getAmount());

        Transaction trxEntity = saveTransaction(dto, sender, receiver);

        notificationSender.send(NotificationType.EMAIL, new NotificationText("kasr ", sender.getCardNumber(), dto.getAmount(), trxEntity.getDate()));
        notificationSender.send(NotificationType.SMS, new NotificationText("plus", receiver.getCardNumber(), dto.getAmount(), trxEntity.getDate()));
    }

    @Override
    public Boolean resolve(TransactionDto dto) throws ServiceException {
        if (dto.getType() == null) {
            throw new ServiceException("type_is_empty");
        }
        return dto.getType().equals(TransactionType.CARDTOCARD);
    }
}
