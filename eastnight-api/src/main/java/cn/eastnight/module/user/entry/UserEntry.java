package cn.eastnight.module.user.entry;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;

@Data
public class UserEntry implements UserDetails {
    private String userId;

    private String username;

    private String password;

    private String nickname;

    private String mobile;

    private String email;

    private String gender;

    private Short age;

    private String status;

    private String userType;

    private String delFlag;

    private String remark;

    private String creator;

    private Date createTime;

    private String modifier;

    private Date modifyTime;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}