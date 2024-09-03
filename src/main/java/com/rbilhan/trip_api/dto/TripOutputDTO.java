package com.rbilhan.trip_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TripOutputDTO {
    private Integer tripId;
    private String tripName;
    private String description;
    private String picture;
}
