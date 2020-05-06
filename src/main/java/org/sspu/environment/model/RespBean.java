package org.sspu.environment.model;

import lombok.*;

/**
 * @author 杨亚龙
 * @date 2020/4/27 18:24
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class RespBean {

    @Setter
    @Getter
    private Integer status;

    @Setter
    @Getter
    private String msg;

    @Getter
    @Setter
    private Object data;
}
