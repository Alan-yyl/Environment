package org.sspu.environment.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.sql.Timestamp;

/**
 * @author 杨亚龙
 * @date 2020/4/26 13:03
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Setter
@Getter
public class RealTimeData {

    private Integer id;

    private Integer nodeId;

    private Double pH;


    private Double temperature;

    /**
     * 设置JSON响应中date的格式
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "Asia/Shanghai")
    private Timestamp date;


    private Long timeMillis;

    private Long start;
    private Long finish;

}
