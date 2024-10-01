package employment.testtask.service;

import employment.testtask.dto.CustomerDto;
import employment.testtask.dto.CustomerRequestDto;

import java.util.List;

public interface CustomerService {
    CustomerDto saveCustomer(CustomerRequestDto requestDto);

    List<CustomerDto> getAllCustomers();

    CustomerDto getCustomerById(Long id);

    CustomerDto updateCustomer(Long id, CustomerRequestDto customerDto);

    void deleteCustomer(Long id);
}
