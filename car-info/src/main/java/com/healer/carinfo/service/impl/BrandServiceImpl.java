package com.healer.carinfo.service.impl;

import com.healer.carinfo.dao.BrandDao;
import com.healer.carinfo.service.BrandService;
import com.healer.common.utils.IdWorker;
import com.healer.entity.carinfo.Brand;
import com.healer.mapstruct.BrandMapper;
import com.healer.vo.BrandVo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 李泽炜
 * @package com.healer.carinfo.service
 * @time 2021/2/23 14:21
 */
@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandDao brandDao;
    @Autowired
    private IdWorker idWorker;
    /**
     * 查询全部品牌
     * @return
     */
    @Override
    public List<Brand> findAll(){
        return brandDao.findAll();
    }

    /**
     * 根据id查询品牌
     * @param id
     * @return
     */
    @Override
    public Brand findById(String id){
        return brandDao.findById(id).get();
    }
    /**
     * 根据名称查询品牌
     */
    @Override
    public Brand findByName(String name){
        return brandDao.findByName(name);
    }
    /**
     * 添加品牌
     */
    @Override
    public Brand add(BrandVo brandVo){

        brandVo.id(
                StringUtils.isEmpty(brandVo.id())  ?
                        String.valueOf(idWorker.nextId())
                        : brandVo.id()
        );


        return brandDao.save(
                BrandMapper.mapper.convert(brandVo)
        );
    }
}
