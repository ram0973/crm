package ru.aretinsky.crm.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.aretinsky.crm.exception.CustomerNotFoundException;
import ru.aretinsky.crm.model.dto.CustomerDto;
import ru.aretinsky.crm.model.entity.Customer;
import ru.aretinsky.crm.repository.CustomerRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    @Autowired
    protected CustomerService(CustomerRepository customerRepository, ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
    }

    public List<CustomerDto> findAll() {
        List<Customer> customerList = customerRepository.findAll();
        return customerList.stream()
                .map(customer -> modelMapper.map(customer, CustomerDto.class))
                .collect(Collectors.toList());
    }

    public CustomerDto findById(long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));
        return modelMapper.map(customer, CustomerDto.class);
    }
}
