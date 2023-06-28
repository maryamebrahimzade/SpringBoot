package com.trans.telepardaz.utills;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UuIdGenerator {
    public static String generateUuID() {
        return UUID.randomUUID().toString();
    }
}
