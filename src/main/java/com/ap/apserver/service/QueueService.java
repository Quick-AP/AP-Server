package com.ap.apserver.service;

/**
 * @author 1iin
 */
public interface QueueService {
    int registerQueue(String phoneNumber);

    int queryQueue(String phoneNumber);
}
