package com.zdzc.base.service;


import java.util.List;
import java.util.Map;

/**
 * @Author by double.
 * @Date: 2019/1/17
 * @remarks:
 */
public interface RoleNodeService {

    public List<Map<String,Object>> getRoleNodeById(String t_role_id);

    public List<Map<String,Object>> getAllNodes();

    public String saveRoleNode(Map map);
}
