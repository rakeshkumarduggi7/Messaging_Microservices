package com.example.message_microservice_userservice.model;

public class SendMessage {

    String tousername;
    String message;

    public SendMessage() {
    }

    public String getTousername() {
        return tousername;
    }

    public void setTousername(String tousername) {
        this.tousername = tousername;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
