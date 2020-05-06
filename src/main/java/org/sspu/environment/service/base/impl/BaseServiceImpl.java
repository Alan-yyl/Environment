package org.sspu.environment.service.base.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.sspu.environment.mapper.RealTimeDataMapper;
import org.sspu.environment.service.base.BaseService;

/**
 * 统一管理mapper
 * @author 杨亚龙
 * @date 2020/4/26 14:14
 */
public abstract class BaseServiceImpl<T> implements BaseService<T> {
    @Autowired
    protected RealTimeDataMapper realTimeDataMapper;
}
