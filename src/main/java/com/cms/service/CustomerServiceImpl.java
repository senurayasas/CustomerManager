package com.cms.service;

import com.cms.domain.Customer;
import com.cms.repository.CustomerLogRepository;
import com.cms.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerLogRepository customerLogRepository;


    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Override
    public void saveCustomer(Customer customer) {
        System.out.println(customerLogRepository);
        Integer id = customer.getId();
        customerRepository.save(customer);
    }

    @Override
    public Customer findById(Integer id) {
        return customerRepository.findOne(id);
    }

    @Override
    public List<Customer> findAllCustomers() {
        return (List<Customer>) customerRepository.findAll();
    }

    @Override
    public void deleteCustomer(Integer id) {
        customerRepository.delete(id);
        LOGGER.info("Customer Id= {} is deleted  {}", id, new Date());
    }
}
