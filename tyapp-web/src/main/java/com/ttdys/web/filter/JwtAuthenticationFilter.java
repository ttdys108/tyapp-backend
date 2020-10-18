package com.ttdys.web.filter;

import com.ttdys.data.entity.User;
import com.ttdys.data.mapper.UserMapper;
import com.ttdys.service.UserService;
import com.ttdys.service.security.SUser;
import com.ttdys.service.utils.JwtGenerator;
import com.ttdys.service.utils.TokenExtractor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private JwtGenerator jwtGenerator;
    private UserMapper userMapper;

    public  JwtAuthenticationFilter(UserMapper userMapper, JwtGenerator jwtGenerator) {
        this.userMapper = userMapper;
        this.jwtGenerator = jwtGenerator;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = TokenExtractor.extractToken(request);
        if(isNotBlank(token)) {//根据token获取用户信息
            Long uid = jwtGenerator.extractUid(token);
            if(uid != null) {
                User user = userMapper.selectByPrimaryKey(uid);
                if(user != null) { //设置登录状态
                    SUser suser = SUser.of(user.getUsername(), user.getPassword());
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(suser, null, suser.getAuthorities());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        }
        filterChain.doFilter(request, response);
    }


}
