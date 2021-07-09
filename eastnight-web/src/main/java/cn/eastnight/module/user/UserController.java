package cn.eastnight.module.user;

import cn.eastnight.module.user.entry.UserEntry;
import cn.eastnight.module.user.mapper.UserDao;
import cn.eastnight.module.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;
    @RequestMapping("/getAllUser")
    @ResponseBody
    public List<UserEntry> getAllUser(){
        return userService.getAllUsers();
    }
}
