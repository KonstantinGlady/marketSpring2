package com.geekbrains.july.market;

import com.geekbrains.july.market.beans.Cart;
import com.geekbrains.july.market.entities.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class CartTest {

    @Autowired
    Cart cart;

    @Test
    public void ItemTest() {

        cart.add(new Product(1L, "productTest",new BigDecimal(111.10)));
        cart.add(new Product(2L, "productTest2",new BigDecimal(221.10)));
        cart.add(new Product(1L, "productTest",new BigDecimal(111.10)));

        Assertions.assertEquals(2,cart.getItems().size());

        cart.decrement(new Product(2L, "productTest2",new BigDecimal(221.10)));

        Assertions.assertEquals(1,cart.getItems().size());

        cart.clear();

        Assertions.assertEquals(0,cart.getItems().size());
    }
}
