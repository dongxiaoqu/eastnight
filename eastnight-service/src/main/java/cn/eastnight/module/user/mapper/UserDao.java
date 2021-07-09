package cn.eastnight.module.user.mapper;

import cn.eastnight.module.user.entry.UserEntry;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    int deleteByPrimaryKey(String userId);

    int insert(UserEntry record);

    int insertSelective(UserEntry record);

    UserEntry selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(UserEntry record);

    int updateByPrimaryKey(UserEntry record);

    List<UserEntry> getAllUser();
}