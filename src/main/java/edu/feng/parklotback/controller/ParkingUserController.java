package edu.feng.parklotback.controller;

import edu.feng.parklotback.pojo.ParkingUser;
import edu.feng.parklotback.pojo.User;
import edu.feng.parklotback.result.Result;
import edu.feng.parklotback.service.ParkingUserService;
import edu.feng.parklotback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import edu.feng.parklotback.service.Impl.UserService;

@RestController
public class ParkingUserController {
    @Autowired
    UserService userService;

    @Autowired
    ParkingUserService parkingUserService;

    ParkingUser parkingUserSess;

    @CrossOrigin
    @PostMapping(value = "/api/parking/login")
    @ResponseBody
    public Result login(@RequestBody User requestuser) {
        // 对html进行转义，防止xss攻击
        String username = requestuser.getUsername();
        username = HtmlUtils.htmlEscape(username);

        ParkingUser user = parkingUserService.findUserByNameAndPassword(username, requestuser.getPassword());

        System.out.println(username+"密码" +  requestuser.getPassword());
        if (null == user) {
            String message = "账号密码错误";
            System.out.println("test");
            return new Result(400);
        } else {
            System.out.println(200);
//            session.setAttribute("user", user);
//            System.out.println("session" + session);
//            parkingUserSess = user;
            parkingUserSess = parkingUserService.findUserByNameAndPasswordToSess(username, requestuser.getPassword());
            return new Result(200);
        }
    }


    @CrossOrigin
    @PostMapping("api/parkuser/merge")
    public ParkingUser merge(@RequestBody ParkingUser parkingUser) {
        System.out.println("useriddddd" + parkingUser.getId() + "name" + parkingUser.getUsername());
        if ((null == parkingUser.getId() || (parkingUser.getId() == 0))){
            parkingUserService.save(parkingUser);
        } else {
                parkingUserService.updateById(parkingUser);
        }
        return parkingUser;
    }


    @CrossOrigin
    @PostMapping("api/parkuser/getuser")
    public ParkingUser getUser() {
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        ParkingUser parkingUser = (ParkingUser) request.getSession().getAttribute("user");
        return parkingUserSess;
    }

//    @CrossOrigin
//    @PostMapping("/api/user/merge")
//    public User merge(@RequestBody User user) throws Exception {
//        System.out.println("ronghe" + user);
//
//        // 修改
//        if (user.getId() == null || user.getId() == 0){
//            userService.save(user);
//        }else {
//            System.out.println("被调用");
//            userService.updateById(user);
//        }
//        return user;
//    }
//
//
//
//    // 若是实际使用删除不了 应在int id前加@PathVariable 并在路径上加上{id}
//
//    @CrossOrigin
//    @PostMapping("/api/user/delete")
//    public void delete(@RequestBody User user) throws Exception {
//        userService.delete(user.getId());
//    }
//    @RequestMapping("/get")
//    public Collection<User> getListMap(String username, String password){
//        Map<String,Object> map = new HashMap<>();
//        //kay是字段名 value是字段值
//        map.put("username",username);
//        map.put("password",password);
//        Collection<User> userInfoEntityList = userService.listByMap(map);
//        return userInfoEntityList;
//    }
//
//    @CrossOrigin
//    @GetMapping("/api/user/getall")
//    public List<User> getAlL() {
//        return userService.findAll();
//    }


}
