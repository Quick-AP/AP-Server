package com.ap.apserver.controller;

import com.ap.apserver.base.RestResponse;
import com.ap.apserver.entity.Menu;
import com.ap.apserver.service.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/queryFoodMenu")
@Api(value = "menu")
public class MenuController {
    @Autowired
    private MenuService service;

    @GetMapping("")
    @ApiOperation(value = "get menu list")
    public RestResponse<List<Menu>> queryFoodMenu() {
        List<Menu> menuList = service.queryFoodMenu();
        return RestResponse.ok(menuList);
    }
}
