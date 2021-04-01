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
public class CarInfoService {
    @Autowired
    private CarInfoDao carInfoDao;

    @Autowired
    private CarParentsDao carParentsDao;


    @Autowired
    private UserRecommendDao userRecommendDao;

    public CarParents getParentById(Integer id){
        return carParentsDao.findById(id).get();

    }

    /**
     * 根据车辆id查询单个的车型
     * @param id
     * @return
     */
    public CarInfo getCarInfoById(Integer id){
        return carInfoDao.findById(id).get();
    }

    /**
     * 根据名称模糊查询
     * @param carName
     * @return
     */
    public Result getCarInfoByNameLike(String carName){
        CarInfo carInfo = carInfoDao.findByNameLike(carName);
        if (carInfo != null){
            return new Result(ResultCode.SUCCESS, carInfo);
        }
        return new Result(ResultCode.FAIL);
    }


    public List<CarInfo> findAll(){
        List<CarInfo> carInfos = carInfoDao.findAll();
        if (carInfos.isEmpty()){
            return null;
        }
        return carInfos;
    }

    public List<CarInfo> findAllByBrandId(String brandId){
        List<CarInfo> carInfos = carInfoDao.findAllByBrandId(brandId);
        if (carInfos.isEmpty()){
            return null;
        }
        return carInfos;
    }

    /**
     * 选出当前品牌最受欢迎车型
     * @param brandId
     * @return
     */
    public CarInfo findMostPopularByBrandId(String brandId){
        List<CarInfo> carInfos = findAllByBrandId(brandId);
        CarInfo mostPopularCar = new CarInfo();
        Integer count = 0;
        if (!carInfos.isEmpty()){
            for (CarInfo carInfo : carInfos) {

                if (carInfo.getCount() >= count){
                    count = carInfo.getCount();
                    mostPopularCar = carInfo;
                }
            }
            return mostPopularCar;
        }
        return null;

    }

    /**
     * 选出最受欢迎车型
     * @return
     */
    public CarInfo findMostPopularCar(){
        List<CarInfo> carInfos = findAll();
        CarInfo mostPopularCar = null;
        Integer count = 0;
        if (!carInfos.isEmpty()){
            for (CarInfo carInfo : carInfos) {
                if (carInfo.getCount() >= count){
                    count = carInfo.getCount();
                    mostPopularCar = carInfo;
                }
            }
            return mostPopularCar;
        }
        return null;

    }
}
