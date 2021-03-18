package com.healer.item.service;

import com.healer.entity.item.ItemDesc;
import com.healer.item.dao.ItemDescDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author 李泽炜
 * @package com.healer.item.service
 * @time 2021/3/2 23:06
 * @Description TODO
 */
@Service
public class ItemDescService {
    @Autowired
    private ItemDescDao itemDescDao;


    public ItemDesc getItemDescById(String id){
        Optional<ItemDesc> o = itemDescDao.findById(id);
        return o.orElse(null);

    }
}
