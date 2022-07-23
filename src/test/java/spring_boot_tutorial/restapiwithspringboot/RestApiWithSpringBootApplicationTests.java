package spring_boot_tutorial.restapiwithspringboot;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)

class RestApiWithSpringBootApplicationTests {
    Customer genMockCustomer(String firstName, String lastName) {
        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        return customer;
    }

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
        Customer mockCustomer = genMockCustomer("Wang", "Minh Tran");
        underTest.addCustomer(mockCustomer);
        // then
        ArgumentCaptor<Customer> customerArgumentCaptor =
                ArgumentCaptor.forClass(Customer.class);
        Mockito.verify(repository).save(customerArgumentCaptor.capture());
        Customer capturedCustomer = customerArgumentCaptor.getValue();
        AssertionsForClassTypes.assertThat(capturedCustomer).isEqualTo(mockCustomer);
    }

    @Test
    void find_customer_id() {
        // when
        Customer mockCustomer =  genMockCustomer("Wang", "Minh Tran");
        underTest.addCustomer(mockCustomer);
        // then
        // ...waiting for me
    }
}
