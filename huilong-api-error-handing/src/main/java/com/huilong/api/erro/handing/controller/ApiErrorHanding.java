package com.huilong.api.erro.handing.controller;

import com.huilong.api.erro.handing.exception.ExtensionException;
import com.huilong.api.erro.handing.model.ValidatedModel;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @Date: 2020/10/11 12:00
 * @Author: DengHuiLong
 * @Description:
 */
@RestController
@RequestMapping("/api_error_handing")
public class ApiErrorHanding {

    // 此处只是简单演示，逻辑处理应该抽象在 mvc 分层中，业务开发过程中只需要抛异常即可。
    @GetMapping
    public String get() {
        throw new ExtensionException(105001001L, "simple 资源不存在");
    }

    // 此处只是简单演示
    @PostMapping("/test/validated")
    public String getx(@Validated @RequestBody ValidatedModel model) {
        return model.getName();
    }
}
