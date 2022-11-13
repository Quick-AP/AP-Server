package com.ap.apserver.dto;


import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class OrderFoodDTO implements Serializable {
    private int tableId;
    private List<String> foodIDList;
    private Double price;
}
