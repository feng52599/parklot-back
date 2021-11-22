package edu.feng.parklotback.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.feng.parklotback.pojo.RepairMan;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author feng
 * @since 2020-04-01
 */
@Repository
@Mapper
public interface RepairManMapper extends BaseMapper<RepairMan> {
    List<RepairMan> findAll();
    RepairMan findUserByNameAndPassword(String username, String password);
    RepairMan findUserByNameAndPasswordToSess(String username, String password);
}
