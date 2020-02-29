package edu.feng.parklotback.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.feng.parklotback.mapper.ClientStandardMapper;
import edu.feng.parklotback.pojo.ClientStandard;
import edu.feng.parklotback.service.ClientStandardService;
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
 * @since 2020-02-23
 */
@Service
@Transactional
public class ClientStandardServiceImpl extends ServiceImpl<ClientStandardMapper, ClientStandard> implements ClientStandardService {

    @Autowired
    ClientStandardMapper clientStandardMapper;
    @Override
    public List<ClientStandard> getAll() {
        return clientStandardMapper.findAll();
    }
}
