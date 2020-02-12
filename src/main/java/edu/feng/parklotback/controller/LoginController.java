package edu.feng.parklotback.controller;

import edu.feng.parklotback.pojo.User;
import edu.feng.parklotback.result.Result;
import edu.feng.parklotback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpSession;
import java.util.Objects;

@Controller
public class LoginController{
    @Autowired
    UserService userService;

    @CrossOrigin
    @PostMapping(value = "api/login")
    @ResponseBody
    public Result login(@RequestBody User requestuser,  HttpSession session) {
        // 对html进行转义，防止xss攻击
        String username = requestuser.getUsername();
        username = HtmlUtils.htmlEscape(username);

        User user = userService.get(username, requestuser.getPassword());
        System.out.println(username+"mima" +  requestuser.getPassword());
        if (null == user) {
            String message = "账号密码错误";
            System.out.println("test");
            return new Result(400);
        } else {
            System.out.println(200);
            session.setAttribute("user", user);
            return new Result(200);
        }
    }
}
