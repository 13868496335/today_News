package com.zdzc.base.service;

import java.util.List;
import java.util.Map;

/**
 * @Author by double.
 * @Date: 2019/1/17
 * @remarks:
 */
public interface UserRoleService {

    public List<Map<String,Object>> getAllUserRole();

    public void updateUserRole(String t_user_id,
                               String t_role_id);

}
