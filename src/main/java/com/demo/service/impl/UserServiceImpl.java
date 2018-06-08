package com.demo.service.impl;

import com.demo.dao.UserDao;
import com.demo.dao.UserLoginRecordDao;
import com.demo.model.User;
import com.demo.model.dto.CustomUserDetails;
import com.demo.service.UserService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Desciption 用户Service层
 * Create By  li.bo
 * CreateTime 2018/3/13 14:15
 * UpdateTime 2018/3/13 14:15
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserLoginRecordDao userLoginRecordDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.getUserByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("Could not find the user '" + username + "'");
        }
        // Not involve authorities, so pass null to authorities
        return new CustomUserDetails(user, true, true, true, true, null);
    }

    @Override
    public User getOne(String username) {

        return userDao.getUserByUsername(username);
    }

    @Override
    public int saveUserLoginRecord(Long userId, String ip) {

        return userLoginRecordDao.saveOne(userId, ip);
    }
}
