package com.healer.order.feign;

import com.healer.common.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author 李泽炜
 * @package com.healer.order.feign
 * @time 2021/3/21 21:39
 * @Description TODO
 */
@FeignClient("rental-user")
public interface UserFeignClient {
    /**
     * 调用user模块中的结算方法对user表中的余额进行结算
     * @param id
     * @param cash
     * @return
     */
    @PostMapping("/user/settleAccounts")
    public Result settleAccounts(String id, Double cash);
}
