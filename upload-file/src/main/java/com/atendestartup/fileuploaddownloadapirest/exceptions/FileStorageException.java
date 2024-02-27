package com.atendestartup.fileuploaddownloadapirest.exceptions;

public class FileStorageException extends RuntimeException{

    public FileStorageException(String sms){
        super(sms);
    }
    public FileStorageException(String sms, Throwable cause){

        super(sms, cause);
    }
}
