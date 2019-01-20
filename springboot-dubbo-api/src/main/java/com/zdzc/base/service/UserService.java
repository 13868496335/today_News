package com.zdzc.base.service;


import com.zdzc.base.excel.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    //注册
    public Map<String,String> regUser(String t_user_account, String t_user_password, String t_user_email);
    /* 激活帐号 */
    public void activate(String activate_code);

    public List<Map<String,Object>> getUserNode(String t_user_id);

    public List<Map<String,Object>> userLogin(String t_user_account,
                                              String t_user_password);
    public Map<String,String> userLogin2(String t_user_account,
                                         String t_user_password);

    public List<Map<String,Object>> getAllUsers();

    public boolean deleteById(String t_user_id);

    public void editUser(String t_user_account,
                         String t_user_password,
                         String t_user_id);

   public void insertUser(String t_user_account,
                          String t_user_password,
                          String t_user_email,
                          String activate_code);
    public void insertUser2(String t_user_account,
                            String t_user_password);

    public int selectEmailCount(String t_user_email);

    public List<Map<String,Object>> queryUserById(String t_user_id);

    //excel
    public List<User> teacherinfor();

    public void userhomeimg(String t_user_url,
                            String t_user_account);

    public void NewPassWord(Map map);

    public List<Map<String,Object>>  getUserHome(String t_user_account);
    public void updateUserState(String activate_code);

}
