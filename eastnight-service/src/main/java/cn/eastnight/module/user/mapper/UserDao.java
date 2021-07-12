package cn.eastnight.module.user.mapper;

import cn.eastnight.module.user.entry.UserEntry;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    /**
     * 获取所有用户
     * @return
     */
    List<UserEntry> getAllUser();

    /**
     * 通过用户名获取用户实体
     *
     * @param username
     * @return
     */
    UserEntry getUserByUsername(String username);
}