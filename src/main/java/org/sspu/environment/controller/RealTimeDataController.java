package org.sspu.environment.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.sspu.environment.model.RealTimeData;
import org.sspu.environment.model.RespBean;
import org.sspu.environment.service.RealTimeDataService;

import java.util.List;
import java.util.Map;

/**
 * @author 杨亚龙
 * @date 2020/4/27 18:23
 */
@RestController
@RequestMapping("/data")
public class RealTimeDataController {
    @Autowired
    RealTimeDataService realTimeDataService;

    /**
     * 分页查询
     *
     * @param currentPage  当前页面的页码
     * @param pageSize     页面大小
     * @param realTimeData 实时数据对象
     * @return 查询结果
     */
    @GetMapping("/")
    public RespBean getDataByPage(@RequestParam(defaultValue = "1") Integer currentPage, @RequestParam(defaultValue = "10") Integer pageSize, RealTimeData realTimeData) {
        System.out.println("RealTimeDataController.getDataByPage" + currentPage + " " + pageSize);
        System.out.println("RealTimeDataController.getDataByPage" + realTimeData);
        RespBean respBean = new RespBean();
        if (realTimeData != null) {
            Object data = realTimeDataService.getDataByPage(currentPage, pageSize, realTimeData);
            System.out.println(data);
            respBean.setData(data);
            respBean.setStatus(200);
            respBean.setMsg("分页请求成功");
        } else {
            respBean.setStatus(400);
            respBean.setMsg("分页请求失败");
        }

        return respBean;
    }


    /**
     * 查询指定时间范围的数据
     * @param realTimeData 节点
     * @return
     */
    @PostMapping("/realtime")
    public RespBean getDataByDate(@RequestBody RealTimeData realTimeData) {
        System.out.println("RealTimeDataController.getDataByDate"+realTimeData.toString());
        RespBean respBean = new RespBean();
        Map<String, List> dataMap=realTimeDataService.getDataByDate(realTimeData);
        if (!dataMap.isEmpty()) {
            respBean.setStatus(200);
            respBean.setData(dataMap);
            respBean.setMsg("获取数据成功");
        }else{
            respBean.setStatus(400);
            respBean.setData(null);
            respBean.setMsg("获取数据失败");
        }
        return respBean;
    }
}
