package com.healer.carinfo.service;

import com.healer.carinfo.dao.DescDao;
import com.healer.entity.carinfo.Desc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 李泽炜
 * @package com.healer.carinfo.service
 * @time 2021/2/24 12:56
 */
@Service
public class DescService {
    @Autowired
    private DescDao descDao;


    public Desc findByCarId(Integer id){
        return descDao.findAllByCarId(id);
    }

}
