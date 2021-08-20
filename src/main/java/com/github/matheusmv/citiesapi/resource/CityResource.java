package com.github.matheusmv.citiesapi.resource;

import com.github.matheusmv.citiesapi.model.City;
import com.github.matheusmv.citiesapi.service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cities")
@AllArgsConstructor
public class CityResource {

    private final CityService cityService;

    @GetMapping
    public ResponseEntity<Page<City>> getAllCities(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction,
            @RequestParam(value = "orderBy", defaultValue = "name") String orderBy) {

        var cities = cityService.getAllCities(page, linesPerPage, direction, orderBy);

        return ResponseEntity.ok().body(cities);
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> getCityById(@PathVariable(value = "id") Long cityId) {
        var city = cityService.getCityById(cityId);

        return ResponseEntity.ok().body(city);
    }
}
