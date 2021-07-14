package cn.eastnight.module.user.service;

import cn.eastnight.module.user.entry.UserEntry;

import java.util.Set;
/**
 * <p>标题：权限Service接口</p>
 * <p>功能：</p>
 * <p>作者：屈晓东</p>
 * <p>创建日期：2021/7/13 12:15</p>
 */
public interface PermissionService {
    public final static String beanName = "EastNight-UserService";
    /**
     * 获取角色权限
     * @param user
     * @return
     */
    public Set<String> getRolePermission(UserEntry user);

    /**
     * 获取菜单权限
     * @param user
     * @return
     */
    public Set<String> getMenuPermission(UserEntry user);
}
