package com.healer.carinfo.api;

import com.healer.carinfo.service.CarInfoService;
import com.healer.common.entity.Result;
import com.healer.common.entity.ResultCode;
import com.healer.entity.carinfo.CarInfo;
import com.healer.entity.carinfo.CarParents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 李泽炜
 * @package com.healer.carinfo.api
 * @time 2021/2/23 19:28
 */
@CrossOrigin
@RestController
@RequestMapping("/brand")
public class CarInfoApi {
    @Autowired
    private CarInfoService carInfoService;

    @GetMapping("/carInfo")
    public Result findAll(){
        List<CarInfo> carInfos = carInfoService.findAll();
        if (carInfos.isEmpty()){
            return new Result(ResultCode.FAIL);
        }
        return new Result(ResultCode.SUCCESS, carInfos);
    }

    @GetMapping("/carInfo/like")
    public Result findByNameLike(String carName){
        return carInfoService.getCarInfoByNameLike("%"+carName+"%");
    }

    @GetMapping("/carInfo/single/{id}")
    public Result findById( @PathVariable("id") String id){
        CarInfo carInfoById = carInfoService.getCarInfoById(Integer.valueOf(id));
        if (carInfoById != null){
            return new Result(ResultCode.SUCCESS, carInfoById);
        }
        return new Result(ResultCode.FAIL);
    }

    @GetMapping("/carInfo/parent/{id}")
    public Result findParentById(@PathVariable("id") Integer id){
        CarParents parentById = carInfoService.getParentById(id);
        if (parentById != null){
            return new Result(ResultCode.SUCCESS, parentById);
        }
        return new Result(ResultCode.FAIL);
    }

    @GetMapping("/carInfo/{id}")
    public Result findAllByBid(@PathVariable("id") String bid){
        List<CarInfo> carInfos = carInfoService.findAllByBrandId(bid);
        if (carInfos.isEmpty()){
            return new Result(ResultCode.FAIL);
        }
        return new Result(ResultCode.SUCCESS, carInfos);
    }

    /**
     * 选出当前品牌最受欢迎车型
     * @param bid
     * @return
     */
    @GetMapping("/carInfo/popular/{id}")
    public Result findMostPopularCarByBid(@PathVariable("id") String bid){
        CarInfo carInfo = carInfoService.findMostPopularByBrandId(bid);
        if (carInfo != null){
            return new Result(ResultCode.SUCCESS, carInfo);
        }
        return new Result(ResultCode.FAIL);
    }

    /**
     * 选出全部最受欢迎车型
     */
    @GetMapping("/carInfo/popular")
    public Result findMostPopularCar(){
        CarInfo carInfo = carInfoService.findMostPopularCar();
        if (carInfo != null){
            return new Result(ResultCode.SUCCESS, carInfo);
        }
        return new Result(ResultCode.FAIL);
    }
}
