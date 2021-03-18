package com.healer.entity.carinfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "brand_info")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Brand implements Serializable {
    private static final long serialVersionUID = 594829320797158219L;
    //ID
    @Id
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