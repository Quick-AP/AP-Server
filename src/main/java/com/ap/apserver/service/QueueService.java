package com.ap.apserver.service;

import com.ap.apserver.dto.QueryQueueDto;

/**
 * @author 1iin
 */
public interface QueueService {
    int registerQueue(String phoneNumber);

    QueryQueueDto queryQueue(String phoneNumber);
}
