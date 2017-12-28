package com.novawind.mourn.constant;


/**
 * @author Jeremy Xiong<br>
 * 2017-12-22 09:55
 */
public enum ResponseCode {

    SUCCESS("01", "成功"),
    LOGOUT("02", "注销成功"),
    FAIL("00", "失败"), BAD_NAME_PWD("09", "用户名或密码错误"),
    SESSION_INVALID("96", "由于您长时间未操作，会话已失效"),
    BAD_TOKEN_OR_SERIES("97", "未启用自动登录或自动登录权限已过期"),
    COOKIE_DISABLED("98", "COOKIE被禁用或被删除，请保持COOKIE可用"),
    UNKNOW("99", "未知错误");

    private String code;
    private String msg;

    ResponseCode(String code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public static String getMsgByCode(String code){
        ResponseCode[] values = ResponseCode.values();
        for (ResponseCode value : values) {
            if(value.getCode().equals(code)){
                return value.getMsg();
            }
        }
        return UNKNOW.getMsg();
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
