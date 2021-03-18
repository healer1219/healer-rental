package com.healer.item.service;

import com.healer.entity.item.Item;
import com.healer.item.dao.ItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author 李泽炜
 * @package com.healer.item.service
 * @time 2021/3/2 18:02
 * @Description TODO
 */
@Service
public class ItemService {
    @Autowired
    private ItemDao itemDao;

    /**
     * 更改车辆出租状态
     */
    public Item updateItemStatus(String id){
        Item oldItem = itemDao.findById(id).get();
        if (oldItem.getStatus() == 1){
            oldItem.setStatus(0);
            return itemDao.save(oldItem);
        }else {
            oldItem.setStatus(1);
            return itemDao.save(oldItem);
        }
    }

    /**
     * 添加租赁车辆
     * @param item
     * @return
     */
    @Transactional
    public Item addItem(Item item){

        return itemDao.save(item);
    }

    /**
     * 根据车型id查询全部车辆
     */
    public List<Item> getAllItemByCarId(String carId){
        return itemDao.findAllByCarId(carId);
    }

    /**
     * 根据id查询车辆
     * @param id
     * @return
     */
    public Item getItemById(String id){
        Optional<Item> o = itemDao.findById(id);
        return o.orElse(null);
    }


    /**
     * 查询车辆
     * @param
     * @return
     */
    public List<Item> getAllItem(){
       return itemDao.findAll();
    }


    /**
     * 更改车辆
     * @param item
     * @return
     */
    @Transactional
    public Item updateItem(Item item){
        Item oldItem = itemDao.findById(item.getId()).get();
        oldItem = item;
        return itemDao.saveAndFlush(oldItem);
    }

    /**
     * 删除车辆
     * @param
     * @return
     */
    @Transactional
    public void deleteItemById(String id){
            itemDao.deleteById(id);
    }


}
