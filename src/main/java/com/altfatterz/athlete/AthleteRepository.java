package com.altfatterz.athlete;

import org.springframework.data.repository.Repository;

import java.util.List;

public interface AthleteRepository extends Repository<Athlete, Long> {

    List<Athlete> findAll();

}
