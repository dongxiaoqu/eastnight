package cn.eastnight.module.user.service;

import cn.eastnight.module.user.entry.LoginParam;

/**
 * <p>标题：</p>
 * <p>功能：</p>
 * <p>作者：屈晓东</p>
 * <p>类名称：cn.eastnight.module.user.service.LoginService</p>
 * <p>创建日期：2021/7/13 19:16</p>
 */
public interface LoginService {
    public final static String beanName = "EastNight-LoginService";

    /**
     * 登录
     * @param loginParam
     * @return
     */
    public String login(LoginParam loginParam);
}
