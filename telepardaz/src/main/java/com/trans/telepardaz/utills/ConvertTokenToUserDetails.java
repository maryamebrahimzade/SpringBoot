package com.trans.telepardaz.utills;

import com.trans.telepardaz.models.UserDetails;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Base64;

public class ConvertTokenToUserDetails {
    public static UserDetails convert(String token) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String[] chunks = token.split("\\.");
        Base64.Decoder decoder = Base64.getUrlDecoder();
        String payload = new String(decoder.decode(chunks[1]));
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.readValue(payload, UserDetails.class);
    }
}
