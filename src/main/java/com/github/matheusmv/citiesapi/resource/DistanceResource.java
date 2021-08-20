package com.github.matheusmv.citiesapi.resource;

import com.github.matheusmv.citiesapi.service.DistanceService;
import com.github.matheusmv.citiesapi.service.util.EarthRadius;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/distances")
@AllArgsConstructor
public class DistanceResource {

    private final DistanceService distanceService;

    @GetMapping("/by-points")
    public ResponseEntity<?> byPoints(@RequestParam(name = "from") final Long city1,
                                      @RequestParam(name = "to") final Long city2) {

        var distance = distanceService.distanceByPointsInMiles(city1, city2);

        return ResponseEntity.ok().body(distance);
    }

    @GetMapping("/by-cube")
    public ResponseEntity<?> byCube(@RequestParam(name = "from") final Long city1,
                                    @RequestParam(name = "to") final Long city2) {

        var distance = distanceService.distanceByCubeInMeters(city1, city2);

        return ResponseEntity.ok().body(distance);
    }

    @GetMapping("/by-math")
    public ResponseEntity<?> byMath(@RequestParam(name = "from") final Long city1,
                                    @RequestParam(name = "to") final Long city2,
                                    @RequestParam final EarthRadius unit) {

        var distance = distanceService.distanceUsingMath(city1, city2, unit);

        return ResponseEntity.ok().body(distance);
    }
}
