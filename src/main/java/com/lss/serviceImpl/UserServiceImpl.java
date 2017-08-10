package com.lss.serviceImpl;

import com.lss.domain.User;
import com.lss.mapper.UserMapper;
import com.lss.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by Administrator on 2017/8/7.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User getUser(User user) {
        User user01 = userMapper.selectByUser(user);
        return user01;
    }
}
