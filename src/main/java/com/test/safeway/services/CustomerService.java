package com.test.safeway.services;

import com.test.safeway.dto.CustomerDTO;
import com.test.safeway.models.Customer;
import com.test.safeway.repositories.CustomerRepository;
import com.test.safeway.services.exceptions.CustomerNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    public final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer findById(Long id) {
        return customerRepository.findById(id).
                orElseThrow(() -> new CustomerNotFoundException("ID não encontrado"));
    }
    @Transactional
    public CustomerDTO create(CustomerDTO customerDTO) {
        Customer create = new Customer();
        create.setName(customerDTO.getName());
        create.setCpf(customerDTO.getCpf());
        create = customerRepository.save(create);
        return new CustomerDTO(create);
    }
    @Transactional
    public Customer update(Long id, CustomerDTO customerDTO) {
        return customerRepository.findById(id).map(customer -> {

            if (customerDTO.getName() != null) {
                customer.setName(customerDTO.getName());
            }
            if (customerDTO.getCpf() != null) {
                customer.setCpf(customerDTO.getCpf());
            }

            customerRepository.save(customer);
            return customer;
        }).orElseThrow(() -> new CustomerNotFoundException("ID não encontrado"));
    }
    @Transactional
    public void delete(Long id) {
        customerRepository.findById(id).ifPresentOrElse(
                response -> customerRepository.deleteById(id),
                () -> {
                    throw new CustomerNotFoundException("ID não encontrado");
                }
        );
    }
}
