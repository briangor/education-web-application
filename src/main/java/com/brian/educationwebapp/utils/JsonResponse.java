package com.brian.educationwebapp.utils;

/**
 *
 * @author brian
 */
public class JsonResponse {

    private Integer response_code;
    private String response_msg;

    public JsonResponse() {
    }

    public Integer getResponse_code() {
        return response_code;
    }

    public void setResponse_code(Integer response_code) {
        this.response_code = response_code;
    }

    public String getResponse_msg() {
        return response_msg;
    }

    public void setResponse_msg(String response_msg) {
        this.response_msg = response_msg;
    }
}
