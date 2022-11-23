package com.ap.apserver.service;

import java.util.ArrayList;

/**
 * @author 1iin
 */
public interface TableService {
    boolean registerTable(int tableId, String phoneNumber);

    boolean queryTable(int tableId);
}
