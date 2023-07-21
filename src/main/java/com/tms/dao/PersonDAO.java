package com.tms.dao;

import com.tms.models.Person;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Mikhail"));
        people.add(new Person(++PEOPLE_COUNT, "Natalia"));
        people.add(new Person(++PEOPLE_COUNT, "Sofia"));
        people.add(new Person(++PEOPLE_COUNT, "Oleg"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }
}