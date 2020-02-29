package edu.feng.parklotback.service;

import com.baomidou.mybatisplus.extension.service.IService;
import edu.feng.parklotback.pojo.Weekend;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author feng
 * @since 2020-02-23
 */
public interface WeekendService extends IService<Weekend> {
    List<Weekend> getAll();

}
