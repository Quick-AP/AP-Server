package com.ap.apserver.service.impl;

import com.ap.apserver.service.TableService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author 1iin
 */
@Service
public class TableServiceImpl implements TableService {
    public static HashSet<Integer> NotAvailableTableSet = new HashSet<>();

    @Override
    public boolean registerTable(int tableId, String phoneNumber) {
        if (NotAvailableTableSet.contains(tableId)) {
            return false;
        }
        QueueServiceImpl.queue.remove(phoneNumber);
        NotAvailableTableSet.add(tableId);
        return true;
    }

    @Override
    public boolean queryTable(int tableId) {
        return !NotAvailableTableSet.contains(tableId);
    }

    @Override
    // TODO call this function when CheckOut() is called
    public void addAvailableTable(int tableId) {
        NotAvailableTableSet.remove(tableId);
    }
}
