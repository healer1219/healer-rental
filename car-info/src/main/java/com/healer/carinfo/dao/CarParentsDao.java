package com.healer.carinfo.dao;

import com.healer.entity.carinfo.CarParents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author 李泽炜
 * @package com.healer.dao.carinfo
 * @time 2021/2/23 14:14
 */
public interface CarParentsDao extends JpaRepository<CarParents, Integer>, JpaSpecificationExecutor<CarParents> {
}
