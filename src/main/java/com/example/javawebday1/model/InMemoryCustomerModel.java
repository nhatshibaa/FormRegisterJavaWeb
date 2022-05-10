package com.example.javawebday1.model;

import com.example.javawebday1.entity.Customer;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class InMemoryCustomerModel implements ICustomer {
    private static List<Customer> Customers;

    public InMemoryCustomerModel() {
        Customers = new ArrayList<>();
        Customers.add(
                new Customer(
                        1,
                        "Xuan Hung",
                        "0912345678",
                        "https://haycafe.vn/wp-content/uploads/2021/11/Anh-avatar-dep-chat-lam-hinh-dai-dien.jpg",
                        LocalDateTime.of(2002, 7, 10, 0, 0),
                        LocalDateTime.now(),
                        LocalDateTime.now(),
                        1)
        );
        Customers.add(
                new Customer(
                        2,
                        "Thanh Nam",
                        "0912345678",
                        "https://haycafe.vn/wp-content/uploads/2021/11/Anh-avatar-dep-chat-lam-hinh-dai-dien.jpg",
                        LocalDateTime.of(2003, 10, 10, 0, 0),
                        LocalDateTime.now(),
                        LocalDateTime.now(),
                        1)
        );
        Customers.add(
                new Customer(
                        3,
                        "Thu Ha",
                        "0912345678",
                        "https://haycafe.vn/wp-content/uploads/2021/11/Anh-avatar-dep-chat-lam-hinh-dai-dien.jpg",
                        LocalDateTime.of(2000, 12, 24, 0, 0),
                        LocalDateTime.now(),
                        LocalDateTime.now(),
                        1)
        );
        Customers.add(
                new Customer(
                        4,
                        "Thi Nhung",
                        "0912345678",
                        "https://haycafe.vn/wp-content/uploads/2021/11/Anh-avatar-dep-chat-lam-hinh-dai-dien.jpg",
                        LocalDateTime.of(2004, 10, 10, 0, 0),
                        LocalDateTime.now(),
                        LocalDateTime.now(),
                        1)
        );
    }

    @Override
    public Customer save(Customer Customer) {
        Customers.add(Customer);
        return Customer;
    }

    @Override
    public List<Customer> findAll() {
        return Customers;
    }

    @Override
    public Customer findById(int id) {
        Customer foundCustomer = null;
        for (Customer Customer :
                Customers) {
            if (Customer.getId() == id) {
                foundCustomer = Customer;
                break;
            }
        }
        return foundCustomer;
    }

    @Override
    public Customer update(int id, Customer updateCustomer) {
        Customer existingCustomer = findById(id);
        if (existingCustomer == null) {
            return null;
        }
        existingCustomer.setName(updateCustomer.getName());
        existingCustomer.setPhone(updateCustomer.getPhone());
        existingCustomer.setDateOfBirth(updateCustomer.getDateOfBirth());
        existingCustomer.setUpdatedAt(LocalDateTime.now());
        existingCustomer.setStatus(updateCustomer.getStatus());
        return existingCustomer;
    }

    @Override
    public boolean delete(int id) {
        int foundIndex = -1;
        for (int i = 0; i < Customers.size(); i++) {
            if (Customers.get(i).getId()== id) {
                foundIndex = i;
            }
        }
        if (foundIndex != -1) {
            Customers.remove(foundIndex);
            return true;
        }
        return false;
    }

}
