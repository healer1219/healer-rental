package com.healer.entity.carinfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author 李泽炜
 * @package com.healer.entity.carinfo
 * @time 2021/3/28 10:38
 * @Description TODO
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_recommend")
public class UserRecommend {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    private String userId;
    private Integer carId;
    private Integer carCount;


    public UserRecommend(String userId, Integer carId, Integer carCount) {
        this.userId = userId;
        this.carId = carId;
        this.carCount = carCount;
    }
}
