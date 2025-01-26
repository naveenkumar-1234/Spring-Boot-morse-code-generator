package com.morsecode.MorseCodeGenerator.model;

public class MorseResponse {

    private int statusCode;
    private String text;

    public int getStatusCode(){
        return statusCode;
    }
    public String getText(){
        return text;
    }
    public void setText(String text){
        this.text = text;
    }
    public void setStatusCode(int statusCode){
        this.statusCode = statusCode;
    }

}
