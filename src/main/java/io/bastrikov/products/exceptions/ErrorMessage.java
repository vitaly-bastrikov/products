package io.bastrikov.products.exceptions;

import lombok.Data;

import java.util.Date;

@Data
public class ErrorMessage {
    private int status;
    private Date timestamp;
    private String message;

    public ErrorMessage(int status, Date timestamp, String message){
        this.status = status;
        this.timestamp = timestamp;
        this.message = message;
    }

}
