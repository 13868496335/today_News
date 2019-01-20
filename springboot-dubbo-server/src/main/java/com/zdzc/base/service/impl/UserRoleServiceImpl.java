package com.zdzc.base.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zdzc.base.mapper.UserRoleMapper;
import com.zdzc.base.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @Author by double.
 * @Date: 2019/1/17
 * @remarks:
 */
@Service(version = "1.0.0")
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    UserRoleMapper userRoleMapper;
    @Override
    public List<Map<String, Object>> getAllUserRole() {
        return userRoleMapper.getAllUserRole();
    }

    @Override
    public void updateUserRole(String t_user_id, String t_role_id) {
         userRoleMapper.updateUserRole(t_user_id, t_role_id);
    }
}
