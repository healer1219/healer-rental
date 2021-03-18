package com.healer.order.feign;

import com.healer.common.entity.Result;
import com.healer.entity.item.Item;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


/**
 * @author 李泽炜
 */
@FeignClient(value = "rental-item")
public interface ItemFeignClient {

    @PostMapping("/item/change")
    public Result updateItemStatus(@RequestBody String id);

    @GetMapping("/item/{id}")
    public Result getItemById(@PathVariable("id") String id);

}
