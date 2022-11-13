package com.ap.apserver.controller;

import com.ap.apserver.base.RestResponse;
import com.ap.apserver.dto.OrderFoodDTO;
import com.ap.apserver.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/orderFood")
    public RestResponse<Integer> orderFood(@RequestBody OrderFoodDTO dto) {
        return  RestResponse.ok( orderService.save(dto));
    }

    @GetMapping("queryOrder")
    public RestResponse<OrderFoodDTO> oderFoodById(@RequestParam Integer tableId){
        return RestResponse.ok(orderService.getOrderById(tableId));
    }


}