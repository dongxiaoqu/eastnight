package cn.eastnight.module.user.mapper;

import cn.eastnight.module.user.entry.DeptEntry;

public interface DeptDao {
    int deleteByPrimaryKey(String deptId);

    int insert(DeptEntry record);

    int insertSelective(DeptEntry record);

    DeptEntry selectByPrimaryKey(String deptId);

    int updateByPrimaryKeySelective(DeptEntry record);

    int updateByPrimaryKey(DeptEntry record);
}