package com.novawind.mourn.dto;

import com.novawind.mourn.constant.ResponseCode;

/**
 * @author Jeremy Xiong<br>
 * 2017-12-25 15:40
 */
public class AdminAccessDto {

    private String token;
    private String series;
    private String code;
    private String sessionId;
    private String name;
    private ResponseCode responseCode;

    public String getToken () {
        return token;
    }
    public void setToken (String token) {
        this.token = token;
    }
    public String getSeries () {
        return series;
    }
    public void setSeries (String series) {
        this.series = series;
    }
    public String getCode () {
        return code;
    }
    public void setCode (String code) {
        this.code = code;
    }
    public String getSessionId () {
        return sessionId;
    }
    public void setSessionId (String sessionId) {
        this.sessionId = sessionId;
    }
    public String getName () {
        return name;
    }
    public void setName (String name) {
        this.name = name;
    }
    public ResponseCode getResponseCode () {
        return responseCode;
    }
    public void setResponseCode (ResponseCode responseCode) {
        this.responseCode = responseCode;
    }
}
