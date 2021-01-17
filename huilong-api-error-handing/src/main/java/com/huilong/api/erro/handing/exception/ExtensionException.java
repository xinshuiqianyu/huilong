package com.huilong.api.erro.handing.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @Date: 2020/10/11 11:42
 * @Author: DengHuiLong
 * @Description: 扩展异常
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ExtensionException extends RuntimeException {

    /**
     * 业务异常码 ( 详情参加文档说明 )
     */
    private Long code;

    /**
     * 业务异常信息
     */
    private String message;

    /**
     * 额外数据，可支持扩展
     */
    private Object data;

    /**
     * cause
     */
    private Throwable cause;

    public ExtensionException(Long code, String message) {
        this.code = code;
        this.message = message;
    }
}
