package com.example.service;

import com.example.entity.PersonInfo;

public interface PersonService {

    PersonInfo savePerson(PersonInfo personInfo);

    PersonInfo fetchPerson(Long personId);

    void deletePerson(Long personId);

    PersonInfo updatePerson(PersonInfo personInfo, Long personId);
}
