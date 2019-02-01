package edu.tcu.cs.demo.services;

import edu.tcu.cs.demo.domain.Product;
import edu.tcu.cs.demo.repositories.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * We are not bring up Spring at all, all we have here is JUnit with Mockito.
 * This test runs very fast.
 */
@RunWith(MockitoJUnitRunner.class)
public class ProductServiceImplTest {
    @Mock
    ProductRepository productRepository;//declare a Mockito mock

    @InjectMocks
    ProductServiceImpl productService;//Mockito will instantiate this for us

    @Test
    public void listAll() {
        Product product1 = new Product();
        product1.setDescription("Product Test 1");
        product1.setPrice(new BigDecimal("22.99"));
        product1.setImageUrl("http://example.com/producttest1");

        Product product2 = new Product();
        product2.setDescription("Product Test 2");
        product2.setPrice(new BigDecimal("13.99"));
        product2.setImageUrl("http://example.com/producttest2");

        Product product3 = new Product();
        product3.setDescription("Product Test 3");
        product3.setPrice(new BigDecimal("74.99"));
        product3.setImageUrl("http://example.com/producttest3");

        when(productRepository.findAll()).thenReturn(Stream.of(product1,product2,product3).collect(Collectors.toList()));

        List products = productService.listAll();

        assertNotNull(products);
        assertEquals(3, products.size());
        verify(productRepository, times(1)).findAll();//make sure findAll is only called once

    }

    @Test
    public void getByIdFound() {
        Product product1 = new Product();
        Integer id = 1;
        product1.setId(id);
        product1.setDescription("Product Test 1");
        product1.setPrice(new BigDecimal("22.99"));
        product1.setImageUrl("http://example.com/producttest1");

        when(productRepository.findById(anyInt())).thenReturn(Optional.of(product1));

        Product product = productService.getById(id);

        assertNotNull(product);
    }

    @Test
    public void getByIdNotFound() {
        Integer id = 1;

        when(productRepository.findById(anyInt())).thenReturn(Optional.empty());

        Product product = productService.getById(id);

        assertNull(product);
    }

    @Test
    public void saveOrUpdate() {
        Product product1 = new Product();
        Integer id = 1;
        product1.setId(id);
        product1.setDescription("Product Test 1");
        product1.setPrice(new BigDecimal("22.99"));
        product1.setImageUrl("http://example.com/producttest1");

        when(productRepository.save(any())).thenReturn(product1);

        Product returnedProduct = productService.saveOrUpdate(product1);

        assertNotNull(returnedProduct);
    }

    @Test
    public void delete() {
        Integer id = 1;
        productService.delete(id);
        verify(productRepository, times(1)).deleteById(id);//since delete is not returning anything, we need to verify the service is calling repo's delete method
    }
}