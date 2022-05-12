package com.example.javawebday1.model;

import com.example.javawebday1.entity.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryCustomerModelTest {

    InMemoryCustomerModel model;

    @BeforeEach
    void setUp() {
        model = new InMemoryCustomerModel();
    }

    @Test
    void save() {
        System.out.println(model.findAll().size());
        Customer customer = new Customer(
                1,
                "Xuan Hinh",
                "091234555",
                "https://image.jpg",
                LocalDateTime.of(2000, 10, 10, 0, 0)
        );
        model.save(customer);
        System.out.println(model.findAll().size());
    }

    @Test
    void findAll() {
        System.out.println(model.findAll().size());
    }

    @Test
    void findById() {
        Customer customer = model.findById(1);
        System.out.println(customer.toString());
    }

    @Test
    void update() {
        Customer customer = model.findById(1);
        customer.setName("Dao Xuan Hung");
        model.update(1, customer);
        for (Customer cs: model.findAll()) {
            System.out.println(cs.toString());
        }
    }

    @Test
    void delete() {
        model.delete(1);
        for (Customer st: model.findAll()) {
            System.out.println(st.toString());
        }
    }
}