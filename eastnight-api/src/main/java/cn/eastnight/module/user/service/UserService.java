package cn.eastnight.module.user.service;

import cn.eastnight.module.user.entry.UserEntry;

import java.util.List;

public interface UserService {
    public final static String beanName = "EastNight-UserService";
    public List<UserEntry> getAllUsers();
}
