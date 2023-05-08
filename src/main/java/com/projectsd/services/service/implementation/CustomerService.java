package com.projectsd.services.service.impl;

import com.projectsd.services.model.Customer;
import com.projectsd.services.repository.CustomerRepository;
import com.projectsd.services.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getCustomers() {
        return (List<Customer>) customerRepository.findAll();
    }

    @Override
    public Customer findCustomerById(Long id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public Customer createCustomer(Customer customer) {
        customerRepository.save(customer);
        return customer;
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        Customer updatedCustomer = customerRepository.findById(customer.getId()).get();

        updatedCustomer.setFirstName(customer.getFirstName());
        updatedCustomer.setLastName(customer.getLastName());
        updatedCustomer.setEmail(customer.getEmail());
        updatedCustomer.setPhoneNumber(customer.getPhoneNumber());
        updatedCustomer.setAge(customer.getAge());
        updatedCustomer.setWorkers(customer.getWorkers());

        customerRepository.save(updatedCustomer);

        return updatedCustomer;
    }

    @Override
    public Customer deleteCustomer(Long id) {
        Customer customerToDelete = customerRepository.findById(id).get();

        customerRepository.deleteById(customerToDelete.getId());

        return customerToDelete;
    }

}
