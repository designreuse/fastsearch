package com.berg.fastsearch.core.car.service.brand;

import com.berg.fastsearch.core.car.web.dto.brand.CarBrandIndexMessage;
import com.berg.fastsearch.core.car.web.dto.brand.CarBrandQueryCondition;
import com.berg.fastsearch.core.system.search.service.ISearchService;

/**
 * <p></p>
 *
 * @author bo.he02@hand-china.com
 * @version v1.0
 * @apiNote Created on 18-5-16
 */
public interface ICarBrandSearchService extends ISearchService<Long, CarBrandIndexMessage, CarBrandQueryCondition> {
}
