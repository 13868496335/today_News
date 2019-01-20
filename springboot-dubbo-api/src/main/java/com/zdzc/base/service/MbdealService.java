package com.zdzc.base.service;

import java.util.List;
import java.util.Map;

/**
 * @Author by double.
 * @Date: 2019/1/17
 * @remarks:
 */
public interface MbdealService  {

    public List<Map<String,Object>> getUserMbDeal();

    public List<Map<String,Object>> getMbDeal();

    public void addmoney(Map map);
}
