package com.ap.apserver.service.impl;

import com.ap.apserver.Utils.CommonConstants;
import com.ap.apserver.dto.OrderFoodDTO;
import com.ap.apserver.entity.OrderFood;
import com.ap.apserver.mapper.OrderFoodMapper;
import com.ap.apserver.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Date;
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

    @Override
    public Double checkOut(Integer tableId) {
        Example example = new Example(OrderFood.class);
        example.createCriteria()
                .andEqualTo("tableId", tableId)
                .andEqualTo("isDeleted", CommonConstants.NOT_DELETED);
        List<OrderFood> list = orderFoodMapper.selectByExample(example);
        Double totalPrice = 0.0;
        for (OrderFood food: list) {
            totalPrice += food.getPrice();
        }
        OrderFood question = OrderFood.builder()
                .isDeleted(CommonConstants.IS_DELETED)
                .build();
        orderFoodMapper.updateByExampleSelective(question, example);
        TableServiceImpl.NotAvailableTableSet.remove(tableId);
        return totalPrice;
    }
}
