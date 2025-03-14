package com.example.service;

import com.example.entity.PersonInfo;
import com.example.exception.ResourceNotFoundException;
import com.example.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService{

    @Autowired
    PersonRepository personRepository;

    @Override
    public PersonInfo savePersonInfo(PersonInfo personInfo) {
        PersonInfo savedPerson = personRepository.save(personInfo);
        return savedPerson;
    }

    @Override
    public PersonInfo fetchPersonInfo(Long personId) {
        PersonInfo personInfo = personRepository.findById(personId).orElseThrow(() -> new ResourceNotFoundException("Person Info not found with given personId : " + personId));
        return personInfo;
    }

    @Override
    public PersonInfo updatePerson(PersonInfo personInfo, Long personId) {
        PersonInfo fetchPerson = personRepository.findById(personId).orElseThrow(() -> new ResourceNotFoundException("Person Info not found with given personId : " + personId));

        if (fetchPerson != null) {
            fetchPerson.setPersonid(personId);
            fetchPerson.setFirstname(personInfo.getFirstname());
            fetchPerson.setLastname(personInfo.getLastname());
            fetchPerson.setContact(personInfo.getContact());
            fetchPerson.setAddress(personInfo.getAddress());
            fetchPerson.setCity(personInfo.getCity());
        }

        PersonInfo updatedPerson = personRepository.save(fetchPerson);
        return updatedPerson;
    }

    @Override
    public void deletePerson(Long personId) {
        personRepository.deleteById(personId);
    }

}
