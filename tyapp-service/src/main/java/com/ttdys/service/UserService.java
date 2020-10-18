package com.ttdys.service;

import com.ttdys.common.http.Response;
import com.ttdys.data.entity.User;
import com.ttdys.data.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService extends BaseService<User, UserMapper> {

    //query all
    public Response<List<User>> listAll() {
        List<User> res = mapper.selectAll();
        return Response.success(res);
    }

}
