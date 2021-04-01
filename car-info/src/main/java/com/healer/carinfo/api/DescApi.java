package com.healer.carinfo.api;

import com.healer.carinfo.service.CarInfoService;
import com.healer.carinfo.service.DescService;
import com.healer.common.entity.Result;
import com.healer.common.entity.ResultCode;
import com.healer.entity.carinfo.CarInfo;
import com.healer.entity.carinfo.Desc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 李泽炜
 * @package com.healer.carinfo.api
 * @time 2021/2/24 13:14
 */
@CrossOrigin
@RestController
@RequestMapping("/brand/carInfo/desc")
public class DescApi {
    @Autowired
    private DescService descService;

    @Autowired
    private CarInfoService carInfoService;

    /**
     * 根据车型id查询车型详情并且统计用户点击率
     * @param id
     * @param userId
     * @return
     */
    @GetMapping("/{id}")
    public Result findByCarId(@PathVariable("id") Integer id, String userId){
        Desc desc = descService.findByCarId(id, userId);
        List<Desc> descs = new ArrayList<>();
        if (desc == null){
            return new Result(ResultCode.FAIL,"暂无详情");
        }
        descs.add(desc);
        return new Result(ResultCode.SUCCESS,descs);
    }
}
