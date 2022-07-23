package spring_boot_tutorial.restapiwithspringboot;

import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private CustomerRepository customerRepository;
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    public Iterable<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public String addCustomer(Customer customer) {
        customerRepository.save(customer);
        return "Added new customer to repo!";
    }

    public Customer findCustomerById(Integer id) {
        return customerRepository.findCustomerById(id);
    }

}
