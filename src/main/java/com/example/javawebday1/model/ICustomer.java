package com.example.javawebday1.model;

import com.example.javawebday1.entity.Customer;

import java.util.List;

public interface ICustomer {
    Customer save(Customer customer); // lưu thông tin.

    List<Customer> findAll();

    Customer findById(int id);

    Customer update(int id, Customer updateCustomer);

    boolean delete(int id);
}
