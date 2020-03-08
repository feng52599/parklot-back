package edu.feng.parklotback.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.feng.parklotback.mapper.RepairMapper;
import edu.feng.parklotback.pojo.Repair;
import edu.feng.parklotback.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author feng
 * @since 2020-03-08
 */
@Service
@Transactional
public class RepairServiceImpl extends ServiceImpl<RepairMapper, Repair> implements RepairService {

    @Autowired
    RepairMapper repairMapper;

    @Override
    public List<Repair> findAll() {
        return repairMapper.findAll();
    }

    @Override
    public void delete(Integer id) {
        repairMapper.deleteById(id);
    }


}
