package spring_boot_tutorial.restapiwithspringboot.mock;

import spring_boot_tutorial.restapiwithspringboot.Customer;

public class CustomerMock {
    public Customer genMockCustomer(String firstName, String lastName, String email) {
        Customer customer = new Customer();
        customer.setEmail(email);
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        return customer;
    }
}
