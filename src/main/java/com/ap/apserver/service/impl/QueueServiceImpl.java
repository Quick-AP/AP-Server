package com.ap.apserver.service.impl;


import com.ap.apserver.service.QueueService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author 1iin
 */
@Service
public class QueueServiceImpl implements QueueService {
    public static ArrayList<String> queue = new ArrayList<>();

    @Override
    public int registerQueue(String phoneNumber) {
        int rank = queryQueue(phoneNumber);
        if (rank != -1) {
            return rank;
        }
        queue.add(phoneNumber);
        return queue.size() - 1;
    }

    @Override
    public int queryQueue(String phoneNumber) {
        for (int i = 0; i < queue.size(); i++) {
            if (queue.get(i).equals(phoneNumber)) {
                return i;
            }
        }
        return -1;
    }

}
