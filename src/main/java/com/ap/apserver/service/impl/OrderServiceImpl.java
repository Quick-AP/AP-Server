package com.ap.apserver.service.impl;

import com.ap.apserver.Utils.CommonConstants;
import com.ap.apserver.dto.OrderFoodDTO;
import com.ap.apserver.dto.QueryOrder;
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
    public Integer save(List<OrderFoodDTO> dto) {
        List<OrderFood> list = new ArrayList<>();
        if (!dto.isEmpty()) {
            for (OrderFoodDTO orderFood : dto) {
                list.add(OrderFood.builder()
                        .tableId(orderFood.getTableId())
                        .foodId(orderFood.getFoodId())
                        .price(orderFood.getPrice())
                        .isDeleted(CommonConstants.NOT_DELETED)
                        .build());
            }
        }
        return orderFoodMapper.insertList(list);
    }

    @Override
    public QueryOrder getOrderById(Integer tableId) {
        Example example = new Example(OrderFood.class);
        example.createCriteria()
                .andEqualTo("tableId", tableId)
                .andEqualTo("isDeleted", CommonConstants.NOT_DELETED);
        List<OrderFood> list = orderFoodMapper.selectByExample(example);
        List<String> foodIdList = new ArrayList<>();
        for (OrderFood food: list) {
            foodIdList.add(food.getFoodId());
        }
        QueryOrder order = new QueryOrder();
        order.setSumPrice(sumPrice(tableId));
        order.setFoodIdList(foodIdList);
        return order;

    }

    @Override
    public Double checkOut(Integer tableId) {
        Double sumPrice = sumPrice(tableId);
        Example example = new Example(OrderFood.class);
        example.createCriteria()
                .andEqualTo("tableId", tableId)
                .andEqualTo("isDeleted", CommonConstants.NOT_DELETED);
        OrderFood question = OrderFood.builder()
                .isDeleted(CommonConstants.IS_DELETED)
                .build();
        orderFoodMapper.updateByExampleSelective(question, example);
        TableServiceImpl.NotAvailableTableSet.remove(tableId);
        return sumPrice;
    }

    private Double sumPrice(Integer tableId) {
        Example example = new Example(OrderFood.class);
        example.createCriteria()
                .andEqualTo("tableId", tableId)
                .andEqualTo("isDeleted", CommonConstants.NOT_DELETED);
        List<OrderFood> list = orderFoodMapper.selectByExample(example);
        Double totalPrice = 0.0;
        for (OrderFood food: list) {
            totalPrice += food.getPrice();
        }
        return totalPrice;
    }
}
