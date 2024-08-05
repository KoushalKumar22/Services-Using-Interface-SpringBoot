package com.example.ServicesImplentation.Controller;

import com.example.ServicesImplentation.Entity.Customer;
import com.example.ServicesImplentation.Exceptions.IdNotFoundException;
import com.example.ServicesImplentation.Exceptions.NameNotFoundException;
import com.example.ServicesImplentation.Services.CustomerServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Validated
public class CustomerController {

    @Autowired
    CustomerServices customerServices;

    @GetMapping("/test")
    public String test(){
        return "This Is A Test Run";
    }
    @PostMapping("/save")
    public String save(@Valid @RequestBody Customer customer){
        customerServices.save(customer);
        return "Entry Confirmed";
    }
    @GetMapping("/all")
    public List<Customer> findAll(){
        return customerServices.findAll();
    }
    @GetMapping("/id/{id}")
    public Optional<Customer> findById(@PathVariable int id)throws IdNotFoundException {
        Optional<Customer> customer=customerServices.findById(id);
        if (customer.isEmpty()){
            throw new IdNotFoundException("User Not Found");
        }
        return customer;
    }
    @GetMapping("/name/{name}")
    public List<Customer> findByName(@PathVariable String name)throws NameNotFoundException{
        List<Customer> customer=customerServices.findByName(name);
        if (customer.isEmpty()){
            throw new NameNotFoundException("No User Found");
        }
        return customer;
    }
    @PutMapping("/upd/{id}")
    public Customer updateById(@PathVariable int id,@RequestBody Customer customer){
        customerServices.updateById(id, customer);
        return customer;
    }
}
