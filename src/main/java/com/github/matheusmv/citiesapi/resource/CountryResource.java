package com.github.matheusmv.citiesapi.resource;

import com.github.matheusmv.citiesapi.model.Country;
import com.github.matheusmv.citiesapi.service.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/countries")
@AllArgsConstructor
public class CountryResource {

    private final CountryService countryService;

    @GetMapping
    public ResponseEntity<List<Country>> getAllCountries() {
        var countries = countryService.getAllCountries();

        return ResponseEntity.ok().body(countries);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Country> getCountryById(@PathVariable(value = "id") Long countryId) {
        var country = countryService.getCountryById(countryId);

        return ResponseEntity.ok().body(country);
    }
}
