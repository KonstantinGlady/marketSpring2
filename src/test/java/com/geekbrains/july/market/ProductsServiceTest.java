package com.geekbrains.july.market;

import com.geekbrains.july.market.entities.Product;
import com.geekbrains.july.market.repositories.ProductsRepository;
import com.geekbrains.july.market.services.ProductsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.util.Optional;

@SpringBootTest
public class ProductsServiceTest {

    @Autowired
    ProductsService productsService;

    @MockBean
    ProductsRepository productsRepository;

    @Test
    public void findByIdTest() {
        Product product = new Product(1L, "productTest",new BigDecimal(111.11));
        Mockito.doReturn(Optional.of(product)).when(productsRepository).findById(1L);

        Product productFind = productsService.findById(1L).get();
        Assertions.assertNotNull(productFind);
        Mockito.verify(productsRepository,Mockito.times(1)).findById(ArgumentMatchers.eq(1L));

    }
}
