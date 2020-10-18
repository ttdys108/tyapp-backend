package com.ttdys.web.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ttdys.common.http.Response;
import com.ttdys.data.dto.LoginDTO;
import com.ttdys.data.dto.TokenDTO;
import com.ttdys.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public Response<TokenDTO> login(LoginDTO dto) {
        log.info("登录请求<{}>", JSON.toJSONString(dto));
        return loginService.login(dto);
    }



}
