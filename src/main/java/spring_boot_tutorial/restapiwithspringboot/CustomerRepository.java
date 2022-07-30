package spring_boot_tutorial.restapiwithspringboot;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    Customer findCustomerById(Integer id);
    Boolean selectExistsEmail(String email);
}
