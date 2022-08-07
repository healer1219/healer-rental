package com.healer.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;


@Data
@Accessors(chain = true, fluent = true)
@AllArgsConstructor
@NoArgsConstructor
public class BrandVo implements Serializable {


    private String id;
    /**
     * 品牌名称
     */
    private String name;
    /**
     * 品牌logo
     */
    private String img;

}
