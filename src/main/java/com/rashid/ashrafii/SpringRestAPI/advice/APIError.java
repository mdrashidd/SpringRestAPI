package com.rashid.ashrafii.SpringRestAPI.advice;

import lombok.*;
import org.springframework.http.HttpStatus;
import java.util.List;

@Data
@Builder
public class APIError {
    private HttpStatus status;
    private String message;
    private List<String> subErros;
}
