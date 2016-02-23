package com.altfatterz.athlete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AthleteRestController {

    private AthleteRepository athleteRepository;

    @Autowired
    public AthleteRestController(AthleteRepository athleteRepository) {
        this.athleteRepository = athleteRepository;
    }

    @RequestMapping("/v1/athletes")
    public ResponseEntity<List<Athlete>> findAll() {
        return new ResponseEntity<>(athleteRepository.findAll(), HttpStatus.OK);
    }

}
