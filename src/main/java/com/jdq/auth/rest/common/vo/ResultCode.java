package com.jdq.auth.rest.common.vo;

import cn.hutool.core.util.StrUtil;

public enum ResultCode implements BaseResultCode{

    //通用成功
    SUCCESS("0000", "操作成功！"),

    //通用错误
    GATEWAY_ERROR("0001", "服务器异常！"),
    PARAMS_MISSING_ERROR("0003", "参数不完整！"),
    PARAMS_FORMAT_ERROR("0004", "请求参数格式错误！"),
    UN_AUTH_ERROR("0009", "暂无权限访问！"),
    SIGN_VERIFY_ERROR("0010", "签名校验失败！"),
    MAX_UPLOAD_SIZE("0012", "文件大小不可超过512KB！"),
    FEIGN_RETURN_ERR("0016", "feign返回格式错误"),
    TOKEN_INVALID("0017", "TOKEN无效"),
    TOKEN_EXPIRED("0018", "TOKEN已超时"),
    DATA_NOT_EXIST("0020", "请求数据不存在"),
    IS_AUDIT_CANT_MODIFY("0021", "已审核无法修改"),
    NAME_IS_EXIST("0022", "名称已存在"),
    CODE_IS_EXIST("0023", "编号已存在"),

    ITPS_INTERFACE_ERROR("0030", "调用外部服务错误0030"),

    ACCOUNT_NOT_EXIST("0100", "账户或密码错误"),
    PASSWORD_ERROR("0101", "账户或密码错误"),
    PASSWORD_POWER_NOT_ENOUGH("0110", "密码强度不足，请在6到32位之间，并包含数字和字母"),

    PRODUCT_HAVE_RECORD("0200", "商品已有售出记录无法删除"),
    PRODUCT_SELL_OUT("0201", "商品已售罄"),
    PRODUCT_STOCK_NOT_ENOUGH("0202", "商品库存不足"),
    EXCHANGE_CHANCE_EXCESS_PERIOD("0203", "兑换次数已达上限"),
    EXCHANGE_TIME_LESS("0204", "兑换剩余次数不足"),
    CREDIT_NOT_EXCHANGE("0205", "积分不足"),
    PRODUCT_NOT_SALE("0206", "商品未发售"),

    CREDIT_RECORD_IS_EXIST("0300", "积分记录已存在"),
    CREDIT_NOT_ENOUGH("0301", "积分不足"),

    //限制预约异常
    RESTRICT_APPOINTMENTS_RECORD_NOT_EXIST("1000", "限制预约记录不存在"),
    EFFECT_STATUS_ERROR("1001", "限制预约生效状态输入错误"),
    EFFECT_RECORD_NOT_UPDATE("1002", "已生效的数据无法进行修改"),
    TIME_NOT_REPEAT("1003", "预约限制时间不能与已有数据重合"),

    //预约管理异常
    RESERVATION_NOT_EXIST("2001", "该预约不存在"),
    RESERVATION_TYPE_NOT_VERIFY("2002", "该预约类型无法审核"),
    RESERVATION_STATUS_NOT_VERIFY("2003", "该预约的状态当前无法进行审核"),
    VERIFY_STATUS_ERROR("2004", "审核状态错误"),

    BUSINESS_EXCEPTION("0101", "预约参数未设置，不能进行预约")
    ;

    private String msg;
    private String code;

    ResultCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 根据code获取枚举值
     *
     * @param code
     * @return
     */
    public static ResultCode getResultCodeByType(String code) {
        ResultCode[] values = ResultCode.values();
        for (ResultCode value : values) {
            if (StrUtil.equals(value.getCode(), code)) {
                return value;
            }
        }
        return ResultCode.GATEWAY_ERROR;
    }

    @Override
    public String getMsg() {
        return this.msg;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    public boolean isOk() {
        return StrUtil.equals("0000", this.code);
    }
}