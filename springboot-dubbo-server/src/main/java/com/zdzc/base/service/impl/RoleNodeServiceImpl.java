package com.zdzc.base.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zdzc.base.mapper.RoleNodeMapper;
import com.zdzc.base.service.RoleNodeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @Author by double.
 * @Date: 2019/1/17
 * @remarks:
 */
@Service(version = "1.0.0")
public class RoleNodeServiceImpl implements RoleNodeService {

    @Autowired
    RoleNodeMapper roleNodeMapper;
    @Override
    public List<Map<String, Object>> getRoleNodeById(String t_role_id) {
        return roleNodeMapper.getRoleNodeById(t_role_id);
    }

    @Override
    public List<Map<String, Object>> getAllNodes() {
        return roleNodeMapper.getAllNodes();
    }

    @Override
    public String saveRoleNode(Map map) {
        return roleNodeMapper.saveRoleNode(map);
    }
}
