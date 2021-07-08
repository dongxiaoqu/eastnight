package cn.eastnight.module.user.service.impl;

import cn.eastnight.module.user.entry.UserEntry;
import cn.eastnight.module.user.mapper.UserDao;
import cn.eastnight.module.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("EastNight-UserService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<UserEntry> getAllUsers() {
        return userDao.getAllUser();
    }
}
