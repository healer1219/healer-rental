package com.healer.entity.carinfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author 李泽炜
 * @package com.healer.entity.carinfo
 * @time 2021/2/23 13:52
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "car_desc")
public class Desc implements Serializable {
    private static final long serialVersionUID = -9084332495284489653L;
    //ID
    @Id
    private Integer id;
    /**
     * 车辆ID
     */
    private Integer carId;
    /**
     * 类别ID
     */
    private Integer pid;
    /**
     * 车辆名称
     */
    private String name;
    /**
     * 车辆图片
     */
    private String image;
    /**
     * 车辆轴距
     */
    private String length;
    /**
     * 发动机名称
     */
    private String engine;
    /**
     * 发动机马力
     */
    private String enginePower;
    /**
     * 驱动形式
     */
    private String driveMethod;
    /**
     * 燃料类型
     */
    private String fuel;
    /**
     * 变速箱
     */
    private String gearbox;
    /**
     * 简介
     */
    private String intro;
}
