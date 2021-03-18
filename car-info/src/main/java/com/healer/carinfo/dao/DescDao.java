package com.healer.carinfo.dao;

import com.healer.entity.carinfo.Desc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author 李泽炜
 * @package com.healer.dao.carinfo
 * @time 2021/2/23 14:14
 */
@Repository
public interface DescDao extends JpaRepository<Desc, Integer>, JpaSpecificationExecutor<Desc> {
    Desc findAllByCarId(Integer carId);
}
