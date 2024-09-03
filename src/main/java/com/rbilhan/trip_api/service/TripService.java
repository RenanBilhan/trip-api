package com.rbilhan.trip_api.service;

import com.rbilhan.trip_api.dto.TripInputDto;
import com.rbilhan.trip_api.dto.TripOutputDTO;
import com.rbilhan.trip_api.repository.TripRepository;
import com.rbilhan.trip_api.util.ConversorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TripService {

    private final TripRepository tripRepository;

    public TripOutputDTO save (TripInputDto inputDto){
        return ConversorMapper.convertToOutput(tripRepository.save(ConversorMapper.convertToEntity(inputDto)));
    }
    public List<TripOutputDTO> findAll(){
        return tripRepository.findAll().stream()
                .map(ConversorMapper::convertToOutput)
                .toList();
    }

    public TripOutputDTO findById(Integer tripId){
        return ConversorMapper.convertToOutput(tripRepository.findById(tripId).get());
    }

    public void deleteById(Integer tripId) {
        tripRepository.deleteById(tripId);
    }
}
