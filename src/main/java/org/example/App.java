package org.example;

import org.example.config.AppConfig;
import org.example.entity.Customer;
import org.example.repository.ConnectionPool;
import org.example.repository.impl.CustomerRepo;
import org.example.service.CustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App {
    public static void main(String[] args) {

//      1 - WITHOUT SPRING
//        CustomerService customerService = new CustomerService();
//        ConnectionPool connectionPool = new ConnectionPool();
//        CustomerRepo customerRepo = new CustomerRepo(connectionPool);
//        customerService.setCustomerRepo(customerRepo);
//
//        Customer customer = customerService.get(1L);
//        System.out.println(customer);

//      2 - WITH SPRING
        var context = new AnnotationConfigApplicationContext(AppConfig.class);
        try (context) {
            Customer customer = context.getBean(CustomerService.class).get(1L);
            System.out.println();
            System.out.println("1 " + customer);

            customer.setPassword("AnotherSomeNewPassword");
            System.out.println("2 " + customer);

            context.getBean(CustomerService.class).update(customer);

            Customer updatedCustomer = context.getBean(CustomerService.class).get(1L);
            System.out.println("3 " + updatedCustomer);
        }
    }
}
