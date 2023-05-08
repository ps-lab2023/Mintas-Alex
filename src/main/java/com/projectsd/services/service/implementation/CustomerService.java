package com.projectsd.services.service.implementation;

import com.projectsd.services.model.Customer;
import com.projectsd.services.repository.CustomerRepository;
import com.projectsd.services.service.ICustomerService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Collection;

import static java.lang.Boolean.TRUE;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class CustomerService implements ICustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    /*public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }*/

    @Override
    public Customer createCustomer(Customer customer) {
        log.info("Saving new customer: {}", customer.getEmail());
        return customerRepository.save(customer);
    }

    @Override
    public Collection<Customer> getCustomers(int limit) {
        log.info("Fetching all customers");
        return customerRepository.findAll(PageRequest.of(0, limit)).toList();
    }

    @Override
    public Customer findCustomerById(Long id) {
        log.info("Fetching customer by id: {}", id);
        return customerRepository.findById(id).get();
    }

    @Override
    public Customer updateCustomer(Customer customer) {
/*        Customer updatedCustomer = customerRepository.findById(customer.getId()).get();

        updatedCustomer.setFirstName(customer.getFirstName());
        updatedCustomer.setLastName(customer.getLastName());
        updatedCustomer.setEmail(customer.getEmail());
        updatedCustomer.setPhoneNumber(customer.getPhoneNumber());
        updatedCustomer.setAge(customer.getAge());
        updatedCustomer.setWorkers(customer.getWorkers());

        customerRepository.save(updatedCustomer);

        return updatedCustomer;*/
        log.info("Updating customer: {}", customer.getEmail());
        return customerRepository.save(customer);
    }

    @Override
    public Boolean deleteCustomer(Long id) {
        log.info("Deleting customer by ID: {}", id);
/*        Customer customerToDelete = customerRepository.findById(id).get();

        customerRepository.deleteById(customerToDelete.getId());

        return customerToDelete;*/
        customerRepository.deleteById(id);
        return TRUE;
    }

}
