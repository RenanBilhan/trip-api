package com.rbilhan.trip_api.controller;

import com.rbilhan.trip_api.dto.TripInputDto;
import com.rbilhan.trip_api.dto.TripOutputDTO;
import com.rbilhan.trip_api.service.TripService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
public class TripController {

    private final TripService tripService;

    @GetMapping("/trip")
    public ResponseEntity<List<TripOutputDTO>> findAll(){
        return ResponseEntity.ok().body(tripService.findAll());
    }

    @PostMapping("/trip")
    public ResponseEntity<TripOutputDTO> save(@RequestBody @Valid TripInputDto inputDto){
        return new ResponseEntity<>(tripService.save(inputDto), HttpStatus.CREATED);
    }

    @GetMapping("/trip/{tripId}")
    public ResponseEntity<TripOutputDTO> findById(@PathVariable @Positive(message = "Id must be a positive number")Integer tripId) {
        return new ResponseEntity<>(tripService.findById(tripId), HttpStatus.OK);
    }

    @DeleteMapping("/trip/{tripId}")
    public ResponseEntity<Void> deleteById(@PathVariable @Positive(message = "Id must be a positive number")Integer tripId) {
        tripService.deleteById(tripId);
        return ResponseEntity.noContent().build();
    }
}
