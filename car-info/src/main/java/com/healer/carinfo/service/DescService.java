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
public interface DescService {

    /**
     * 根据车型id查询车型详情，并且统计总点击率以及用户点击率
     * @param id
     * @param userId
     * @return
     */
    Desc findByCarId(Integer id, String userId);

}
