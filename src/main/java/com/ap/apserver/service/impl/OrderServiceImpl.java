package com.ap.apserver.service.impl;

import com.ap.apserver.dto.OrderFoodDTO;
import com.ap.apserver.entity.OrderFood;
import com.ap.apserver.mapper.OrderFoodMapper;
import com.ap.apserver.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderFoodMapper orderFoodMapper;

    @Override
    public Integer save(OrderFoodDTO dto) {
        List<OrderFood> list = new ArrayList<>();
        if (!dto.getFoodIDList().isEmpty()) {
            for (String s : dto.getFoodIDList()) {
                OrderFood orderFood = new OrderFood();
                orderFood.setFoodId(s);
                orderFood.setTableId(dto.getTableId());
            }
        }
        return orderFoodMapper.insertFood(list);
    }

    @Override
    public OrderFoodDTO getOrderById(Integer tableId) {
        Double price =   orderFoodMapper.sumPrice(tableId);
        List<String> foodIdList = orderFoodMapper.getFoodIdList(tableId);
        OrderFoodDTO dto = new OrderFoodDTO();
        dto.setPrice(price);
        dto.setFoodIDList(foodIdList);
        return dto;
    }
}
