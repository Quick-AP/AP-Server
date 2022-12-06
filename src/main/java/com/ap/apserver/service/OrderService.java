package com.ap.apserver.service;

import com.ap.apserver.dto.OrderFoodDTO;
import com.ap.apserver.dto.QueryOrder;

import java.util.List;


public interface OrderService {
    Integer save(List<OrderFoodDTO> dto);

    QueryOrder getOrderById(Integer tableId);

    Double checkOut(Integer tableId);
}
