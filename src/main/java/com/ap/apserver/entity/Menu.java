package com.ap.apserver.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Menu {
    @Id
    private Long id;

    @Column(name = "food_id")
    private String foodId;

    private String name;

    @Column(name = "food_type")
    private String foodType;

    private double price;

    @Column(name = "image_url")
    private String imageUrl;

}
