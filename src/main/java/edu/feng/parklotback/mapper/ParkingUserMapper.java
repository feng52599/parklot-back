package edu.feng.parklotback.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.feng.parklotback.pojo.ParkingUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author feng
 * @since 2020-02-21
 */

@Repository
@Mapper
public interface ParkingUserMapper extends BaseMapper<ParkingUser> {

    ParkingUser findUserByNameAndPassword(String username, String password);
    ParkingUser findUserByNameAndPasswordToSess(String username, String password);

    void editByPlate(String plate);
}
