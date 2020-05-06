package org.sspu.environment.mapper;



import org.apache.ibatis.annotations.Param;
import org.sspu.environment.mapper.base.BaseMapper;
import org.sspu.environment.model.DateBean;
import org.sspu.environment.model.RealTimeData;

import java.util.List;

/**
 * @author 杨亚龙
 * @date 2020/4/26 14:26
 */
public interface RealTimeDataMapper extends BaseMapper<RealTimeData> {
    /**
     * 向数据库中插入一条实时数据
     * @param realTimeData
     * @return
     */
    int insertRealTimeData(RealTimeData realTimeData);

    /**
     * 查询数据库中的说有数据
     * @return
     */
    List<RealTimeData> selectAll();

    /**
     * 分页查询实时数据。
     * 使用了Param注解以后，在xml文件中就不用定义pramType，同时如果Param("参数")，参数是一个对象，可以直接通过参数来获取对象的属性
     * @param currentPage
     * @param pageSize
     * @param realTimeData
     * @return
     */
    List<RealTimeData> getDataByPage(@Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize, @Param("realTimeData") RealTimeData realTimeData);


    /**
     * 查询返回的数据条数
     * @param realTimeData
     * @return
     */
    int getTotal(@Param("realTimeData") RealTimeData realTimeData);

    List<RealTimeData> getDataByDate(@Param("realTimeData") RealTimeData realTimeData);

}
