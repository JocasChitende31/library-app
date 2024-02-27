package com.atendestartup.fileuploaddownloadapirest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MyFileNotFoundException extends RuntimeException{

    public MyFileNotFoundException(String sms){
        super(sms);
    }
    public MyFileNotFoundException(String sms, Throwable cause){
        super(sms, cause);
    }
}
