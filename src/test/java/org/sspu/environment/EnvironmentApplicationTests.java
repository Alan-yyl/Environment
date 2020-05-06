package org.sspu.environment;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.sspu.environment.mapper.RealTimeDataMapper;
import org.sspu.environment.model.RealTimeData;
import org.sspu.environment.util.DataMonitor;

import java.sql.Timestamp;
import java.util.List;

@SpringBootTest
class EnvironmentApplicationTests {
    @Autowired
    RealTimeDataMapper realTimeDataMapper;

    @Test
    void contextLoads() {
    }

    @Test
    void insertRealTimeData() {
        List<Timestamp> timeList=DataMonitor.generateData();
        List<Double> pH = DataMonitor.generatePh();
        List<Double> temperature = DataMonitor.generateTemperature();

        for (int i = 0; i < 6 * 24; i++) {
            RealTimeData realTimeData = RealTimeData.builder().nodeId(1)
                    .pH(pH.get(i)).temperature(temperature.get(i)).date(timeList.get(i)).timeMillis(timeList.get(i).getTime()).build();
            System.out.println(i+"    EnvironmentApplicationTests.insertRealTimeData  "+realTimeDataMapper.insertRealTimeData(realTimeData));
        }

    }

    @Test
    void findAll() {
        for (RealTimeData realTimeData : realTimeDataMapper.selectAll()
        ) {
            System.out.println(realTimeData);
        }
    }

    @Test
    void getDataByPage(){
        // RealTimeData realTimeData = new RealTimeData();
        // realTimeData.setNodeId();
        RealTimeData realTimeData=new RealTimeData();
        realTimeData.setNodeId(1);
        realTimeData.setStart((long) 0);
        realTimeData.setFinish(1_585_676_400_000L);
        System.out.println("PhsystemApplicationTests.getDataByPage"+realTimeData.toString());

        for (RealTimeData realTimeData1:
                realTimeDataMapper.getDataByPage(1, 10, realTimeData)) {
            System.out.println(realTimeData1);
        }
    }

}
