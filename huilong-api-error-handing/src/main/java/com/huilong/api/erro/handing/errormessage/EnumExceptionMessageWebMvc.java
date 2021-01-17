package com.huilong.api.erro.handing.errormessage;

import lombok.Getter;

/**
 * @Date: 2020/10/11 11:47
 * @Author: DengHuiLong
 * @Description: WebMvc 模块异常码定义
 * 系统标识：100
 * 模块标识：02
 */
@Getter
public enum EnumExceptionMessageWebMvc {

    // 非预期异常
    UNEXPECTED_ERROR(10002000L, "服务发生非预期异常，请联系管理员！"),
    PARAM_VALIDATED_UN_PASS(10002001L, "参数校验(JSR303)不通过，请检查参数或联系管理员！"),
    NO_HANDLER_FOUND_ERROR(10002002L, "未找到对应的处理器，请检查 API 或联系管理员！"),
    HTTP_REQUEST_METHOD_NOT_SUPPORTED_ERROR(10002003L, "不支持的请求方法，请检查 API 或联系管理员！"),
    HTTP_MEDIA_TYPE_NOT_SUPPORTED_ERROR(10002004L, "不支持的互联网媒体类型，请检查 API 或联系管理员"),
    ;
    private final Long code;

    private final String message;

    EnumExceptionMessageWebMvc(Long code, String message) {
        this.code = code;
        this.message = message;
    }
}
