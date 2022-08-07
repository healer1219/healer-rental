package com.healer.mapstruct;

import com.healer.entity.carinfo.Brand;
import com.healer.vo.BrandVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BrandMapper {
    
    BrandMapper mapper = Mappers.getMapper(BrandMapper.class);

    Brand convert(BrandVo brandVo);

    BrandVo convert(Brand brand);
    
}
