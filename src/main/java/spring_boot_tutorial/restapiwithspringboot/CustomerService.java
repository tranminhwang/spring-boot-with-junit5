package spring_boot_tutorial.restapiwithspringboot;

import org.springframework.stereotype.Service;
import spring_boot_tutorial.restapiwithspringboot.exception.BadRequestException;

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
        boolean existsEmail = customerRepository.selectExistsEmail(customer.getEmail());
        if(existsEmail) {
            String errorMsg = "Email " + customer.getEmail() + " taken";
            throw new BadRequestException(errorMsg);
        }
        customerRepository.save(customer);
        return "Added new customer to repo!";
    }

    public Customer findCustomerById(Integer id) {
        return customerRepository.findCustomerById(id);
    }

}
