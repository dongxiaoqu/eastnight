package cn.eastnight.module.user.mapper;

import cn.eastnight.module.user.entry.MenuEntry;

public interface MenuDao {
    int deleteByPrimaryKey(Long menuId);

    int insert(MenuEntry record);

    int insertSelective(MenuEntry record);

    MenuEntry selectByPrimaryKey(Long menuId);

    int updateByPrimaryKeySelective(MenuEntry record);

    int updateByPrimaryKey(MenuEntry record);
}