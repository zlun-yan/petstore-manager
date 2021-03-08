package org.csu.petstore.base;

import java.util.HashMap;
import java.util.Map;

public enum ResponseCode {

    /**
     * 接口调用成功
     **/
    SUCCESS(200, "success"),

    /**
     * 系统异常，请联系管理员
     **/
    SYSTEM_ERROR(500, "system error"),

    PARAMS_EMPTY_901(901, "params is null"),

    LOGIN_VALIDATE_FAILURE_902(902, "登录验证失败"),

    LOGIN_USERNAME_OR_PASSWORD_ERROR_903(903, "账号或密码错误"),

    USER_EXISTS_ERROR_904(904, "账号已存在"),

    USER_NOT_LOGIN_905(905, "请先登录"),

    UPLOAD_FILE_FORMAT_IS_WRONG_906(906, "上传文件格式不对"),

    UPLOAD_FILE_VALIDATE_NULL_907(907, "上传文件为空"),

    ;
    private static Map<Integer, ResponseCode> codeMap = new HashMap<Integer, ResponseCode>();

    private Integer code;

    private String msg;

    private String value;

    /**
     *
     */
    private ResponseCode() {
    }

    /**
     * @param value
     */
    private ResponseCode(String value) {
        this.value = value;
    }

    /**
     * @param code
     * @param msg
     */
    private ResponseCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * @return
     */
    public Integer code() {
        return this.code;
    }

    /**
     * @return
     */
    public String msg() {
        return this.msg;
    }

    /**
     * @return
     */
    public String value() {
        return this.value;
    }

    /**
     * @param codeValue
     * @return
     */
    public static ResponseCode getInstance(Integer codeValue) {
        return getCodeMap().get(codeValue);
    }

    /**
     * @return
     */
    private static Map<Integer, ResponseCode> getCodeMap() {
        if (codeMap == null || codeMap.size() == 0) {
            ResponseCode[] codeList = ResponseCode.values();
            for (ResponseCode c : codeList) {
                codeMap.put(c.code(), c);
            }
        }
        return codeMap;
    }
}
