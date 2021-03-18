package com.healer.order.api;

import com.healer.common.entity.Result;
import com.healer.common.entity.ResultCode;
import com.healer.entity.order.Order;
import com.healer.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 李泽炜
 * @package com.healer.order.api
 * @time 2021/3/3 20:24
 * @Description TODO
 */
@RestController
@RequestMapping("/order")
public class OrderApi {
    @Autowired
    private OrderService orderService;


    @GetMapping("/{id}")
    public Result getItem(@PathVariable("id") String id){
        return orderService.getItemByID(id);
    }

    @PostMapping("/addOrder")
    public Result addOrder(@RequestBody Order order){
        Order addOrder = orderService.addOrder(order);
        if (addOrder != null){
            return new Result(ResultCode.SUCCESS,addOrder);
        }
        return new Result(ResultCode.FAIL);
    }

    @GetMapping("/all/{userId}")
    public Result getAllOrderByUserId(@PathVariable("userId") String userId){
        List<Order> orderList = orderService.getOrderByUserId(userId);
        if (orderList == null){
            return new Result(ResultCode.FAIL);
        }
        return new Result(ResultCode.SUCCESS, orderList);
    }

    @PostMapping("/change")
    public Result changeOrderStatus(@RequestBody Order order){
        Order newOrder = orderService.changeOrderStatus(order);
        if (newOrder != null){
            return new Result(ResultCode.SUCCESS, newOrder);
        }
        return new Result(ResultCode.FAIL);
    }


}
