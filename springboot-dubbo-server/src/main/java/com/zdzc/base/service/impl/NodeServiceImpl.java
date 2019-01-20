package com.zdzc.base.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zdzc.base.mapper.NodeMapper;
import com.zdzc.base.service.NodeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @Author by double.
 * @Date: 2019/1/17
 * @remarks:
 */

@Service(version = "1.0.0")
public class NodeServiceImpl implements NodeService {

    @Autowired
    NodeMapper nodeMapper;
    @Override
    public List<Map<String, Object>> getAllNodes() {
        return nodeMapper.getAllNodes();
    }

    @Override
    public List<Map<String, Object>> getSelectNodes() {
        return nodeMapper.getSelectNodes();
    }

    @Override
    public boolean deleteNodeById(String t_node_id) {
        return nodeMapper.deleteNodeById(t_node_id);
    }

    @Override
    public void editNode(String t_node_name, String t_node_url, String t_node_level, String t_node_parent_id, String t_node_id) {
       nodeMapper.editNode(t_node_name,t_node_url,t_node_level,t_node_parent_id,t_node_id);
    }

    @Override
    public void insertNode(String t_node_name, String t_node_url, String t_node_level, String t_node_parent_id) {
        nodeMapper.insertNode(t_node_name,t_node_url,t_node_level,t_node_parent_id);
    }

    @Override
    public List<Map<String, Object>> queryNodeById(String t_node_id) {
        return nodeMapper.queryNodeById(t_node_id);
    }
}
