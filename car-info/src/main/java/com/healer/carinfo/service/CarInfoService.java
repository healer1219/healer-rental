package com.healer.carinfo.service;

import com.healer.carinfo.dao.CarInfoDao;
import com.healer.carinfo.dao.CarParentsDao;
import com.healer.entity.carinfo.CarInfo;
import com.healer.entity.carinfo.CarParents;
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

    public CarParents getParentById(Integer id){
        return carParentsDao.findById(id).get();

    }

    public CarInfo getCarInfoById(Integer id){
        return carInfoDao.findById(id).get();
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
}
