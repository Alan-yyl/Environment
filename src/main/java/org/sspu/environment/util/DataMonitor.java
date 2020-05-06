package org.sspu.environment.util;


import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import cn.hutool.core.util.NumberUtil;


/**
 * @author 杨亚龙
 * @date 2020/4/27 13:52
 */
public class DataMonitor {

    public static void main(String[] args) {
        System.out.println(generateData().size());
        System.out.println(generatePh().size());
        System.out.println(generateTemperature().size());
    }

    public static List<Timestamp> generateData() {
        List<Timestamp> list = new ArrayList<>();

        //定义日期时间格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        //将日期时间字符串转为Date对象
        Date date = null;
        try {
            date = df.parse("2020-04-30 00:00:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Long time = date.getTime();

        //产生3天的时间戳，时间戳之间间隔10min
        for (int i = 0; i < 6 * 24 ; i++) {
            Timestamp ts = new Timestamp(time);
            list.add(ts);
            time += (60 * 1000 * 10);
        }
        return list;
    }

    public static List<Double> generatePh() {
        List<Double> list = new ArrayList<>();

        for (int i = 0; i < 6 * 24; i++) {
            //产生一个0-14之间的pH
            double pH=Math.random()*14*10/10;
            //保留两位小数
            list.add(NumberUtil.round(pH,2).doubleValue());
        }
        return list;
    }

    public static List<Double> generateTemperature() {
        List<Double> list = new ArrayList<>();
        int[] a={-1,1};

        for (int i = 0; i < 6 * 24; i++) {
            //产生一个-30-50之间的温度
            int index=a[(int) (Math.random()*2)];
            //保留两位小数
            double temperature=index*(Math.random()*50);
            list.add(NumberUtil.round(temperature, 1).doubleValue());
        }
        return list;
    }
}
