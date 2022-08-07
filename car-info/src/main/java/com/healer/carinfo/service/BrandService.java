package com.healer.carinfo.service;

import com.healer.carinfo.dao.BrandDao;
import com.healer.common.utils.IdWorker;
import com.healer.entity.carinfo.Brand;
import com.healer.vo.BrandVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 李泽炜
 * @package com.healer.carinfo.service
 * @time 2021/2/23 14:21
 */
@Service
public interface BrandService {

    /**
     * 查询全部品牌
     * @return
     */
    List<Brand> findAll();

    /**
     * 根据id查询品牌
     * @param id
     * @return
     */
    Brand findById(String id);
    /**
     * 根据名称查询品牌
     */
    Brand findByName(String name);
    /**
     * 添加品牌
     */
    Brand add(BrandVo brandvo);
}
