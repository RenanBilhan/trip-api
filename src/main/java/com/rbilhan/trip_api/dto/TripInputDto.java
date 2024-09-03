package com.rbilhan.trip_api.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TripInputDto {

    @NotEmpty(message = "Trip require a name")
    private String tripName;
    @NotEmpty(message = "trip require a description")
    private String description;
    private String picture;

}
