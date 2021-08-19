package com.github.matheusmv.citiesapi.service;

import com.github.matheusmv.citiesapi.exception.ResourceNotFoundException;
import com.github.matheusmv.citiesapi.model.Country;
import com.github.matheusmv.citiesapi.repository.CountryRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CountryService {

    private final CountryRepository countryRepository;

    public Page<Country> getAllCountries(Integer page, Integer linesPerPage, String direction, String orderBy) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);

        return countryRepository.findAll(pageRequest);
    }

    public Country getCountryById(Long countryId) {
        return countryRepository.findById(countryId)
                .orElseThrow(() -> new ResourceNotFoundException("Country not found for this id :: " + countryId));
    }
}
