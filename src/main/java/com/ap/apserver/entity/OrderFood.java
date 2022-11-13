package com.ap.apserver.entity;

import lombok.Data;

import java.math.BigDecimal;


@Data
public class OrderFood {

    private Integer id;
    private Integer tableId;
    private String foodId;
    private BigDecimal price;
    private Integer isDeleted;
}
