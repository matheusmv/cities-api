package com.github.matheusmv.citiesapi.service;

import com.github.matheusmv.citiesapi.exception.ResourceNotFoundException;
import com.github.matheusmv.citiesapi.model.City;
import com.github.matheusmv.citiesapi.repository.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CityService {

    private final CityRepository cityRepository;

    public Page<City> getAllCities(Integer page, Integer linesPerPage, String direction, String orderBy) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);

        return cityRepository.findAll(pageRequest);
    }

    public City getCityById(Long cityId) {
        return cityRepository.findById(cityId)
                .orElseThrow(() -> new ResourceNotFoundException("City not found for this id :: " + cityId));
    }
}
