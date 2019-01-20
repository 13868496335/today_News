package com.zdzc.base.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zdzc.base.service.RoleService;
import com.zdzc.base.service.UserRoleService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Controller
public class UserRoleController {

    @Reference(version = "1.0.0")
    public UserRoleService userRoleService;
    @Reference(version = "1.0.0")
    public RoleService roleService;

    @RequestMapping("/userrole")
    public ModelAndView getAllUserRole(){
        ModelAndView mv=new ModelAndView();
        List userrole=userRoleService.getAllUserRole();
        List role=roleService.getAllRoles();
        mv.addObject("allrole",role);
        mv.addObject("alluserrole",userrole);
        mv.setViewName("/app/userrole.html");
        return mv;
    }
    @RequestMapping("/updateuserrole")
    @ResponseBody
    public Map updateUserRole(String t_user_id, String t_role_id){
        userRoleService.updateUserRole(t_user_id,t_role_id);
        Map map=new HashMap();
        map.put("flag","true");
        return map;
    }
}
