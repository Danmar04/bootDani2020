package com.rest.dani.apidani.configuration.error;

public class DaniException extends Exception{

    private String message;

    public DaniException(String message){
        super();
        this.message = message;
    }


    public String getMessageDani(){
      return  this.message;
    }
}
