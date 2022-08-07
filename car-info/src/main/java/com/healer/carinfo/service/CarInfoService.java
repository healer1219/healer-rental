package com.healer.carinfo.service;

import com.healer.carinfo.dao.CarInfoDao;
import com.healer.carinfo.dao.CarParentsDao;
import com.healer.carinfo.dao.UserRecommendDao;
import com.healer.common.entity.Result;
import com.healer.common.entity.ResultCode;
import com.healer.entity.carinfo.CarInfo;
import com.healer.entity.carinfo.CarParents;
import com.healer.entity.carinfo.UserRecommend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 李泽炜
 * @package com.healer.carinfo.service
 * @time 2021/2/23 19:26
 */
@Service
public interface CarInfoService {

    CarParents getParentById(Integer id);

    /**
     * 根据车辆id查询单个的车型
     * @param id
     * @return
     */
    CarInfo getCarInfoById(Integer id);

    /**
     * 根据名称模糊查询
     * @param carName
     * @return
     */
    Result getCarInfoByNameLike(String carName);


    List<CarInfo> findAll();

    List<CarInfo> findAllByBrandId(String brandId);

    /**
     * 选出当前品牌最受欢迎车型
     * @param brandId
     * @return
     */
    CarInfo findMostPopularByBrandId(String brandId);

    /**
     * 选出最受欢迎车型
     * @return
     */
    CarInfo findMostPopularCar();
}
