package com.healer.entity.item;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author 李泽炜
 * @package com.healer.entity.item
 * @time 2021/3/2 21:22
 * @Description TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "item_desc")
public class ItemDesc implements Serializable {
    @Id
    private String id;
    private String frontImg;
    private String frontDesc;
    private String frontLeftImg;
    private String frontLeftDesc;
    private String frontRightImg;
    private String frontRightDesc;
    private String backImg;
    private String backDesc;
    private String backLeftImg;
    private String backLeftDesc;
    private String backRightImg;
    private String backRightDesc;
    private String insideImg;
    private String insideDesc;
    private String insideFrontImg;
    private String insideFrontDesc;
    private String insideBackImg;
    private String insideBackDesc;
    private String desc;
}
