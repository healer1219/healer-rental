package com.healer.carinfo.dao;

import com.healer.entity.carinfo.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author 李泽炜
 * @package com.healer.dao.carinfo
 * @time 2021/2/23 14:14
 */
@Repository
public interface BrandDao extends JpaRepository<Brand, String>, JpaSpecificationExecutor<Brand> {
    Brand findByName(String name);
}
