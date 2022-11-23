package com.ap.apserver.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


/**
 * @author 1iin
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QueryQueueDto {
    private int rank;
    private List<Integer> availableTableSet;
}
