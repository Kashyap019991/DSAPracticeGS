package org.kas.demos.Prac.CoderpatQuest.DAY41_24_12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Employee {
    private Long id;
    private String name;
    private Address address;

    // Constructor, getters, setters, and toString() for demonstration
    public Employee(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public Address getAddress() { return address; }

    public void setAddress(Address address) { this.address = address; }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', address=" + address + '}';
    }
}

class Address {
    private String city;
    private String street;
    private String country;

    // Constructor, getters, setters, and toString()
    public Address(String city, String street, String country) {
        this.city = city;
        this.street = street;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address{city='" + city + "', street='" + street + "', country='" + country + "'}";
    }
}

interface AddressService {
    Address getAddressByEmployeeId(Long empId);
}
