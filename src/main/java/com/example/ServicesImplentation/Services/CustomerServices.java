package com.example.ServicesImplentation.Services;

import com.example.ServicesImplentation.Entity.Customer;
import com.example.ServicesImplentation.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServices implements CustomerServicesInter{
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer save(Customer customer){
        return customerRepository.save(customer);
    }
    @Override
    public List<Customer> findAll(){
        return customerRepository.findAll();
    }
    @Override
    public Optional<Customer> findById(int id){
        return customerRepository.findById(id);
    }
    @Override
    public List<Customer> findByName(String name){
        return customerRepository.findByName(name);
    }
    @Override
    public Customer updateById(int id,Customer customer){
        customer.setId(id);
        return customerRepository.save(customer);
    }
}
