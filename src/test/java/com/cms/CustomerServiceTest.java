package com.cms;

import com.cms.domain.Customer;
import com.cms.domain.Department;
import com.cms.service.CustomerService;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/META-INF/spring/mediumApplicationContext.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;

    private Customer customer;
    @Test
    public void testSaveCustomer() {
        customer = new Customer();
        customer.setFirstName("Don");
        customer.setLastName("Smith");
        customer.setDepartment(Department.ENGINEERING);
        customerService.saveCustomer(customer);
        Assert.notNull(customer.getId());
    }

    @Test
    public void testUpdateCustomer() {
        Customer customer = new Customer();
        customer.setFirstName("Winston");
        customer.setLastName("Smith");
        customer.setDepartment(Department.ENGINEERING);
        customerService.saveCustomer(customer);
        Assert.notNull(customer.getId());
        customerService.deleteCustomer(customer.getId());
        Assert.isNull(customerService.findById(customer.getId()));
    }
}
