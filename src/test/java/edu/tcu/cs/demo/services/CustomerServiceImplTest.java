package edu.tcu.cs.demo.services;

import edu.tcu.cs.demo.repositories.CustomerRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceImplTest {
    @InjectMocks
    CustomerServiceImpl customerService;
    @Mock
    CustomerRepository customerRepository;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void listAll() {
    }

    @Test
    public void getById() {
    }

    @Test
    public void saveOrUpdate() {
    }

    @Test
    public void delete() {
        Integer id = 7;
        customerService.delete(id);
        verify(customerRepository, times(1)).deleteById(id);
    }
}