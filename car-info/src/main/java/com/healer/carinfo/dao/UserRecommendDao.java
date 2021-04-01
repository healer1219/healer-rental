package com.healer.carinfo.dao;

import com.healer.entity.carinfo.UserRecommend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author 李泽炜
 * @package com.healer.carinfo.dao
 * @time 2021/3/28 10:43
 * @Description TODO
 */
public interface UserRecommendDao extends JpaRepository<UserRecommend, Integer>, JpaSpecificationExecutor<UserRecommend> {
    List<UserRecommend> findAllByUserId(String userId);

    UserRecommend findByUserIdAndCarId(String userId, Integer carId);
}
