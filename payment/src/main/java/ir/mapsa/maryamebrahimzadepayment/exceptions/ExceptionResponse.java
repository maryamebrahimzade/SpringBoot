package ir.mapsa.maryamebrahimzadepayment.exceptions;

import lombok.Data;

@Data
public class ExceptionResponse {
    private String message;
    private Boolean error;
}
