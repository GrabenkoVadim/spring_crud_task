package employment.testtask.service.impl;

import employment.testtask.dto.CustomerDto;
import employment.testtask.dto.CustomerRequestDto;
import employment.testtask.exceptions.EntityNotFoundException;
import employment.testtask.mapper.CustomerMapper;
import employment.testtask.model.Customer;
import employment.testtask.repository.CustomerRepository;
import employment.testtask.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerMapper customerMapper, CustomerRepository customerRepository) {
        this.customerMapper = customerMapper;
        this.customerRepository = customerRepository;
    }


    @Override
    public CustomerDto saveCustomer(CustomerRequestDto requestDto) {
        Customer customer = customerMapper.toModel(requestDto);
        Customer savedCustomer = customerRepository.save(customer);
        return customerMapper.toDto(savedCustomer);
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(customerMapper::toDto)
                .toList();
    }

    @Override
    public CustomerDto getCustomerById(Long id) {
        return customerRepository.findById(id)
                .map(customerMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Can't find customer with id " + id));
    }

    @Override
    public CustomerDto updateCustomer(Long id, CustomerRequestDto customerDto) {
        return customerRepository.findById(id)
                .map(customer -> {
                    customer.setFullName(customerDto.getFullName());
                    customer.setEmail(customerDto.getEmail());
                    customer.setPhone(customerDto.getPhone());
                    Customer updatedCustomer = customerRepository.save(customer);
                    return customerMapper.toDto(updatedCustomer);
                }).orElseThrow(() -> new EntityNotFoundException("Can't find customer with id " + id));
    }

    @Override
    public void deleteCustomer(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Can't find customer with id " + id));
        customer.setIs_active(false);
        customerRepository.save(customer);
    }

}
