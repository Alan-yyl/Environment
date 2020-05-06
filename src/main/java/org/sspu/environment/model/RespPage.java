package org.sspu.environment.model;

import lombok.*;

import java.util.List;

/**
 * @author 杨亚龙
 * @date 2020/5/1 17:24
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class RespPage {
    private List<?> data;
    private Integer total;
}
