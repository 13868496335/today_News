package com.zdzc.base.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zdzc.base.service.NodeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;
@Controller
public class NodeController {

    @Reference(version = "1.0.0")
    NodeService nodeService;

    @RequestMapping("/nodemanagement")
    public ModelAndView gets(){
        ModelAndView mv=new ModelAndView();
        List node=nodeService.getAllNodes();
        mv.addObject("allnode",node);
        mv.setViewName("/app/nodes.html");
        return mv;
    }
    @RequestMapping("/newnode")
    public ModelAndView insertNode(){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("/app/newnodes.html");
        return mv;
    }
    @RequestMapping("/deletenode")
    public ModelAndView deleteNode(String t_node_id){
        ModelAndView mv=new ModelAndView();
        if (nodeService.deleteNodeById(t_node_id)){
            List node=nodeService.getAllNodes();
            mv.addObject("allnode",node);
            String success="删除成功！";
            mv.addObject("success",success);
            mv.setViewName("/app/nodes.html");

        }else {
            List node=nodeService.getAllNodes();
            mv.addObject("allnode",node);
            mv.setViewName("/app/nodes.html");
            String error="删除失败？？？";
            mv.addObject("error",error);
        }
        return mv;
    }
    @RequestMapping("/updatenode")
    public ModelAndView updateNode(String t_node_id){
        ModelAndView mv=new ModelAndView();
        List node=nodeService.queryNodeById(t_node_id);
        mv.addObject("updatenode",node.get(0));
        mv.setViewName("/app/updatenodes.html");
        return mv;
    }
    @RequestMapping("/editnode")
    public ModelAndView updateNode(String t_node_name,
                                   String t_node_url,
                                   String t_node_level,
                                   String t_node_parent_id,
                                   String t_node_id){
        ModelAndView mv=new ModelAndView();
        nodeService.editNode(t_node_name,t_node_url,t_node_level,t_node_parent_id,t_node_id);
        List node=nodeService.getAllNodes();
        mv.addObject("allnode",node);
        mv.setViewName("/app/nodes.html");
        return mv;
    }
    @RequestMapping("/savenode")
    public ModelAndView saveNode(String t_node_name,
                                 String t_node_url,
                                 String t_node_level,
                                 String t_node_parent_id){
        ModelAndView mv=new ModelAndView();
        nodeService.insertNode(t_node_name,t_node_url,t_node_level,t_node_parent_id);
        System.out.println(t_node_parent_id);
        List node=nodeService.getAllNodes();
        mv.addObject("allnode",node);
        mv.setViewName("/app/nodes.html");
        return mv;
    }
    @RequestMapping("/selectnode")
    @ResponseBody
    public List<Map<String,Object>> getNodeSelect(){
        List<Map<String,Object>> nodes=nodeService.getSelectNodes();
        return nodes;
    }

}
