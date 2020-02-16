package edu.feng.parklotback.controller;

import edu.feng.parklotback.mapper.UserMapper;
import edu.feng.parklotback.pojo.User;
import edu.feng.parklotback.result.Result;
//import edu.feng.parklotback.service.Impl.UserService;
import edu.feng.parklotback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpSession;
import java.util.*;

@RestController
public class LoginController{
    @Autowired
    UserService userService;

    @CrossOrigin
    @PostMapping(value = "/api/login")
    @ResponseBody
    public Result login(@RequestBody User requestuser) {
        // 对html进行转义，防止xss攻击
        String username = requestuser.getUsername();
        username = HtmlUtils.htmlEscape(username);

        User user = userService.findUserByNameAndPassword(username, requestuser.getPassword());

        System.out.println(username+"密码" +  requestuser.getPassword());
        if (null == user) {
            String message = "账号密码错误";
            System.out.println("test");
            return new Result(400);
        } else {
            System.out.println(200);
//            session.setAttribute("user", user);
            return new Result(200);
        }
    }

    @CrossOrigin
    @PostMapping("/api/user/merge")
    public User merge(@RequestBody User user) throws Exception {
        System.out.println("ronghe" + user);

        // 修改
        if (user.getId() == null || user.getId() == 0){
            userService.save(user);
        }else {
            System.out.println("被调用");
            userService.updateById(user);
        }
        return user;
    }



    // 若是实际使用删除不了 应在int id前加@PathVariable 并在路径上加上{id}

    @CrossOrigin
    @PostMapping("/api/user/delete")
    public void delete(@RequestBody User user) throws Exception {
        userService.delete(user.getId());
    }
    @RequestMapping("/get")
    public Collection<User> getListMap(String username, String password){
        Map<String,Object> map = new HashMap<>();
        //kay是字段名 value是字段值
        map.put("username",username);
        map.put("password",password);
        Collection<User> userInfoEntityList = userService.listByMap(map);
        return userInfoEntityList;
    }

    @CrossOrigin
    @GetMapping("/api/user/getall")
    public List<User> getAlL() {
        return userService.findAll();
    }


}
