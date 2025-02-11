package org.dam19.tcgjpaserver.models;

public class ResponseModel {
    private int succes;
    private String message;
    private Object data;

    public ResponseModel() {

    }

    public ResponseModel(int succes, String message, Object data) {
        this.succes = succes;
        this.message = message;
        this.data = data;
    }

    public int getSucces() {
        return succes;
    }

    public void setSuccess(int succes) {
        this.succes = succes;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
