package cn.eastnight.module.user.entry;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>标题：登录参数实体</p>
 * <p>功能：</p>
 * <p>作者：屈晓东</p>
 * <p>类名称：cn.eastnight.module.user.entry.LoginParam</p>
 * <p>创建日期：2021/7/13 19:11</p>
 */
@Data
public class LoginParam implements Serializable {
    private String username;
    private String password;
    private String ticket;
    private String randstr;

}
