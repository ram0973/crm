package ru.aretinsky.crm.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {
    private int httpCode;
    private String message;

    public ErrorResponse(int httpCode, String message) {
        this.httpCode = httpCode;
        this.message = message;
    }
}
