package com.example.controller;

import com.example.entity.PersonInfo;
import com.example.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping("/add")
    public ResponseEntity<PersonInfo> createPerson(@RequestBody PersonInfo personInfo){
        PersonInfo createdPerson =  personService.savePersonInfo(personInfo);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPerson);
    }

    @GetMapping("/fetch/{personId}")
    public ResponseEntity<PersonInfo> getPerson(@PathVariable Long personId){
        PersonInfo personInfo =  personService.fetchPersonInfo(personId);
        return ResponseEntity.ok(personInfo);
    }

    @PutMapping("/update/{personId}")
    public ResponseEntity<PersonInfo> updatePerson(@RequestBody PersonInfo personInfo, @PathVariable Long personId){
        PersonInfo updatePerson =  personService.updatePerson(personInfo,personId);
        return ResponseEntity.status(HttpStatus.CREATED).body(updatePerson);
    }

    @DeleteMapping("/delete/{personId}")
    public void deletePerson(@PathVariable Long personId){
        personService.deletePerson(personId);
    }
}
