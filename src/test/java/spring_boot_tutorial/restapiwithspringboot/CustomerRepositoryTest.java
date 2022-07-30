//package spring_boot_tutorial.restapiwithspringboot;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import spring_boot_tutorial.restapiwithspringboot.mock.CustomerMock;
//import org.assertj.core.api.AssertionsForClassTypes;
//
//
//public class CustomerRepositoryTest {
//    private final  CustomerRepository customerRepository;
//    private final  CustomerMock customerMock;
//
//    public CustomerRepositoryTest(CustomerRepository customerRepository, CustomerMock customerMock) {
//        this.customerRepository = customerRepository;
//        this.customerMock = customerMock;
//    }
//
//    @Test
//    void it_should_check_if_customer_exists_email() {
//        Customer customer = customerMock.genMockCustomer("Wang", "Minh Tran", "j2team.tranminhquang@gmail.com");
//        Customer customer_2 =
//                customerMock.genMockCustomer("Quang", "Tran", "j2team.tranminhquang@gmail.com");
//
//        customerRepository.save(customer);
//        customerRepository.save(customer_2);
//        // when
//        boolean expected = customerRepository.selectExistsEmail(customer.getEmail());
//        // then
//        AssertionsForClassTypes.assertThat(expected).isTrue();
//    }
//
//}
