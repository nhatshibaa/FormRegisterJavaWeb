package com.example.javawebday1.demo;

import com.example.javawebday1.entity.Customer;
import com.example.javawebday1.model.ICustomer;
import com.example.javawebday1.model.InMemoryCustomerModel;
import com.example.javawebday1.model.MySQLCustomerModel;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ConsoleApplication {

    private static ICustomer iCustomer;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Please choose type of model: ");
            System.out.println("--------------------------");
            System.out.println("1. In memory model.");
            System.out.println("2. My SQL model.");
            System.out.println("3. Exit.");
            System.out.println("--------------------------");
            System.out.println("Please enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    iCustomer = new InMemoryCustomerModel();
                    break;
                case 2:
                    iCustomer = new MySQLCustomerModel();
                    break;
                case 3:
                    System.out.println("SO HANDSOME!");
                    break;
            }
            if (choice == 3){
                break;
            }
            generateMenu();
        }
    }

    private static void generateMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("-------------Customer Manager--------------");
            System.out.println("1. Create new Customer");
            System.out.println("2. Show all Customer");
            System.out.println("3. Update Customer");
            System.out.println("4. Delete Customer");
            System.out.println("5. Exit");
            System.out.println("------------------------------------------");
            System.out.println("Please enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    createNewCustomer();
                    break;
                case 2:
                    showAllCustomer();
                    break;
                case 3:
                    updateCustomer();
                    break;
                case 4:
                    deleteCustomer();
                    break;
                case 5:
                    System.out.println("SO HANDSOME!");
                    break;
            }
            if (choice == 5) {
                break;
            }
        }
    }

    private static void deleteCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter rollNumber to update: ");
        int id = scanner.nextInt();
        Customer existingCustomer = iCustomer.findById(id);
        if (existingCustomer == null) {
            System.err.println("404, Customer not found!");
        } else {
            if (iCustomer.delete(id)) {
                System.out.println("Action success!");
            } else {
                System.err.println("Action fails, please try again!");
            }
        }
    }

    private static void updateCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter id to update: ");
        int id = scanner.nextInt();
        Customer existingCustomer = iCustomer.findById(id);
        if (existingCustomer == null) {
            System.err.println("404, Customer not found!");
        } else {
            System.out.println("Please enter name");
            String name = scanner.nextLine();
            existingCustomer.setName(name);
            if (iCustomer.update(id, existingCustomer) != null) {
                System.out.println("Action success!");
            } else {
                System.err.println("Action fails, please try again!");
            }
        }
    }

    private static void showAllCustomer() {
        List<Customer> list = iCustomer.findAll();
        for (Customer customer :
                list) {
            System.out.println(customer.toString());
        }
    }

    private static void createNewCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter id");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Please enter name");
        String name = scanner.nextLine();
        System.out.println("Please enter phone");
        String phone = scanner.nextLine();
        System.out.println("Please enter image");
        String image = scanner.nextLine();
        System.out.println("Please enter date of birth");
        LocalDateTime dob = LocalDateTime.now();
        scanner.nextLine();
        LocalDateTime createdAt = LocalDateTime.now();
        scanner.nextLine();
        LocalDateTime updatedAt = LocalDateTime.now();
        scanner.nextLine();
        Customer customer = new Customer();
        customer.setName(name);
        customer.setPhone(phone);
        customer.setImage(image);
        customer.setDateOfBirth(dob);
        customer.setCreatedAt(createdAt);
        customer.setUpdatedAt(updatedAt);
        if (iCustomer.save(customer) != null) {
            System.out.println("Create Customer success!");
        } else {
            System.err.println("Save Customer fails, please try again later!");
        }
    }
}
