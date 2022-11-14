package com.ap.apserver.service;

import com.ap.apserver.dto.OrderFoodDTO;


public interface OrderService {
    Integer save(OrderFoodDTO dto);

    OrderFoodDTO getOrderById(Integer tableId);
}
