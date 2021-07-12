package cn.eastnight.module.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * <p>标题：</p>
 * <p>功能：</p>
 * <p>作者：屈晓东</p>
 * <p>类名称：cn.eastnight.module.test.CrmGZYAcceptController</p>
 * <p>创建日期：2021/7/9 14:04</p>
 */
@Controller
public class CrmGZYAcceptController {
    @RequestMapping(value = "/sendMessage")
    public void sendMessage(@RequestBody Map<String,Object> param){
        System.out.println("接受到消息：");
    }
}
