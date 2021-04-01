package com.healer.carinfo.dao;

import com.healer.entity.carinfo.CarInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author 李泽炜
 * @package com.healer.dao.carinfo
 * @time 2021/2/23 14:14
 */
public interface CarInfoDao extends JpaRepository<CarInfo, Integer>, JpaSpecificationExecutor<CarInfo> {
    List<CarInfo> findAllByBrandId(String brandId);
    CarInfo findByNameLike(String name);
}
