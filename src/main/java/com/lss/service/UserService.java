package com.lss.service;

import com.lss.domain.User;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/8/7.
 */
@Service
public interface UserService {
    User getUser(User user);
}
