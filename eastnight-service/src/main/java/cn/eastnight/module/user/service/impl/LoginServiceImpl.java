package cn.eastnight.module.user.service.impl;

import cn.eastnight.module.user.entry.LoginParam;
import cn.eastnight.module.user.entry.LoginUserInfo;
import cn.eastnight.module.user.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

/**
 * <p>标题：</p>
 * <p>功能：</p>
 * <p>作者：屈晓东</p>
 * <p>类名称：cn.eastnight.module.user.service.impl.LoginServiceImpl</p>
 * <p>创建日期：2021/7/13 19:28</p>
 */
@Service(LoginService.beanName)
public class LoginServiceImpl implements LoginService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public String login(LoginParam loginParam) {
        String username = loginParam.getUsername();
        String password = loginParam.getPassword();
        //TODO
        // 用户验证
        Authentication authentication = null;
        try {
            // 该方法会去调用UserDetailsServiceImpl.loadUserByUsername
            authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (Exception e) {
           /* if (e instanceof BadCredentialsException) {
                AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL, MessageUtils.message("user.password.not.match")));
                throw new UserPasswordNotMatchException();
            } else {
                AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL, e.getMessage()));
                throw new CustomException(e.getMessage());
            }*/
        }
        //AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_SUCCESS, MessageUtils.message("user.login.success")));
        LoginUserInfo loginUser = (LoginUserInfo) authentication.getPrincipal();
        //recordLoginInfo(loginUser.getUser());
        // 生成token
        return null;//tokenService.createToken(loginUser);
    }
}
