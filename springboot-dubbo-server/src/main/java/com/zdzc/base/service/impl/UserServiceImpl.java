package com.zdzc.base.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.dubbo.config.annotation.Service;
import com.zdzc.base.excel.User;
import com.zdzc.base.mapper.UserMapper;
import com.zdzc.base.service.UserService;
import com.zdzc.base.util.MyUtil;
import com.zdzc.base.util.SendMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service(version = "1.0.0")
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    JavaMailSender javaMailSender;
   // @Autowired
    //TaskExecutor taskExecutor;

    //注册
    public Map<String,String>  regUser(String t_user_account, String t_user_password, String t_user_email){
        Map<String, String> map = new HashMap<>();
        // 校验邮箱格式
        Pattern p = Pattern.compile("^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\\.[a-zA-Z0-9_-]{2,3}){1,2})$");
        Matcher m = p.matcher(t_user_email);
        if (!m.matches()) {
            map.put("regi-email-error", "请输入正确的邮箱");
            return map;
        }
        // 校验用户名长度
        if (StringUtils.isEmpty(t_user_account) || t_user_account.length() > 10) {
            map.put("regi-account-error", "用户名长度须在1-10个字符");
            return map;
        }

        // 校验密码长度
        p = Pattern.compile("^\\w{6,20}$");
        m = p.matcher(t_user_password);
        if (!m.matches()) {
            map.put("regi-password-error", "密码长度须在6-20个字符");
            return map;
        }
        int emailCount = userMapper.selectEmailCount(t_user_email);
        if (emailCount > 0) {
            map.put("regi-email-error", "该邮箱已注册");
            return map;
        }
        //使用md5加密（暂时不加）
        String password= MyUtil.md5(t_user_password);
        //设置未激活
        String activate_code = MyUtil.createRandomCode();
        //给用户发送邮件
        new SendMail(activate_code, t_user_email, javaMailSender, 1);
        // 向数据库插入记录
        userMapper.insertUser(t_user_account,t_user_password,t_user_email,activate_code);
        map.put("ok", "注册完成");
        return map;
    }
    /* 激活帐号 */
    public void activate(String activate_code) {
        userMapper.updateUserState(activate_code);
    }

    @Override
    public List<Map<String, Object>> getUserNode(String t_user_id) {
        return userMapper.getUserNode(t_user_id);
    }

    @Override
    public List<Map<String, Object>> userLogin(String t_user_account, String t_user_password) {
        return userMapper.userLogin(t_user_account,t_user_password);
    }

    @Override
    public Map<String, String> userLogin2(String t_user_account, String t_user_password) {
        return userMapper.userLogin2(t_user_account,t_user_password);
    }

    @Override
    public List<Map<String, Object>> getAllUsers() {
        return userMapper.getAllUsers();
    }

    @Override
    public boolean deleteById(String t_user_id) {
        return userMapper.deleteById(t_user_id);
    }

    @Override
    public void editUser(String t_user_account, String t_user_password, String t_user_id) {
         userMapper.editUser(t_user_account, t_user_password, t_user_id);
    }

    @Override
    public void insertUser(String t_user_account, String t_user_password, String t_user_email, String activate_code) {
        userMapper.insertUser(t_user_account,t_user_password,t_user_email,activate_code);
    }

    @Override
    public void insertUser2(String t_user_account, String t_user_password) {
        userMapper.insertUser2( t_user_account,t_user_password);
    }

    @Override
    public int selectEmailCount(String t_user_email) {
        return   userMapper.selectEmailCount(t_user_email);
    }

    @Override
    public List<Map<String, Object>> queryUserById(String t_user_id) {
        return  userMapper.queryUserById(t_user_id);
    }

    @Override
    public List<User> teacherinfor() {
        return userMapper.teacherinfor();
    }

    @Override
    public void userhomeimg(String t_user_url, String t_user_account) {
        userMapper.userhomeimg(t_user_url,t_user_account);
    }

    @Override
    public void NewPassWord(Map map) {
        userMapper.NewPassWord(map);
    }

    @Override
    public List<Map<String, Object>> getUserHome(String t_user_account) {
        return userMapper.getUserHome(t_user_account);
    }

    @Override
    public void updateUserState(String activate_code) {
        userMapper.updateUserState(activate_code);
    }
}
