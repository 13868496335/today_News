package com.zdzc.base.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zdzc.base.mapper.ReceNodeMapper;
import com.zdzc.base.service.ReceNodeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @Author by double.
 * @Date: 2019/1/17
 * @remarks:
 */
@Service(version = "1.0.0")
public class ReceNodeServiceImpl implements ReceNodeService {

    @Autowired
    ReceNodeMapper receNodeMapper;
    @Override
    public List<Map<String, Object>> getAllReceNodes() {
        return receNodeMapper.getAllReceNodes();
    }

    @Override
    public List<Map<String, Object>> getFirstNode() {
        return receNodeMapper.getFirstNode();
    }

    @Override
    public List<Map<String, Object>> getFirstNode2() {
        return receNodeMapper.getFirstNode2();
    }

    @Override
    public boolean deleteReceNodeById(String t_rece_node_id) {
        return receNodeMapper.deleteReceNodeById(t_rece_node_id);
    }

    @Override
    public void editReceNode(Map map) {
        receNodeMapper.editReceNode(map);
    }

    @Override
    public void insertReceNode(Map map) {
        receNodeMapper.insertReceNode(map);
    }

    @Override
    public List<Map<String, Object>> queryReceNodeById(String t_t_rece_node_id) {
        return receNodeMapper.queryReceNodeById(t_t_rece_node_id);
    }
}
