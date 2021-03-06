package com.berg.fastsearch.core.car.service.brand.impl;

import com.berg.fastsearch.core.car.entity.CarBrand;
import com.berg.fastsearch.core.car.repository.CarBrandRepository;
import com.berg.fastsearch.core.car.service.brand.ICarBrandSearchService;
import com.berg.fastsearch.core.car.service.brand.ICarBrandService;
import com.berg.fastsearch.core.car.web.dto.brand.CarBrandDto;
import com.berg.fastsearch.core.car.web.dto.brand.CarBrandQueryCondition;
import com.berg.fastsearch.core.system.base.service.impl.AbstractBaseServiceImpl;
import com.berg.fastsearch.core.system.search.service.ISearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * <p></p>
 *
 * @author bo.he02@hand-china.com
 * @version v1.0
 * @apiNote Created on 18-5-10
 */
@Service
public class CarBrandServiceImpl
        extends AbstractBaseServiceImpl<Long, CarBrandDto, CarBrand, CarBrandQueryCondition>
        implements ICarBrandService{

    @Autowired
    private CarBrandRepository carBrandRepository;

    @Autowired
    private ICarBrandSearchService carBrandSearchService;

    @Override
    public ISearchService getSearchService() {
        return carBrandSearchService;
    }

    @Override
    protected JpaRepository<CarBrand, Long> getRepository() {
        return carBrandRepository;
    }

    @Override
    protected CarBrandDto createDto() {
        return new CarBrandDto();
    }

    @Override
    protected CarBrand createEntity() {
        return new CarBrand();
    }

    @Override
    protected void transform2E(CarBrandDto dto, CarBrand entity) throws Exception {
        //如果dto有Id,就设置用于数据的更新
        Long id = dto.getId();
        if(id!=null && id>0){
            //更新
            entity.setId(id);
        }else{
            //新建
        }
    }
}
