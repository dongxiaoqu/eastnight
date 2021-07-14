package cn.eastnight.module.user.service.impl;

import cn.eastnight.module.user.entry.UserEntry;
import cn.eastnight.module.user.service.PermissionService;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * <p>标题：</p>
 * <p>功能：</p>
 * <p>作者：屈晓东</p>
 * <p>类名称：cn.eastnight.module.user.service.impl.PermissionServiceImpl</p>
 * <p>创建日期：2021/7/13 19:00</p>
 */
@Service(PermissionService.beanName)
public class PermissionServiceImpl implements PermissionService {

    @Override
    public Set<String> getRolePermission(UserEntry user) {
        return null;
    }

    @Override
    public Set<String> getMenuPermission(UserEntry user) {
        return null;
    }
}
