package com.zdzc.base.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zdzc.base.service.MbdealService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @Author by double.
 * @Date: 2019/1/17
 * @remarks:
 */
@Service(version = "1.0.0")
public class MbdealServiceImpl implements MbdealService {
    @Autowired
    MbdealService mbdealService;
    @Override
    public List<Map<String, Object>> getUserMbDeal() {
        return mbdealService.getUserMbDeal();
    }

    @Override
    public List<Map<String, Object>> getMbDeal() {
        return mbdealService.getMbDeal();
    }

    @Override
    public void addmoney(Map map) {
        mbdealService.addmoney(map);
    }
}
