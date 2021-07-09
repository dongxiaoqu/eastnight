package cn.eastnight.module.user.mapper;

import cn.eastnight.module.user.entry.PostEntry;

public interface PostDao {
    int deleteByPrimaryKey(String postId);

    int insert(PostEntry record);

    int insertSelective(PostEntry record);

    PostEntry selectByPrimaryKey(String postId);

    int updateByPrimaryKeySelective(PostEntry record);

    int updateByPrimaryKey(PostEntry record);
}