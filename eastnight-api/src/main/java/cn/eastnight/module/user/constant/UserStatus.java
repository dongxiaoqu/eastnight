package cn.eastnight.module.user.constant;

/**
 * <p>标题：用户状态枚举类</p>
 * <p>功能：</p>
 * <p>作者：屈晓东</p>
 * <p>创建日期：2021/7/13 12:15</p>
 */
public enum UserStatus {
    NORMAL("0", "正常"), DISABLE("1", "停用"), DELETED("2", "删除");

    private final String code;
    private final String info;

    UserStatus(String code, String info) {
        this.code = code;
        this.info = info;
    }

    public String getCode() {
        return code;
    }

    public String getInfo() {
        return info;
    }
}
