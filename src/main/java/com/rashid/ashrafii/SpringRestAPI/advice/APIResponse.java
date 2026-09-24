package com.rashid.ashrafii.SpringRestAPI.advice;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

@Data
public class APIResponse<T> {

    @JsonFormat(pattern = "hh:mm:ss dd-MM-yyyy")
    private LocalDateTime timeStamp;
    private T data;
    private APIError error;

    public APIResponse(){
        this.timeStamp = LocalDateTime.now();
    }

    public APIResponse(T data){
        this();
        this.data = data;
    }

    public APIResponse(APIError error){
        this();
        this.error = error;
    }
}
