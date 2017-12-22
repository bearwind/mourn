package com.novawind.mourn.constant;

/**
 * @author Jeremy Xiong<br>
 * 2017-12-22 09:55
 */
public enum ResponseCode {

    SUCCESS("01", "成功"), FAIL("00", "失败"), BAD_NAME_PWD("09", "用户名或密码错误");

    private String code;
    private String msg;

    ResponseCode(String code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public String getCode () {
        return code;
    }
    public void setCode (String code) {
        this.code = code;
    }
    public String getMsg () {
        return msg;
    }
    public void setMsg (String msg) {
        this.msg = msg;
    }
}
