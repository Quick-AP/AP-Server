package com.ap.apserver.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderFood {

    @Id
    private Long id;

    @Column(name = "table_id")
    private Integer tableId;

    @Column(name = "food_id")
    private String foodId;

    private Double price;

    @Column(name = "is_deleted")
    private Boolean isDeleted;
}
