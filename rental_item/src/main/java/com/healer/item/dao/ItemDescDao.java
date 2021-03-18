package com.healer.item.dao;

import com.healer.entity.item.ItemDesc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author 李泽炜
 * @package com.healer.item.dao
 * @time 2021/3/2 23:05
 * @Description TODO
 */
@Repository
public interface ItemDescDao extends JpaRepository<ItemDesc, String>, JpaSpecificationExecutor<ItemDesc> {
}
