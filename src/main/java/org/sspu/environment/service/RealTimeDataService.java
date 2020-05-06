package org.sspu.environment.service;


import org.sspu.environment.model.DateBean;
import org.sspu.environment.model.RealTimeData;
import org.sspu.environment.model.RespPage;
import org.sspu.environment.service.base.BaseService;

import java.util.List;
import java.util.Map;

/**
 * @author 杨亚龙
 * @date 2020/4/26 14:06
 */
public interface RealTimeDataService extends BaseService<RealTimeData> {
   Boolean addRealData(RealTimeData realTimeData);
   int selectAllRealTimeData();
   RespPage getDataByPage(Integer currentPage,Integer pageSize,RealTimeData realTimeData);
   Map<String, List> getDataByDate(RealTimeData realTimeData);
}
