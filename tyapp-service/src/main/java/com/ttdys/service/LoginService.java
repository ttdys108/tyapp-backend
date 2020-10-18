package com.ttdys.service;

import com.ttdys.common.http.Response;
import com.ttdys.data.dto.LoginDTO;
import com.ttdys.data.dto.TokenDTO;
import com.ttdys.data.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private UserMapper userMapper;


    public Response<TokenDTO> login(LoginDTO dto) {
        TokenDTO token = new TokenDTO();
        token.setToken("123123");
        return Response.success(token);

    }

}
