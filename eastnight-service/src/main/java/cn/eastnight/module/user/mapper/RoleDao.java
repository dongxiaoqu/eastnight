package cn.eastnight.module.user.mapper;

import cn.eastnight.module.user.entry.RoleEntry;

public interface RoleDao {
    int deleteByPrimaryKey(Long roleId);

    int insert(RoleEntry record);

    int insertSelective(RoleEntry record);

    RoleEntry selectByPrimaryKey(Long roleId);

    int updateByPrimaryKeySelective(RoleEntry record);

    int updateByPrimaryKey(RoleEntry record);
}