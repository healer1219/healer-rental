package com.healer.order.service;

import com.healer.common.entity.Result;
import com.healer.entity.cart.CartItem;
import com.healer.entity.order.Order;
import com.healer.order.dao.OrderDao;
import com.healer.order.feign.ItemFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author 李泽炜
 * @package com.healer.order.service
 * @time 2021/3/3 18:04
 * @Description TODO
 */
@Service
public class OrderService {
    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ItemFeignClient feignClient;

    public Result getItemByID(String id){
       return feignClient.getItemById(id);
    }

    /**
     * 生成定单号
     */
    private String getOrderNo() {
        Date now = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        String str = format.format(now);
        Random rnd = new Random();
        for (int i = 0; i < 5; i++) {
            int tmp = (int) (rnd.nextDouble() * 10);
            str += tmp;
        }

        return "DD" + str;
    }

    /**
     * 添加订单
     * @param order
     * @return
     */
    public Order addOrder(Order order){
        //判断用户是否有未完成订单
        if (orderDao.findByUserIdAndStatus(order.getUserId(), 0) == null &&
                orderDao.findByUserIdAndStatus(order.getUserId(), 1) == null){
            order.setCreateTime(new Timestamp(System.currentTimeMillis()));
            order.setStatus(0);
            order.setOrderNo(getOrderNo());
            feignClient.updateItemStatus(order.getItemId().toString());

            return orderDao.save(order);
        }
        return null;

    }

    /**
     * 根据用户拿到用户的所有订单
     * @param userId
     * @return
     */
    public List<Order> getOrderByUserId(String userId){
        List<Order> orderList = orderDao.findAllByUserId(userId);

        if (orderList.isEmpty()){
            return null;
        }
        return orderList;
    }

    /**
     * 改变订单状态   0为未交付 1为已交付 2为已还车
     * @param order
     * @return
     */
    public Order changeOrderStatus(Order order){
        Order newOrder = orderDao.findById(order.getId()).get();
        newOrder.setStatus(order.getStatus());
        newOrder.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        if (newOrder.getStatus() == 2){
            feignClient.updateItemStatus(newOrder.getItemId().toString());
        }
        return orderDao.save(newOrder);
    }










}
