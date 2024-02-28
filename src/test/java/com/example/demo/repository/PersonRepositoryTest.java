package com.example.demo.repository;

import com.example.demo.entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PersonRepositoryTest {
    @Autowired
    private PersonRepository personRepository;
    @PersistenceContext
    private EntityManager em;

    private static final Person JOHN = new Person("John");


    @Test
    @Order(1)
    void saveAndCompare() {
        Person person = personRepository.save(JOHN);
        assertThat(person).isEqualTo(JOHN);
    }

    @Test
    @Order(2)
    void find() {
        Person person = personRepository.save(JOHN);
        assertThat(person).isEqualTo(JOHN);
//        Optional<Person> findPerson = personRepository.findById(person.getId());
//        assertThat(findPerson).hasValue(JOHN);
    }

}