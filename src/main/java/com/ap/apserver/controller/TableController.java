package com.ap.apserver.controller;

import com.ap.apserver.base.RestResponse;
import com.ap.apserver.dto.RegisterTableDto;
import com.ap.apserver.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 1iin
 */
@RestController
@RequestMapping("/table")
public class TableController {
    @Autowired
    private TableService service;

    @PostMapping("/register")
    public RestResponse<Integer> registerTable(@RequestBody RegisterTableDto dto) {
        boolean status = service.registerTable(dto.getTableId(), dto.getPhoneNumber());
        if (status) {
            return RestResponse.ok();
        } else {
            return RestResponse.error("Table is not available");
        }
    }

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public RestResponse<Boolean> queryTable(@RequestParam int tableId) {
        boolean isAvailable = service.queryTable(tableId);
        return RestResponse.ok(isAvailable);
    }
}
