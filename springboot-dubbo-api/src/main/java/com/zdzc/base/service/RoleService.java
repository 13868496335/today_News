package com.zdzc.base.service;

import java.util.List;
import java.util.Map;

/**
 * @Author by double.
 * @Date: 2019/1/17
 * @remarks:
 */
public interface RoleService {

    public List<Map<String,Object>> getAllRoles();

    public boolean deleteRoleById(String t_role_id);

    public void editRole(String t_role_name,
                         String t_role_id);

    public void insertRole(String t_role_name);

    public List<Map<String,Object>> queryRoleById(String t_role_id);
}
