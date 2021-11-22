package edu.feng.parklotback.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.feng.parklotback.mapper.RepairManMapper;
import edu.feng.parklotback.pojo.RepairMan;
import edu.feng.parklotback.service.RepairManService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author feng
 * @since 2020-04-01
 */
@Service
@Transactional
public class RepairManServiceImpl extends ServiceImpl<RepairManMapper, RepairMan> implements RepairManService {

    @Autowired
    private RepairManMapper repairManMapper;

    @Override
    public RepairMan findUserByNameAndPassword(String username, String password) {
        return repairManMapper.findUserByNameAndPassword(username, password);
    }

    @Override
    public RepairMan findUserByNameAndPasswordToSess(String username, String password) {
        return repairManMapper.findUserByNameAndPasswordToSess(username, password);
    }
}
