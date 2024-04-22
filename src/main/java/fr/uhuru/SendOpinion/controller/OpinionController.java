package fr.uhuru.SendOpinion.controller;

import fr.uhuru.SendOpinion.entities.Opinion;
import fr.uhuru.SendOpinion.services.OpinionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api")
public class OpinionController {

    @Autowired
    private OpinionService opinionService;

    @PostMapping(value = "/create")
    public ResponseEntity<Opinion> create(@RequestBody Opinion opinion) {
        return new ResponseEntity<>(opinionService.create(opinion), HttpStatus.CREATED);
    }
}
