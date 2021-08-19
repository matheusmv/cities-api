package com.github.matheusmv.citiesapi.service;

import com.github.matheusmv.citiesapi.exception.ResourceNotFoundException;
import com.github.matheusmv.citiesapi.model.Country;
import com.github.matheusmv.citiesapi.repository.CountryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CountryService {

    private final CountryRepository countryRepository;

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    public Country getCountryById(Long countryId) {
        return countryRepository.findById(countryId)
                .orElseThrow(() -> new ResourceNotFoundException("Country not found for this id :: " + countryId));
    }
}
