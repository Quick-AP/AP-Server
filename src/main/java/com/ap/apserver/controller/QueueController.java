package com.ap.apserver.controller;

import com.ap.apserver.base.RestResponse;
import com.ap.apserver.service.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 1iin
 */
@RestController
@RequestMapping("/queue")
public class QueueController {
    @Autowired
    private QueueService service;

    @PostMapping("/register")
    public RestResponse<Integer> registerQueue(@RequestBody String phoneNumber) {
        int rank = service.registerQueue(phoneNumber);
        return RestResponse.ok(rank);
    }

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public RestResponse<Integer> queryQueue(@RequestParam String phoneNumber) {
        int rank = service.queryQueue(phoneNumber);
        return RestResponse.ok(rank);
    }
}
