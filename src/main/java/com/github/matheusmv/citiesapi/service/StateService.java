package com.github.matheusmv.citiesapi.service;

import com.github.matheusmv.citiesapi.exception.ResourceNotFoundException;
import com.github.matheusmv.citiesapi.model.State;
import com.github.matheusmv.citiesapi.repository.StateRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StateService {

    private final StateRepository stateRepository;

    public Page<State> getAllStates(Integer page, Integer linesPerPage, String direction, String orderBy) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);

        return stateRepository.findAll(pageRequest);
    }

    public State getStateById(Long stateId) {
        return stateRepository.findById(stateId)
                .orElseThrow(() -> new ResourceNotFoundException("State not found for this id :: " + stateId));
    }
}
