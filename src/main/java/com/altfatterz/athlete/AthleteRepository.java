package com.altfatterz.athlete;

import org.springframework.data.repository.Repository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "athletes", path = "/athletes")
public interface AthleteRepository extends Repository<Athlete, Long> {

    List<Athlete> findAll();

}
