package spring_boot_tutorial.restapiwithspringboot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)

class RestApiWithSpringBootApplicationTests {
    @Mock
    private CustomerRepository repository;
    private  CustomerService underTest;

    @BeforeEach
    void setup() {
        underTest = new CustomerService(repository);
    }

    @Test
    void it_should_get_all_customers() {
        // when
        underTest.getAllCustomers();
        // then
        Mockito.verify(repository).findAll();
    }

    @Test
    @Disabled
    void add_customer() {
    }

    @Test
    @Disabled
    void find_customer_id() {
    }

}
