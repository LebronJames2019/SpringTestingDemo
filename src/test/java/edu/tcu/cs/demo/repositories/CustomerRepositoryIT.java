package edu.tcu.cs.demo.repositories;

import edu.tcu.cs.demo.domain.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

/**
 * This is a Spring Integration test which brings Spring up and DB up.
 */
@RunWith(SpringRunner.class)
@SpringBootTest//this will bring up embedded DB and configure Spring Data JPA for us
public class CustomerRepositoryIT {

    //Spring will autowire for us in this test case
    @Autowired
    CustomerRepository customerRepository;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void findAll(){
        assertEquals(3, customerRepository.findAll().size());
    }

    @Test
    public void findByEmail() {
        Optional<Customer> customerOptional = customerRepository.findByEmail("micheal@burnnotice.com");
        assertEquals("micheal@burnnotice.com", customerOptional.get().getEmail());
    }
    @Test
    public void delete(){
        assertEquals(3, customerRepository.findAll().size());
        Integer id = 7;
        customerRepository.deleteById(id);
        assertEquals(2, customerRepository.findAll().size());
    }
}