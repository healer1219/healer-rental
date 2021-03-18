package com.healer.order.dao;

import com.healer.entity.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 李泽炜
 * @package com.healer.order.dao
 * @time 2021/3/3 18:02
 * @Description TODO
 */
@Repository
public interface OrderDao extends JpaRepository<Order, Integer>, JpaSpecificationExecutor<Order> {
    Order findByUserIdAndStatus(String userId, Integer status);

    List<Order> findAllByUserId(String userId);
}
