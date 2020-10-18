package com.ttdys.service;

import com.ttdys.common.exception.ErrorCode;
import com.ttdys.common.exception.ServiceException;
import com.ttdys.common.http.Response;
import com.ttdys.data.dto.LoginDTO;
import com.ttdys.data.dto.TokenDTO;
import com.ttdys.data.entity.User;
import com.ttdys.data.mapper.UserMapper;
import com.ttdys.service.utils.JwtGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import static org.apache.commons.lang3.StringUtils.isAnyBlank;

@Slf4j
@Service
public class LoginService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private JwtGenerator jwtGenerator;

    public Response<TokenDTO> login(LoginDTO dto) {
        try {
            checkLogin(dto);
            User user = getUser(dto.getUsername());
            if(user == null)
                return Response.error(ErrorCode.USERNAME_ERROR);
            if(!user.getPassword().equals(dto.getPassword()))
                return Response.error(ErrorCode.PASSWORD_ERROR);
            TokenDTO token = new TokenDTO();
            token.setToken(jwtGenerator.generate(user.getId()));
            return Response.success(token);
        } catch (ServiceException e) {
            log.info("登录失败，code<{}>, msg<{}>", e.getCode(), e.getMsg());
            return Response.error(e);
        }

    }

    private void checkLogin(LoginDTO dto) throws ServiceException {
        if(isAnyBlank(dto.getUsername(), dto.getPassword())) {
            throw new ServiceException(ErrorCode.LACK_ARGUMENTS);
        }
    }

    private User getUser(String username) {
        User param = new User();
        param.setUsername(username);
        return userMapper.selectOne(param);
    }

}
