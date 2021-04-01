package com.healer.carinfo.service;

import com.healer.carinfo.dao.CarInfoDao;
import com.healer.carinfo.dao.DescDao;
import com.healer.carinfo.dao.UserRecommendDao;
import com.healer.common.entity.Result;
import com.healer.common.entity.ResultCode;
import com.healer.entity.carinfo.CarInfo;
import com.healer.entity.carinfo.Desc;
import com.healer.entity.carinfo.UserRecommend;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author 李泽炜
 * @package com.healer.carinfo.service
 * @time 2021/2/24 12:56
 */
@Service
public class DescService {
    @Autowired
    private DescDao descDao;

    @Autowired
    private CarInfoDao carInfoDao;

    @Autowired
    private UserRecommendDao userRecommendDao;

    /**
     * 根据车型id查询车型详情，并且统计总点击率以及用户点击率
     * @param id
     * @param userId
     * @return
     */
    public Desc findByCarId(Integer id, String userId){
        //从表中查询用户以往记录
        List<UserRecommend> list = userRecommendDao.findAllByUserId(userId);

        //如果当前用户记录不为空，则将相对应车型的count加1
        if (!list.isEmpty()){
            Boolean hasUserRecommend = false;
            for (UserRecommend userRecommend : list) {
                if(userRecommend.getCarId().equals(id)){
                    hasUserRecommend = true;
                    UserRecommend oldRecommend = userRecommendDao.findByUserIdAndCarId(userId, id);
                    oldRecommend.setCarCount(userRecommend.getCarCount() + 1);
                    userRecommendDao.save(oldRecommend);
                }
            }
            if (!hasUserRecommend){
//                //当前用户记录为空，则新建一个记录
//                UserRecommend userRecommend = new UserRecommend();
//                userRecommend.setUserId(userId);
//                userRecommend.setCarId(id);
//                userRecommend.setCarCount(1);
//                userRecommendDao.save(userRecommend);
                addUserRecommend(userId, id, 1);
            }
        }else {
//            //当前用户记录为空，则新建一个记录
//            UserRecommend userRecommend = new UserRecommend();
//            userRecommend.setUserId(userId);
//            userRecommend.setCarId(id);
//            userRecommend.setCarCount(1);
//            userRecommendDao.save(userRecommend);
            addUserRecommend(userId, id, 1);
        }

        //增加点击率
        CarInfo carInfo = carInfoDao.findById(id).get();
        carInfo.setCount(carInfo.getCount()+1);
        carInfoDao.save(carInfo);
        return descDao.findAllByCarId(id);
    }

    private UserRecommend addUserRecommend(String userId, Integer carId, Integer CarCount){
        return userRecommendDao.save(new UserRecommend(userId, carId, CarCount));
    }

}
