package com.elastamo.smarthousepartieserver.Response;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;


//This class will later be used to generate responses, where the response will be received in the form of an object with 3 parameters/values ​​in it.
public class ResponseHandler {
    public static ResponseEntity<Object> generateResponse(String message , HttpStatus status, Object responseObject){

        Map<String,Object> map = new HashMap<>();

        map.put("message",message);

        map.put("status",status.value());

        map.put("data",responseObject);
        return new ResponseEntity<Object>(map,status);
    }
}
