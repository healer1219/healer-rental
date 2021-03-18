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
@Table(name = "car_parents")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarParents implements Serializable {
    private static final long serialVersionUID = -9084332495284489653L;
    //ID
    @Id
    private Integer id;
    /**
     * 类型名称
     */
    private String name;
}
