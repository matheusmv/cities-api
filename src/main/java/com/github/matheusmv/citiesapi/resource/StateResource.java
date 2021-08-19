package com.github.matheusmv.citiesapi.resource;

import com.github.matheusmv.citiesapi.model.State;
import com.github.matheusmv.citiesapi.service.StateService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/states")
@AllArgsConstructor
public class StateResource {

    private final StateService stateService;

    @GetMapping
    public ResponseEntity<Page<State>> getAllStates(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction,
            @RequestParam(value = "orderBy", defaultValue = "name") String orderBy) {

        var states = stateService.getAllStates(page, linesPerPage, direction, orderBy);

        return ResponseEntity.ok().body(states);
    }

    @GetMapping("/{id}")
    public ResponseEntity<State> getStateById(@PathVariable(value = "id") Long stateId) {
        var state = stateService.getStateById(stateId);

        return ResponseEntity.ok().body(state);
    }
}
