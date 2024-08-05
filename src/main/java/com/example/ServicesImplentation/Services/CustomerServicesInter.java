package com.example.ServicesImplentation.Services;

import com.example.ServicesImplentation.Entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerServicesInter {
    Customer save(Customer customer);
    List<Customer> findAll();
    Optional<Customer> findById(int id);
    List<Customer> findByName(String name);
    Customer updateById(int id,Customer customer);
}
