package com.rdr.sglserverjava.security;

public class ExceptionResponse {
    
    private int customErrorCode;
    private String errorMsg;
    
    public ExceptionResponse(int i, String errorMsg) {
        this.customErrorCode = i;
        this.errorMsg = errorMsg;
    }

    public int getCustomErrorCode() {
        return customErrorCode;
    }

    public void setCustomErrorCode(int customErrorCode) {
        this.customErrorCode = customErrorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }    
    
}
