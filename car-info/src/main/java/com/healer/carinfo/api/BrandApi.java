package com.healer.carinfo.api;

import com.healer.carinfo.service.BrandService;
import com.healer.common.entity.Result;
import com.healer.common.entity.ResultCode;
import com.healer.entity.carinfo.Brand;
import com.healer.mapstruct.BrandMapper;
import com.healer.vo.BrandVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 李泽炜
 * @package com.healer.carinfo.api
 * @time 2021/2/23 14:33
 */
@CrossOrigin
@RestController
@RequestMapping("/brand")
public class BrandApi {
    @Autowired
    private BrandService brandService;

    @PostMapping("")
    public Result<BrandVo> addBrand(@RequestBody BrandVo brandVo){
        try {
            Brand result = brandService.add(brandVo);
            return null == result ?
                    Result.FAIL() :
                    Result.success(
                            BrandMapper.mapper.convert(result)
                    );
        } catch (Exception e) {
            return Result.FAIL();
        }

    }

    @GetMapping("")
    public Result findAll(){
        List<Brand> brands = brandService.findAll();
        if(brands.isEmpty()){
            return new Result(ResultCode.FAIL,"请稍后再试");
        }
        return new Result(ResultCode.SUCCESS, brands);
    }

    @GetMapping("/{id}")
    public Result findById(@PathVariable("id") String id){
        Brand brand = brandService.findById(id);
        if(brand == null){
            return new Result(ResultCode.FAIL,"请稍后再试");
        }
        return new Result(ResultCode.SUCCESS, brand);
    }
}
