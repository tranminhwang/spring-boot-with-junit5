package spring_boot_tutorial.restapiwithspringboot;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
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
    void it_should_add_customer() {
        // when
        Customer tempCustomer = new Customer();
        tempCustomer.setFirstName("Quang");
        tempCustomer.setLastName("Minh Tran");
        underTest.addCustomer(tempCustomer);
        // then
        ArgumentCaptor<Customer> customerArgumentCaptor =
                ArgumentCaptor.forClass(Customer.class);
        Mockito.verify(repository).save(customerArgumentCaptor.capture());
        Customer capturedCustomer = customerArgumentCaptor.getValue();
        AssertionsForClassTypes.assertThat(capturedCustomer).isEqualTo(tempCustomer);
    }

    @Test
    @Disabled
    void find_customer_id() {
    }

}
