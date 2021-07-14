package cn.eastnight.module.user.service.impl;

import cn.eastnight.module.user.constant.UserStatus;
import cn.eastnight.module.user.entry.LoginUserInfo;
import cn.eastnight.module.user.entry.UserEntry;
import cn.eastnight.module.user.mapper.UserDao;
import cn.eastnight.module.user.service.PermissionService;
import cn.eastnight.module.user.service.UserService;
import cn.wnsoft.wnadk.base.exception.BaseException;
import cn.wnsoft.wnadk.base.util.StrUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(UserService.beanName)
public class UserServiceImpl implements UserDetailsService, UserService {

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserDao userDao;
    private PermissionService permissionService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntry user = userDao.getUserByUsername(username);
        if (StrUtils.isNull(user.toString())) {
            logger.info("登录用户：{} 不存在.", username);
            throw new UsernameNotFoundException("登录用户：" + username + " 不存在");
        } else if (UserStatus.DELETED.getCode().equals(user.getDelFlag())) {
            logger.info("登录用户：{} 已被删除.", username);
            throw new BaseException("对不起，您的账号：" + username + " 已被删除");
        } else if (UserStatus.DISABLE.getCode().equals(user.getStatus())) {
            logger.info("登录用户：{} 已被停用.", username);
            throw new BaseException("对不起，您的账号：" + username + " 已停用");
        }
        return createLoginUser(user);
    }

    private UserDetails createLoginUser(UserEntry user) {
        return new LoginUserInfo(user, permissionService.getMenuPermission(user));
    }

    @Override
    public List<UserEntry> getAllUsers() {
        return userDao.getAllUser();
    }
}
