package com.cms.service;


import com.cms.domain.Customer;

import java.util.List;

public interface CustomerService {

    void saveCustomer(Customer customer);
    Customer findById(Integer id);
    List<Customer> findAllCustomers();
    void deleteCustomer(Integer id);

}
