package cn.eastnight.module.user.service.impl;

import cn.eastnight.module.user.entry.UserEntry;
import cn.eastnight.module.user.mapper.UserDao;
import cn.eastnight.module.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("EastNight-UserService")
public class UserServiceImpl implements UserDetailsService, UserService {
    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserDao userDao;

    @Override
    public UserEntry loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDao.getUserByUsername(username);
    }

    @Override
    public List<UserEntry> getAllUsers() {
        return userDao.getAllUser();
    }
}
