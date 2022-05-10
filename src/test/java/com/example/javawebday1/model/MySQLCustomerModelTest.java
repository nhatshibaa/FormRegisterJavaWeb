package com.example.javawebday1.model;

import com.example.javawebday1.entity.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MySQLCustomerModelTest {

    ICustomer iCustomer;

    @BeforeEach
    void setUp() {
        iCustomer = new MySQLCustomerModel();
    }

    @Test
    void save() {
        iCustomer.save(new Customer(3, "Hong", "0123123132", "https://image.jpg", LocalDateTime.of(2004, 10, 10, 10, 10)));
    }

    @Test
    void findAll() {
        List<Customer> list = iCustomer.findAll();
        for (Customer cus :
                list) {
            System.out.println(cus.toString());
        }
    }

    @Test
    void findById() {
        Customer customer = iCustomer.findById(3);
        assertEquals("Thi Nhung", customer.getName());
        Customer customer1 = iCustomer.findById(4);
        assertEquals("Thu Ha", customer1.getName());
    }

    @Test
    void update() {
        Customer customer = iCustomer.findById(1);
        customer.setName("Xuan Van Hung");
        iCustomer.update(1, customer);
        Customer newUpdateCustomer = iCustomer.findById(1);
        assertEquals("Xuan Van Hung", newUpdateCustomer.getName());
    }

    @Test
    void delete() {
        iCustomer.delete(1);
        Customer customer = iCustomer.findById(1);
        assertEquals(null, customer);
    }
}