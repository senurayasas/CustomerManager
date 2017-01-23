package com.cms.log;

import com.cms.config.AutowireHelper;
import com.cms.domain.Customer;
import com.cms.repository.CustomerLogRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PreUpdate;
import java.util.Date;

public class CustomerActivityListener {

    @Autowired
    private CustomerLogRepository customerLogRepository;

    private static final String CUSTOMER_ADD_MESSAGE = "Customer Id= %s is added";
    private static final String CUSTOMER_EDIT_MESSAGE = "Customer Id= %s is edited";
    private static final String CUSTOMER_DELETE_MESSAGE = "Customer Id= %s is deleted";

    @PostPersist
    public void onSaveCustomer(Customer customer) {
        saveCustomerLog(createCustomerLog(String.format(CUSTOMER_ADD_MESSAGE, customer.getId())));
    }

    @PreUpdate
    public void onUpdateCustomer(Customer customer){
        saveCustomerLog(createCustomerLog(String.format(CUSTOMER_EDIT_MESSAGE, customer.getId())));
    }

    @PostRemove
    public void onRemoveCustomer(Customer customer){
        saveCustomerLog(createCustomerLog(String.format(CUSTOMER_DELETE_MESSAGE, customer.getId())));
    }

    private void saveCustomerLog(CustomerLog customerLog){
        AutowireHelper.autowire(this, this.customerLogRepository);
        customerLogRepository.save(customerLog);
    }

    private CustomerLog createCustomerLog(String message){
        return new CustomerLog(message, new Date());
    }
}
