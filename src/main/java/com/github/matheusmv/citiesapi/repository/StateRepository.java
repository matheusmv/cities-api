package com.github.matheusmv.citiesapi.repository;

import com.github.matheusmv.citiesapi.model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {

}
