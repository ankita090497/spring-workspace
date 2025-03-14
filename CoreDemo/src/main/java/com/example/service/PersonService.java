package com.example.service;

import com.example.entity.PersonInfo;

public interface PersonService {

    PersonInfo savePersonInfo(PersonInfo personInfo);

    PersonInfo fetchPersonInfo(Long personId);

    void deletePerson(Long personId);

    PersonInfo updatePerson(PersonInfo personInfo, Long personId);
}
