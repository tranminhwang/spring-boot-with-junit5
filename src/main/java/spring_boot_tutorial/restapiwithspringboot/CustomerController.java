package spring_boot_tutorial.restapiwithspringboot;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/customer")

public class CustomerController {
    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping
    public Iterable<Customer> getAllCustomers() {
        return service.getAllCustomers();
    }

    @GetMapping(path = "{id}")
    public Customer findCustomerById(@PathVariable("id") Integer id) {
        System.out.println(id);
        return service.findCustomerById(id);
    }

    @PostMapping
    public String addCustomer(@RequestBody Customer customer) {
        return service.addCustomer(customer);
    }
}
