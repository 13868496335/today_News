package com.zdzc.base.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zdzc.base.service.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class RoleController {

    @Reference(version = "1.0.0")
    RoleService roleService;

    @RequestMapping("/rolemanagement")
    public ModelAndView getRoles(){
        ModelAndView mv=new ModelAndView();
        List role=roleService.getAllRoles();
        mv.addObject("allrole",role);
        mv.setViewName("/app/roles.html");
        return mv;
    }
    @RequestMapping("/newrole")
    public ModelAndView insertRole(){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("/app/newroles.html");
        return mv;
    }
    @RequestMapping("/deleterole")
    public ModelAndView deleteRole(String t_role_id){
        ModelAndView mv=new ModelAndView();
        if (roleService.deleteRoleById(t_role_id)){
            List role=roleService.getAllRoles();
            mv.addObject("allrole",role);
            String success="删除成功！";
            mv.addObject("success",success);
            mv.setViewName("/app/roles.html");

        }else {
            List role=roleService.getAllRoles();
            mv.addObject("allrole",role);
            mv.setViewName("/app/roles.html");
            String error="删除失败？？？";
            mv.addObject("error",error);
        }
        return mv;
    }


    @RequestMapping("/updaterole")
    public ModelAndView updateRole(String t_role_id){
        ModelAndView mv=new ModelAndView();
        List<Map<String,Object>> role=roleService.queryRoleById(t_role_id);
        mv.addObject("updaterole",role.get(0));
        mv.setViewName("/app/updateroles.html");
        return mv;
    }

    @RequestMapping("/editrole")
    public ModelAndView updateRole(String t_role_name,String t_role_id){
        ModelAndView mv=new ModelAndView();
        roleService.editRole(t_role_name,t_role_id);
        List role=roleService.getAllRoles();
        mv.addObject("allrole",role);
        mv.setViewName("/app/roles.html");
        return mv;
    }

    @RequestMapping("/saverole")
    public ModelAndView saveRole(String t_role_name){
        ModelAndView mv=new ModelAndView();
        roleService.insertRole(t_role_name);
        List role=roleService.getAllRoles();
        mv.addObject("allrole",role);
        mv.setViewName("/app/roles.html");
        return mv;
    }
}
