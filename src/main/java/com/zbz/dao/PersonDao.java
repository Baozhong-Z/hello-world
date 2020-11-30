package com.zbz.dao;

import com.zbz.pojo.Person;

import java.util.List;

public interface PersonDao {

    Person findByid(Integer id);

    List<Person> findAll();

    void addOne(Person person);
}
