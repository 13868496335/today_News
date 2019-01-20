package com.zdzc.base.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zdzc.base.mapper.RoleMapper;
import com.zdzc.base.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @Author by double.
 * @Date: 2019/1/17
 * @remarks:
 */
@Service(version = "1.0.0")
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleMapper roleMapper;

    @Override
    public List<Map<String, Object>> getAllRoles() {
        return roleMapper.getAllRoles();
    }

    @Override
    public boolean deleteRoleById(String t_role_id) {
        return roleMapper.deleteRoleById(t_role_id);
    }

    @Override
    public void editRole(String t_role_name, String t_role_id) {
       roleMapper.editRole(t_role_name, t_role_id);
    }

    @Override
    public void insertRole(String t_role_name) {
        roleMapper.insertRole(t_role_name);
    }

    @Override
    public List<Map<String, Object>> queryRoleById(String t_role_id) {
        return roleMapper.queryRoleById(t_role_id);
    }
}
