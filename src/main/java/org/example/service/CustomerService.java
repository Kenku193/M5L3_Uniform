package org.example.service;

import org.example.entity.Customer;
import org.example.processor.Benchmark;
import org.example.repository.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class CustomerService {

    private Repo<Customer> customerRepo;

    @Autowired
    public void setCustomerRepo(Repo<Customer> customerRepo) {
        this.customerRepo = customerRepo;
    }

    @PostConstruct
    void init() {
        System.out.println("+++ construct CustomerService");
    }

    @PreDestroy
    void destroy() {
        System.out.println("--- destroy CustomerService");
    }

    @Benchmark
    public Customer get(Long id) {
        return customerRepo.getById(id);
    }

    @Benchmark
    public void update(Customer customer) {
        customerRepo.update(customer);
    }
}
