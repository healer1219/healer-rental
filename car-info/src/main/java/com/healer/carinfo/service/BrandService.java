package com.healer.carinfo.service;

import com.healer.carinfo.dao.BrandDao;
import com.healer.common.utils.IdWorker;
import com.healer.entity.carinfo.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 李泽炜
 * @package com.healer.carinfo.service
 * @time 2021/2/23 14:21
 */
@Service
public class BrandService {
    @Autowired
    private BrandDao brandDao;
    @Autowired
    private IdWorker idWorker;
    /**
     * 查询全部品牌
     * @return
     */
    public List<Brand> findAll(){
        return brandDao.findAll();
    }

    /**
     * 根据id查询品牌
     * @param id
     * @return
     */
    public Brand findById(String id){
        return brandDao.findById(id).get();
    }
    /**
     * 根据名称查询品牌
     */
    public Brand findByName(String name){
        return brandDao.findByName(name);
    }
    /**
     * 添加品牌
     */
    public Brand add(Brand brand){
        String id = idWorker.nextId()+"";
        brand.setId(id);
        return brandDao.save(brand);
    }
}
