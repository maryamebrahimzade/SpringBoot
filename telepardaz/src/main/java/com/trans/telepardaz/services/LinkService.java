package com.trans.telepardaz.services;

import com.trans.telepardaz.dtos.merchant.MerchantBaseInfo;
import com.trans.telepardaz.enums.MerchantType;
import com.trans.telepardaz.models.merchant.LegalMerchant;
import com.trans.telepardaz.models.merchant.Merchant;
import com.trans.telepardaz.models.merchant.PersonMerchant;
import com.trans.telepardaz.repositories.merchant.MerchantRepository;
import com.trans.telepardaz.utills.UuIdGenerator;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class LinkService extends BaseService<MerchantRepository, Merchant> {

    @Value("${jwt.secret}")
    private String secret;

    public <T> String generateLink(T merchant, MerchantType type) {
        Map<String, Object> claims = new HashMap<>();
        String id = UuIdGenerator.generateUuID().replace("-", "");
        if (type == MerchantType.PERSON) {
            return getGenerateLinkCode((PersonMerchant) merchant, claims, id);
        }
        return getGenerateLinkCode((LegalMerchant) merchant, claims, id);
    }

    private <T extends Merchant> String getGenerateLinkCode(T merchant, Map<String, Object> claims, String id) {
        return Jwts.builder().setClaims(claims)
                .setSubject(merchant.getMerchantId())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .claim("name", merchant.getName())
                .claim("id", merchant.getId())
                .setId(id).signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    public MerchantBaseInfo decode(String token){
        Claims claims = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token).getBody();
        return getShowMerchant((String) claims.get("name"), ((Number) claims.get("id")).longValue());
    }

    private static MerchantBaseInfo getShowMerchant(String fullName, Long id) {
        MerchantBaseInfo response = new MerchantBaseInfo();
        response.setId(id);
        response.setName(fullName);
        return response;
    }
}
