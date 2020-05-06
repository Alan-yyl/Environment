package org.sspu.environment.mapper.base;

/**
 * @author 杨亚龙
 * @date 2020/4/26 14:24
 */
public interface BaseMapper<T> {
    T findByNodeId(Integer nodeId);
    T findByDate(Long timeMillis);
}
