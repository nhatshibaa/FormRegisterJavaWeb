package com.example.javawebday1.model;

import com.example.javawebday1.entity.Phone;

import java.util.List;

public interface IPhone {
    Phone save(Phone phone);

    List<Phone> findAll();

}
