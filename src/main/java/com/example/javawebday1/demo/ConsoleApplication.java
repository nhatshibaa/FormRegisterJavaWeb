package com.example.javawebday1.demo;

import com.example.javawebday1.entity.Customer;
import com.example.javawebday1.model.ICustomer;
import com.example.javawebday1.model.InMemoryCustomerModel;

import java.time.LocalDateTime;
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
                    iCustomer = new InMemoryCustomerModel();
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
        System.out.println("Please enter rollNumber to update: ");
        int id = scanner.nextInt();
        Customer existingCustomer = iCustomer.findById(id);
        if (existingCustomer == null) {
            System.err.println("404, Customer not found!");
        } else {
            System.out.println("Please enter full name");
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
        System.out.println("Please enter roll number");
        int id = scanner.nextInt();
        System.out.println("Please enter full name");
        String name = scanner.nextLine();
        Customer customer = new Customer(id, name, "019231233", "https://haycafe.vn/wp-content/uploads/2021/11/Anh-avatar-dep-chat-lam-hinh-dai-dien.jpg", LocalDateTime.of(2000, 10, 10, 10, 10));
        if (iCustomer.save(customer) != null) {
            System.out.println("Create Customer success!");
        } else {
            System.err.println("Save Customer fails, please try again later!");
        }
    }
}
