package org.sspu.environment.service.base;

/**
 * @author 杨亚龙
 * @date 2020/4/26 14:07
 */
public interface BaseService<T> {
   T findByNode(String nodeId);
   T findByDate(Long timeMillis);
}
