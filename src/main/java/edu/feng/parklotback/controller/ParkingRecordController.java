package edu.feng.parklotback.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import edu.feng.parklotback.badduapi.PlateAPITest;
import edu.feng.parklotback.pojo.ClientUser;
import edu.feng.parklotback.pojo.FeeRecode;
import edu.feng.parklotback.pojo.ParkingRecord;
import edu.feng.parklotback.result.Result;
import edu.feng.parklotback.service.ClientUserService;
import edu.feng.parklotback.service.FeeRecodeService;
import edu.feng.parklotback.service.ParkingRecordService;
import edu.feng.parklotback.service.ParkingSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.List;


/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author feng
 * @since 2020-01-14
 */
@Controller
//@RequestMapping("/parkingRecord")
public class ParkingRecordController {
    @Autowired
    ParkingRecordService parkingRecordService;
    @Autowired
    FeeRecodeService feeRecodeService;
    @Autowired
    ParkingSpaceService parkingSpaceService;
    @Autowired
    ClientUserService clientUserService;

    private static final long nd = 1000 * 24 * 60 * 60;
    private static final long nh = 1000 * 60 * 60;
    private static final long nm = 1000 * 60;


    @CrossOrigin
    @PostMapping("/api/parking/begin")
    @ResponseBody
    public String parkingBegin(@RequestParam(value = "file", required = false) MultipartFile file) throws Exception {
        String folder = "/Users/feng/Downloads/parkingBeginImg";
        File imageFolder = new File(folder);
        String imgURL = "";

        System.out.println(file.getOriginalFilename());

        File f = new File(imageFolder, file.getOriginalFilename());
//        NUM++;
        System.out.println("是否存在：" + f.getParentFile().exists() + f.getPath());
        if (!f.getParentFile().exists())
            f.getParentFile().mkdirs();

        // 识别用的path
        String path = "/Users/feng/Downloads/parkingBeginImg" + "/" + f.getName();

//        // 同步存储
//        String toImageFloder = "/Users/feng/Downloads/毕业车牌测试";
//        File aimageFolder = new File(folder);
//        File imageF = new File(aimageFolder, file.getOriginalFilename());
//        if (!imageF.getParentFile().exists())
//            imageF.getParentFile().mkdirs();


        System.out.println("最终path：" + path);
        try {
            // 将f放到文件去
            file.transferTo(f);

//            // 将图片同步存到毕业车牌测试里
//            file.transferTo(imageF);


            imgURL = "http://localhost:8443/api/file/" + f.getName();
//            return imgURL;
        } catch (IOException e) {
            e.printStackTrace();
//            return "";
        }
        System.out.println("识别path" + path);

        // 车牌识别
        PlateAPITest plateAPITest = new PlateAPITest();
        String plate = PlateAPITest.plateDetect(path);
        System.out.println("plate值：" + plate);


        if (plate.equals("282102")) {
            return "图片中无车牌";
        } else if (plate.equals("282103") || plate.equals("282810")) {
            return "车牌识别失败";
        } else {

            // 协议客户进场
            QueryWrapper<ClientUser> queryWrapper1 = new QueryWrapper<ClientUser>();
            queryWrapper1.like("client_plate", plate);
            ClientUser clientUser = clientUserService.getOne(queryWrapper1);

            System.out.println("协议客户？" + clientUser);
            //是协议客户，
            if (clientUser != null) {
                java.sql.Date beginTime1 = new java.sql.Date(new java.util.Date().getTime());

                System.out.println("beginTimee:" + beginTime1);
                // 存入数据库。停车记录
                ParkingRecord parkingRecord = new ParkingRecord();
                parkingRecord.setPlate(plate);
                parkingRecord.setBeginTime(beginTime1);
                parkingRecordService.save(parkingRecord);
                return plate + "  协议客户 ";
            }

            System.out.println(plate);
            // util里的时间可能不行
//            Date date = new Date();//获得系统时间.
//            SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy-MM-dd HH:mm:ss " );
//            String currentTime = sdf.format(date);
//            Date beginTime = sdf.parse( currentTime);
            java.sql.Date beginTime = new java.sql.Date(new java.util.Date().getTime());

            System.out.println("beginTimee:" + beginTime);
            // 存入数据库。停车记录
            ParkingRecord parkingRecord = new ParkingRecord();
            parkingRecord.setPlate(plate);
            parkingRecord.setBeginTime(beginTime);
            parkingRecordService.save(parkingRecord);

            // 车位变化
            parkingSpaceService.carEnter();
        }

        System.out.println("最终返回前端" + plate);
        return new String(plate);
    }

    // 出库
    @CrossOrigin
    @PostMapping("/api/parking/end")
    @ResponseBody
    public String parkingEnd(MultipartFile file) throws Exception {
        String folder = "/Users/feng/Downloads/parkingEndImg";
        File imageFolder = new File(folder);
        String imgURL = "";

        System.out.println(file.getOriginalFilename());

        File f = new File(imageFolder, file.getOriginalFilename());
//        NUM++;
        System.out.println("是否存在：" + f.getParentFile().exists() + f.getPath());
        if (!f.getParentFile().exists())
            f.getParentFile().mkdirs();

        String path = "/Users/feng/Downloads/parkingEndImg" + "/" + f.getName();
        System.out.println("最终path：" + path);
        System.out.println("f:  " + f);
        System.out.println("file: " + file);
        System.out.println("file.getName:" + file.getOriginalFilename());
        try {
            // 将f放到文件去
            file.transferTo(f);
            imgURL = "http://localhost:8443/api/file/" + f.getName();


//            return imgURL;
        } catch (IOException e) {
            e.printStackTrace();
//            return "";
        }
        PlateAPITest plateAPITest = new PlateAPITest();
        String plate = plateAPITest.plateDetect(path);

        System.out.println("plate值：" + plate);
        ClientUser clientUser = null;

        if ("282102".equals(plate)) {
            return "图片中无车牌";
        } else if ("282103".equals(plate) || "282810".equals(plate)) {
            return "车牌识别失败";
        } else {
            System.out.println(plate);
            // 协议客户出场
            QueryWrapper<ClientUser> queryWrapper1 = new QueryWrapper<ClientUser>();
            queryWrapper1.like("client_plate", plate);
            clientUser = clientUserService.getOne(queryWrapper1);
            System.out.println("协议客户？" + clientUser);

            // 是协议客户，且日期大于当前日期
            if (clientUser != null) {
                //时间模块
                java.util.Date date = new java.util.Date();//获得系统时间.
                SimpleDateFormat sdf = new SimpleDateFormat(" yyyy-MM-dd HH:mm:ss ");
                String currentTime = sdf.format(date);
                java.sql.Timestamp endTime1 = Timestamp.valueOf(currentTime);
                System.out.println("比较结果" + clientUser.getClientEnd().compareTo(endTime1));
                if (clientUser.getClientEnd().compareTo(endTime1) > 0) {
                    System.out.println("协议到期时间" + clientUser.getClientEnd());
                    System.out.println("当前时间" + endTime1);
                    System.out.println("beginTimee1:" + endTime1);
                    // 存入数据库。停车记录
                    System.out.println("endTime1:" + endTime1);

                    ParkingRecord parkingEndRecord = parkingRecordService.findByPlateAndEndTime(plate);
                    System.out.println("协议recode" + parkingEndRecord);
                    parkingEndRecord.setEndTime(endTime1);
                    parkingRecordService.saveOrUpdate(parkingEndRecord);
                    return plate + "  协议客户 ";
                }
            }

            // 时间处理模块
            // util里的时间可能不行
            java.util.Date date = new java.util.Date();//获得系统时间.
            SimpleDateFormat sdf = new SimpleDateFormat(" yyyy-MM-dd HH:mm:ss ");
            String currentTime = sdf.format(date);
            java.sql.Timestamp endTime = Timestamp.valueOf(currentTime);
            //Date beginTime = sdf.parse( currentTime);
            //java.sql.Date endTime = new java.sql.Date(new java.util.Date().getTime());


            System.out.println("endTime:" + endTime);
//            QueryWrapper<ParkingRecord> queryWrapper = new QueryWrapper<ParkingRecord>();
//            queryWrapper.like("plate", plate);
//            // 出库记录，从数据库中查
//            // 出库模块
//            ParkingRecord parkingEndRecord = parkingRecordService.getOne(queryWrapper);
            ParkingRecord parkingEndRecord = parkingRecordService.findByPlateAndEndTime(plate);
            parkingEndRecord.setEndTime(endTime);
            parkingRecordService.saveOrUpdate(parkingEndRecord);

            // 结算模块 5元/小时
            FeeRecode feeRecode = new FeeRecode();
            feeRecode.setPlate(plate);
            feeRecode.setPayTime(endTime);
            float fee = computationFee(parkingEndRecord.getBeginTime(), parkingEndRecord.getEndTime());
            feeRecode.setParkingFee(fee);
            System.out.println("fee Recode" + feeRecode);
            feeRecodeService.save(feeRecode);

            // 车位变化
            parkingSpaceService.carOut();


//            //把车牌删除
//            try {
//                String deleteURL = "/Users/feng/Downloads/parkingBeginImg" + "/" + f.getName();
//                File deleteFile = new File(deleteURL);
//                deleteFile.delete();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }

        }

        System.out.println("最终返回前端" + plate);
        if (clientUser != null) {
            return new String(plate + " 您的协议已过期， 请缴费");
        }
        return new String(plate);
    }

    public float computationFee(java.util.Date startTime, java.util.Date endTime) {
        try {


            System.out.println("startTime: " + startTime + "endTime: " + endTime);
            long diff = endTime.getTime() - startTime.getTime();
            long day = diff / nd;
            long hour = diff % nd / nh;
            long min = diff % nd % nh / nm;
            long sec = diff % nd % nh % nm / 1000;
            String str = day + "天" + hour + "小时" + min + "分钟" + sec + "秒";
            System.out.println("总停车时间：" + str);
            // 5元/小时，不足一小时按一小时算
            float fee;
            // 0 小时 50分钟
            if (min > 0 && hour < 1) {
                fee = 5;
                return fee;
            }
            // 2 小时50分钟
            if (hour >= 1 && day < 1) {
                fee = 5 * hour;
                if (min >= 1) {
                    fee = fee + 5;
                }
                return fee;
            }
            // 1 天 1小时 5分钟
            if (day >= 1) {
                fee = 120;
                if (hour >= 1) {
                    fee = fee + 5 * hour;
                    if (min >= 1) {
                        fee = fee + 5;
                    }
                }
                return fee;
            }

        } catch (Exception e) {
            System.out.println("计算两个时间段时间差出错了, {}" + e);
            return 0;
        }
        return 0;
    }

    @CrossOrigin
    @PostMapping("/api/parking/gett")
    @ResponseBody
    public ParkingRecord findByPlatAndTime(String plate) {
        return parkingRecordService.findByPlateAndEndTime(plate);
    }

    @CrossOrigin
    @GetMapping("/api/parking/getall")
    @ResponseBody
    public List<ParkingRecord> findAll() {
        return parkingRecordService.findAll();
    }


    // 车牌纠错里
    @CrossOrigin
    @PostMapping("/api/parking/upload/begin")
    @ResponseBody
    public String uploadBegin(@RequestBody String plate1) {

        JSONObject jsonObject = (JSONObject) JSONObject.parse(plate1);
        String plate = jsonObject.getString("plate");
        System.out.println("上传的车牌号" + plate + "解析前数据" + plate1);
        // 协议客户进场
        QueryWrapper<ClientUser> queryWrapper1 = new QueryWrapper<ClientUser>();
        queryWrapper1.like("client_plate", plate);
        ClientUser clientUser = clientUserService.getOne(queryWrapper1);

        System.out.println("协议客户？" + clientUser);
        //是协议客户，
        if (clientUser != null) {
            java.sql.Date beginTime1 = new java.sql.Date(new java.util.Date().getTime());

            System.out.println("beginTimee:" + beginTime1);
            // 存入数据库。停车记录
            ParkingRecord parkingRecord = new ParkingRecord();
            parkingRecord.setPlate(plate);
            parkingRecord.setBeginTime(beginTime1);
            parkingRecordService.save(parkingRecord);
            return plate + "  协议客户 ";
        }
        System.out.println(plate);
        java.sql.Date beginTime = new java.sql.Date(new java.util.Date().getTime());

        System.out.println("beginTimee:" + beginTime);
        // 存入数据库。停车记录
        ParkingRecord parkingRecord = new ParkingRecord();
        parkingRecord.setPlate(plate);
        parkingRecord.setBeginTime(beginTime);
        parkingRecordService.save(parkingRecord);

        // 车位变化
        parkingSpaceService.carEnter();

        System.out.println("最终返回前端" + plate);
        return new String(plate);
    }


    @CrossOrigin
    @PostMapping("/api/parking/upload/end")
    @ResponseBody
    public String uploadEnd(@RequestBody String plate1) {

        JSONObject jsonObject = (JSONObject) JSONObject.parse(plate1);
        String plate = jsonObject.getString("plate");
        System.out.println("上传的车牌号" + plate + "解析前数据" + plate1);
        // 协议客户出场
        QueryWrapper<ClientUser> queryWrapper1 = new QueryWrapper<ClientUser>();
        queryWrapper1.like("client_plate", plate);
        ClientUser clientUser = clientUserService.getOne(queryWrapper1);
        System.out.println("协议客户？" + clientUser);

        // 是协议客户，且日期大于当前日期
        if (clientUser != null) {
            //时间模块
            java.util.Date date = new java.util.Date();//获得系统时间.
            SimpleDateFormat sdf = new SimpleDateFormat(" yyyy-MM-dd HH:mm:ss ");
            String currentTime = sdf.format(date);
            java.sql.Timestamp endTime1 = Timestamp.valueOf(currentTime);
            System.out.println("比较结果" + clientUser.getClientEnd().compareTo(endTime1));
            if (clientUser.getClientEnd().compareTo(endTime1) > 0) {
                System.out.println("协议到期时间" + clientUser.getClientEnd());
                System.out.println("当前时间" + endTime1);
                System.out.println("beginTimee1:" + endTime1);
                // 存入数据库。停车记录
                System.out.println("endTime1:" + endTime1);

                // 出库记录，从数据库中查
                // 出库模块

                ParkingRecord parkingEndRecord = parkingRecordService.findByPlateAndEndTime(plate);
                System.out.println("协议recode" + parkingEndRecord);
                parkingEndRecord.setEndTime(endTime1);
                parkingRecordService.saveOrUpdate(parkingEndRecord);
                return plate + "  协议客户 ";
            }
        }

        // 识别成功就不等于fail
        System.out.println(plate);

        // 时间处理模块
        // util里的时间可能不行
        java.util.Date date = new java.util.Date();//获得系统时间.
        SimpleDateFormat sdf = new SimpleDateFormat(" yyyy-MM-dd HH:mm:ss ");
        String currentTime = sdf.format(date);
        java.sql.Timestamp endTime = Timestamp.valueOf(currentTime);


        System.out.println("endTime:" + endTime);
        ParkingRecord parkingEndRecord = parkingRecordService.findByPlateAndEndTime(plate);
        parkingEndRecord.setEndTime(endTime);
        parkingRecordService.saveOrUpdate(parkingEndRecord);

        // 结算模块 5元/小时
        FeeRecode feeRecode = new FeeRecode();
        feeRecode.setPlate(plate);
        feeRecode.setPayTime(endTime);
        float fee = computationFee(parkingEndRecord.getBeginTime(), parkingEndRecord.getEndTime());
        feeRecode.setParkingFee(fee);
        System.out.println("fee Recode" + feeRecode);
        feeRecodeService.save(feeRecode);

        // 车位变化
        parkingSpaceService.carOut();


        //把车牌删除
//        try {
//            String deleteURL = "/Users/feng/Downloads/parkingBeginImg" + "/" + f.getName();
//            File deleteFile = new File(deleteURL);
//            deleteFile.delete();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        System.out.println("最终返回前端" + plate);
        if (clientUser != null) {
            return new String(plate + " 您的协议已过期， 请缴费");
        }
        return new String(plate);
    }
}

