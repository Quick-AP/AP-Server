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

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public RestResponse<Integer> registerQueue(@PathVariable("phoneNumber") Integer phoneNumber) {
        int rank = service.registerQueue(phoneNumber);
        return RestResponse.ok(rank);
    }
}
