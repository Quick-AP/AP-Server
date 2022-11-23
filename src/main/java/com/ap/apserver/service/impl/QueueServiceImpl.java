package com.ap.apserver.service.impl;


import com.ap.apserver.dto.QueryQueueDto;
import com.ap.apserver.service.QueueService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 1iin
 */
@Service
public class QueueServiceImpl implements QueueService {
    public static ArrayList<String> queue = new ArrayList<>();

    @Override
    public int registerQueue(String phoneNumber) {
        int rank = queryQueue(phoneNumber).getRank();
        if (rank != -1) {
            return rank;
        }
        queue.add(phoneNumber);
        return queue.size() - 1;
    }

    @Override
    public QueryQueueDto queryQueue(String phoneNumber) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 19; i++) {
            if (TableServiceImpl.NotAvailableTableSet.contains(i)) {
                continue;
            }
            list.add(i);
        }
        for (int i = 0; i < queue.size(); i++) {
            if (queue.get(i).equals(phoneNumber)) {
                return new QueryQueueDto(i, list);
            }
        }
        return new QueryQueueDto(-1, list);
    }

}
