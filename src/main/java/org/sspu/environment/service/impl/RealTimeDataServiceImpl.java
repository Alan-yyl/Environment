package org.sspu.environment.service.impl;


import javafx.beans.binding.DoubleExpression;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sspu.environment.model.DateBean;
import org.sspu.environment.model.RealTimeData;
import org.sspu.environment.model.RespPage;
import org.sspu.environment.service.RealTimeDataService;
import org.sspu.environment.service.base.impl.BaseServiceImpl;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author 杨亚龙
 * @date 2020/4/26 14:14
 */
@Service
@Transactional
public class RealTimeDataServiceImpl extends BaseServiceImpl<RealTimeData> implements RealTimeDataService {
    @Override
    public Boolean addRealData(RealTimeData realTimeData) {
        if (realTimeDataMapper.insertRealTimeData(realTimeData) > 0) {
            System.out.println("RealTimeDataServiceImpl.addRealData" + "数据插入成功");
            return true;
        } else {
            return false;
        }
    }

    @Override
    public RespPage getDataByPage(Integer currentPage, Integer pageSize, RealTimeData realTimeData) {
        //计算当前页的编号
        if (currentPage != null && pageSize != null) {
            //当前页的编号=(当前页的编号-1)*每页数据的条数
            currentPage = (currentPage - 1) * pageSize;
        }

        RespPage respPage = new RespPage();
        List<RealTimeData> data = realTimeDataMapper.getDataByPage(currentPage, pageSize, realTimeData);
        Integer total = realTimeDataMapper.getTotal(realTimeData);
        System.out.println("RealTimeDataServiceImpl.getDataByPage" + data);
        respPage.setData(data);
        respPage.setTotal(total);
        return respPage;
    }

    @Override
    public Map<String, List> getDataByDate(RealTimeData realTimeData) {
        Map<String, List> data = new HashMap<>();
        List<Double> pH = new ArrayList<>();
        List<Double> temperature = new ArrayList<>();
        List<String> timeDate = new ArrayList<>();

        List<RealTimeData> dataList = realTimeDataMapper.getDataByDate(realTimeData);

        if (!dataList.isEmpty()) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            for (RealTimeData realTimeData1 : dataList
            ) {
                pH.add(realTimeData1.getPH());
                temperature.add(realTimeData1.getTemperature());
                timeDate.add(sdf.format(new Date(realTimeData1.getDate().getTime())));
            }
            data.put("pH", pH);
            data.put("temperature", temperature);
            data.put("timeData", timeDate);
        }

        System.out.println("RealTimeDataServiceImpl.getDataByDate" + data);
        return data;
    }

    @Override
    public int selectAllRealTimeData() {
        if (realTimeDataMapper.selectAll().size() > 0) {
            return 1;
        } else {
            return 0;
        }
    }


    @Override
    public RealTimeData findByNode(String nodeID) {
        return null;
    }


    @Override
    public RealTimeData findByDate(Long timeMillis) {
        return null;
    }
}
