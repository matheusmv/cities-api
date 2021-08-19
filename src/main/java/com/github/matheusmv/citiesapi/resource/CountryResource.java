package com.github.matheusmv.citiesapi.resource;

import com.github.matheusmv.citiesapi.model.Country;
import com.github.matheusmv.citiesapi.service.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/countries")
@AllArgsConstructor
public class CountryResource {

    private final CountryService countryService;

    @GetMapping
    public ResponseEntity<Page<Country>> getAllCountries(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction,
            @RequestParam(value = "orderBy", defaultValue = "portugueseName") String orderBy) {

        var countries = countryService.getAllCountries(page, linesPerPage, direction, orderBy);

        return ResponseEntity.ok().body(countries);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Country> getCountryById(@PathVariable(value = "id") Long countryId) {
        var country = countryService.getCountryById(countryId);

        return ResponseEntity.ok().body(country);
    }
}
