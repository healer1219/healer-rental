package com.healer.entity.carinfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * (CarInfo)实体类
 */
@Entity
@Table(name = "car_info")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarInfo implements Serializable {
    private static final long serialVersionUID = -9084332495284489553L;
    //ID
    @Id
    private Integer id;
    /**
     * 父级ID
     */
    private String pid;
    /**
     * 品牌ID
     */
    private String brandId;
    /**
     * 车辆具体介绍id
     */
    private Integer descId;
    /**
     * 车辆名称
     */
    private String name;
    /**
     * 车辆图片
     */
    private String image;
}
