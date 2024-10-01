package employment.testtask.controller;

import employment.testtask.dto.CustomerDto;
import employment.testtask.dto.CustomerRequestDto;
import employment.testtask.exceptions.EntityNotFoundException;
import employment.testtask.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDto createCustomer(@RequestBody @Valid CustomerRequestDto customerDto) {
        return customerService.saveCustomer(customerDto);
    }

    @GetMapping
    public List<CustomerDto> getCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public CustomerDto getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }



    @PutMapping("/{id}")
    public CustomerDto updateCustomer(@PathVariable Long id, @RequestBody @Valid CustomerRequestDto customerDto) {
        CustomerDto customer = customerService.getCustomerById(id);
        if (customer != null) {
            return customerService.updateCustomer(id, customerDto);
        }
        throw new EntityNotFoundException("Customer with with id " + id + " not found");
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }
}
