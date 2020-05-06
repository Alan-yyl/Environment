package org.sspu.environment.model;

import lombok.*;

import java.sql.Timestamp;

/**
 * @author 杨亚龙
 * @date 2020/4/29 10:02
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DateBean {
    @Getter
    @Setter
    private Timestamp  start;

    @Getter
    @Setter
    private Timestamp finish;

}
