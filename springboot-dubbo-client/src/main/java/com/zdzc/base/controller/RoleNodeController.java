package com.zdzc.base.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zdzc.base.service.RoleNodeService;
import com.zdzc.base.service.RoleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RoleNodeController {
    @Reference(version = "1.0.0")
    RoleService roleService;
    @Reference(version = "1.0.0")
    RoleNodeService roleNodeService;

    @RequestMapping("/rolenode")
    public ModelAndView getUserNodePage(){
        ModelAndView mv=new ModelAndView();
        List roles=roleService.getAllRoles();
        List nodes=roleNodeService.getAllNodes();
        mv.setViewName("/app/rolenode.html");
        mv.addObject("allroles",roles);
        mv.addObject("allnodes",nodes);

        return mv;
        }
     @RequestMapping("/getnodesbyroleid")
    public List getNodeByRoleId(String t_role_id){
        List nodes=roleNodeService.getRoleNodeById(t_role_id);
        return nodes;
     }
     @RequestMapping("/getallnodes")
    public List getNodeByRoleId(){
        List nodes=roleNodeService.getAllNodes();
        return nodes;
     }
     @RequestMapping("/saverolenode")
    public Map saveRoleNode(@RequestParam Map map1){
        Map map=new HashMap();
         roleNodeService.saveRoleNode(map1);
        map.put("success","success");
        return map;
     }
}
