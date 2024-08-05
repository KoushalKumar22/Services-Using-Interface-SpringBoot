package com.example.ServicesImplentation.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import org.hibernate.annotations.CreationTimestamp;

import javax.naming.Name;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "Customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID",nullable = false,unique = true)
    @Max(value = 4,message = "No Out Of Limit")
    int id;
    @Column(name = "Name",updatable = true)
    @NotBlank(message = "Name Cannot Be Empty")
    @Pattern(regexp = "^[a-zA-Z]$",message = "Name Cannot Contain Special Characters")
    String name;
    @Column(name = "Address",updatable = true)
    @NotBlank(message = "Please Provide an Address")
    String address;
    @Column(name = "PhoneNo",unique = true,updatable = true)
    @NotEmpty(message = "Please Provide An Phone NUmber")
    @Pattern(regexp = "^[6-9]{1}[0-9]{9}$")
    String phoneno;
    @Column(name = "EntryDate")
    @CreationTimestamp
    public LocalDateTime creationdate;

    public Customer() {
    }
    public Customer(int id, String name, String address, String phoneno, LocalDateTime creationdate) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneno = phoneno;
        this.creationdate = creationdate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public LocalDateTime getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(LocalDateTime creationdate) {
        this.creationdate = creationdate;
    }
}
