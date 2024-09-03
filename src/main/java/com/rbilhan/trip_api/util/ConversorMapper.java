package com.rbilhan.trip_api.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rbilhan.trip_api.dto.TripInputDto;
import com.rbilhan.trip_api.dto.TripOutputDTO;
import com.rbilhan.trip_api.model.Trip;

public class ConversorMapper {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public static <InputType, OutputType> OutputType convert (InputType inputType, Class<OutputType> outputTypeClass) {
        return objectMapper.convertValue(inputType, outputTypeClass);
    }

    public static TripOutputDTO convertToOutput (Trip trip){
        TripOutputDTO tripOutputDTO = ConversorMapper.convert(trip, TripOutputDTO.class);

        tripOutputDTO.setTripName(trip.getTripName());
        tripOutputDTO.setTripId(trip.getTripId());
        tripOutputDTO.setDescription(trip.getDescription());
        tripOutputDTO.setPicture(trip.getPicture());

        return tripOutputDTO;
    }

    public static Trip convertToEntity (TripInputDto inputDto){
        Trip trip = ConversorMapper.convert(inputDto, Trip.class);

        trip.setTripName(inputDto.getTripName());
        trip.setDescription(inputDto.getDescription());
        trip.setPicture(inputDto.getPicture());

        return trip;
    }
}
