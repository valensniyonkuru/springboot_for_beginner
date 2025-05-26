package com.springboot_for_beginner;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("all/customer")
public class CustomerController {

    private final customerRepository customerRepository;

    public CustomerController(customerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping()
    public List<customer> getCustomers() {
        return customerRepository.findAll();
    }

    record NewCustomerRequest(String name, String email, Integer age) {
    }

    @PostMapping
    public void addCustomer(@RequestBody NewCustomerRequest request) {
        customer customer = new customer();
        customer.setName(request.name);
        customer.setEmail(request.email);
        customer.setAge(request.age);
        customerRepository.save(customer);
    }

    @DeleteMapping("{customerId}")
    public void deletecustomer(@PathVariable("customerId") Integer id) {
        customerRepository.deleteById(id);
    }
}