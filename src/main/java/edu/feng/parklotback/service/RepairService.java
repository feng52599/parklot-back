package edu.feng.parklotback.service;

import com.baomidou.mybatisplus.extension.service.IService;
import edu.feng.parklotback.pojo.Repair;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author feng
 * @since 2020-03-08
 */
public interface RepairService extends IService<Repair> {

    List<Repair> findAll();

    void delete(Integer id);
}
