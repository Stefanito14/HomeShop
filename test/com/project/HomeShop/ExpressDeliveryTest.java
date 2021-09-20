package com.project.HomeShop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpressDeliveryTest {

    @Test
    public void Given_Paris_WhenGettingDeliveryPrice_ThenGet6e99(){
        Delivery delivery = new ExpressDelivery("Paris");
        assertEquals(6.99,delivery.getPrice(),0.01);
    }@Test
    public void Given_Other_WhenGettingDeliveryPrice_ThenGet9e99(){
        Delivery delivery = new ExpressDelivery("Dunkerque");
        assertEquals(9.99,delivery.getPrice(),0.01);
    }

}