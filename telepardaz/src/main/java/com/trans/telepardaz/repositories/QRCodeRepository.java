package com.trans.telepardaz.repositories;

import com.trans.telepardaz.models.QrCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QRCodeRepository extends JpaRepository<QrCode, Long> {
    QrCode findByTerminalId(String terminalId);
}
