package edu.feng.parklotback.controller;


import edu.feng.parklotback.pojo.Repair;
import edu.feng.parklotback.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

/**
 * @program: parklot-back
 * @description:
 * @author: feng
 * @create: 2020-02-15 10:03
 */


@RestController
public class RepairController {
    @Autowired
    RepairService repairService;

    @CrossOrigin
    @GetMapping("/api/repair/get")
    public List<Repair> getAll() throws Exception{
        return repairService.findAll();
    }


    @CrossOrigin
    @PostMapping("api/repair/merge")
    public Repair merge(@RequestBody Repair repair) {
        System.out.println("useriddddd" + repair.getId() + "name" + repair.getRepairDevice());
        if ((repair.getId() == null) || (repair.getId() == 0)){
            java.sql.Date submitTime = new java.sql.Date(new java.util.Date().getTime());
            repair.setSubmitTime(submitTime);
            repairService.save(repair);
        }else {
            if (repair.getStatus() == 2){
//                java.sql.Date repairTime = new java.sql.Date(new java.util.Date().getTime());
                java.util.Date date = new java.util.Date();//获得系统时间.
                SimpleDateFormat sdf = new SimpleDateFormat(" yyyy-MM-dd HH:mm:ss ");
                String currentTime = sdf.format(date);
                java.sql.Timestamp repairTime = Timestamp.valueOf(currentTime);
                repair.setRepairTime(repairTime);
            }
            repairService.updateById(repair);
        }
        return repair;
    }
    @CrossOrigin
    @PostMapping("api/repair/delete")
    public void delete(@RequestBody Repair repair) throws Exception{
        System.out.println("useriddddd" + repair.getId() + "name" + repair.getRepairDevice());
        System.out.println(repair);

        repairService.delete(repair.getId());
    }
}