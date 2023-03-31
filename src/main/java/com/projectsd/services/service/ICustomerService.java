package com.projectsd.services.service;

import com.projectsd.services.model.Customer;
import com.projectsd.services.model.Worker;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ICustomerService {
    List<Customer> getCustomers();
    Customer findCustomerById(Long id);
    Customer createCustomer(Customer customer);
    Customer updateCustomer(Customer customer);
    Customer deleteCustomer(Long id);

}
