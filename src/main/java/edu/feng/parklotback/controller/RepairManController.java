package edu.feng.parklotback.controller;

import edu.feng.parklotback.pojo.RepairMan;
import edu.feng.parklotback.result.Result;
import edu.feng.parklotback.service.RepairManService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

/**
 * @program: parklot-back
 * @description: 维修人员控制层
 * @author: feng
 * @create: 2020-04-01 10:56
 */
@RestController
public class RepairManController {

    @Autowired
    RepairManService repairManService;

    RepairMan repairManSess;

    @CrossOrigin
    @PostMapping(value = "/api/repairman/login")
    @ResponseBody
    public Result login(@RequestBody RepairMan requestuser) {
        // 对html进行转义，防止xss攻击
        String username = requestuser.getUsername();
        username = HtmlUtils.htmlEscape(username);

        RepairMan repairMan = repairManService.findUserByNameAndPassword(username, requestuser.getPassword());

        System.out.println(username+"密码" +  requestuser.getPassword());
        if (null == repairMan) {
            String message = "账号密码错误";
            System.out.println("test");
            return new Result(400);
        } else {
            System.out.println(200);
//            session.setAttribute("user", user);
//            System.out.println("session" + session);
//            parkingUserSess = user;
            repairManSess = repairManService.findUserByNameAndPasswordToSess(username, requestuser.getPassword());
            return new Result(200);
        }
    }
    @CrossOrigin
    @PostMapping("api/repairman/getuser")
    public RepairMan getUser() {
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        ParkingUser parkingUser = (ParkingUser) request.getSession().getAttribute("user");
        return repairManSess;
    }

    @CrossOrigin
    @PostMapping("api/repairman/merge")
    public RepairMan merge(@RequestBody RepairMan repairMan) {
        System.out.println("useriddddd" + repairMan.getId() + "name" + repairMan.getUsername());
        if ((repairMan.getId() == null) || (repairMan.getId() == 0)){
            repairManService.save(repairMan);
        }else {
            repairManService.updateById(repairMan);
        }
        return repairMan;
    }

//    @CrossOrigin
//    @PostMapping("api/parkuser/merge")
//    public ParkingUser merge(@RequestBody ParkingUser parkingUser) {
//        System.out.println("useriddddd" + parkingUser.getId() + "name" + parkingUser.getUsername());
//        if ((parkingUser.getId() == null) || (parkingUser.getId() == 0)){
//            parkingUserService.save(parkingUser);
//        }else {
//            parkingUserService.updateById(parkingUser);
//        }
//        return parkingUser;
//    }
//
//
//    @CrossOrigin
//    @PostMapping("api/parkuser/getuser")
//    public ParkingUser getUser() {
////        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
////        ParkingUser parkingUser = (ParkingUser) request.getSession().getAttribute("user");
//        return parkingUserSess;
//    }

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