package com.myProject.project.common.libs;

import java.util.Map;

public class RestResponse<T> {
    private T data;
    private boolean success;
    private String errorMessage;
    private String errorCode;
    private Map<String, Object> meta;

    public RestResponse() {
    }

    public RestResponse(T data, boolean success, String errorMessage) {
        this.data = data;
        this.success = success;
        this.errorMessage = errorMessage;
    }

    public RestResponse(T data, boolean success, String errorMessage, String errorCode) {
        this.data = data;
        this.success = success;
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    public RestResponse(T data, boolean success, String errorMessage, String errorCode, Map<String, Object> meta) {
        this.data = data;
        this.success = success;
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
        this.meta = meta;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public Map<String, Object> getMeta() {
        return this.meta;
    }

    public void setMeta(Map<String, Object> meta) {
        this.meta = meta;
    }
}
