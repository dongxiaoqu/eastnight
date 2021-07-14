package cn.eastnight.module.user;

import cn.eastnight.module.user.entry.LoginParam;
import cn.eastnight.module.user.entry.UserEntry;
import cn.eastnight.module.user.service.LoginService;
import cn.eastnight.module.user.service.UserService;
import cn.wnsoft.wnadk.base.entry.WnsoftResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    LoginService loginService;

    @RequestMapping("/getAllUser")
    @ResponseBody
    public List<UserEntry> getAllUser() {
        return userService.getAllUsers();
    }

    @RequestMapping("/login")
    public WnsoftResponse login(@RequestBody LoginParam loginParam) {
        //
        loginService.login(loginParam);
        return null;
    }
}
