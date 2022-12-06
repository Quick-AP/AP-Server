package com.ap.apserver.controller;

import com.ap.apserver.base.RestResponse;
import com.ap.apserver.dto.OrderFoodDTO;
import com.ap.apserver.dto.QueryOrder;
import com.ap.apserver.service.OrderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/orderFood")
    public RestResponse<Integer> orderFood(@RequestBody List<OrderFoodDTO> dto) {
        return  RestResponse.ok( orderService.save(dto));
    }

    @GetMapping("/queryOrder")
    public RestResponse<QueryOrder> orderFoodById(@RequestParam Integer tableId){
        return RestResponse.ok(orderService.getOrderById(tableId));
    }

    @DeleteMapping("/checkOut")
    @ApiOperation(value = "check out")
    public RestResponse<Double> checkOut(@RequestParam Integer tableId){
        return RestResponse.ok(orderService.checkOut(tableId));
    }


}