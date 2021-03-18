package com.healer.item.dao;

import com.healer.entity.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 李泽炜
 * @package com.healer.item.dao
 * @time 2021/3/2 18:00
 * @Description TODO
 */
@Repository
public interface ItemDao extends JpaRepository<Item, String>, JpaSpecificationExecutor<Item> {
        List<Item> findAllByCarId(String carId);
}
