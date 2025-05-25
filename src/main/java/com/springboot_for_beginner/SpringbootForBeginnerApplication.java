package com.springboot_for_beginner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.objenesis.instantiator.basic.NewInstanceInstantiator;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("all/customer")
public class SpringbootForBeginnerApplication {
 private final customerRepository customerRepository;

    public SpringbootForBeginnerApplication(customerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public static void main(String[] args) {
		SpringApplication.run(SpringbootForBeginnerApplication.class, args);
	}
@GetMapping()
public List<customer> getCustomers() {
		return customerRepository.findAll();
}
record NewCustomerRequest(String name, String email,Integer age) {

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

