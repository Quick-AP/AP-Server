package com.ap.apserver.mapper;


import com.ap.apserver.entity.OrderFood;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderFoodMapper extends BaseMapper<OrderFood> {
    Integer insertFood(@Param("list") List<OrderFood> list);

    Double sumPrice(Integer tableId);

    List<String> getFoodIdList(Integer tableId);
}
