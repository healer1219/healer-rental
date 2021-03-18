package com.healer.item.api;

import com.healer.common.entity.Result;
import com.healer.common.entity.ResultCode;
import com.healer.entity.item.Item;
import com.healer.item.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 李泽炜
 * @package com.healer.item.api
 * @time 2021/3/2 18:05
 * @Description TODO
 */
@CrossOrigin
@RestController
@RequestMapping("/item")
public class ItemApi {
    @Autowired
    private ItemService itemService;

    @PostMapping("")
    public Result addItem(@RequestBody Item item){
        Item savedItem = itemService.addItem(item);
        if (savedItem != null){
            return new Result(ResultCode.SUCCESS, savedItem);
        }
        return new Result(ResultCode.FAIL);
    }
    /**
     * 根据车型id获取全部车辆
     */
    @GetMapping("/carId/{carId}")
    public Result getAllByCarId(@PathVariable("carId") String carId){
        List<Item> list = itemService.getAllItemByCarId(carId);
        if (list.isEmpty()){
            return new Result(ResultCode.FAIL,"该车型暂无可用车辆");
        }
        return new Result(ResultCode.SUCCESS, list);
    }

    /**
     * 获取全部租赁车辆
     * @return
     */
    @GetMapping("")
    public List<Item> getAllItem(){
        return itemService.getAllItem();
    }

    /**
     * 根据id获取车辆
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result getItemById(@PathVariable("id") String id){
        Item itemById = itemService.getItemById(id);
        if (itemById != null){
            return new Result(ResultCode.SUCCESS, itemById);
        }
        return new Result(ResultCode.FAIL);
    }

    /**
     * 改变车辆状态
     * @param
     * @return
     */
    @PostMapping("/change")
    public Result updateItemStatus(@RequestBody String id){
        Item item = itemService.updateItemStatus(id);
        if (item != null){
            return new Result(ResultCode.SUCCESS, item);
        }
        return new Result(ResultCode.FAIL, item);

    }

}
