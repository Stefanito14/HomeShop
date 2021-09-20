package com.project.HomeShop;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class BillTest {

    private String output;
    private Writter writterMock = new Writter() {
        @Override
        public void start() {
            output = "";
        }

        @Override
        public void writeLine(String line) {
            output += line + "%n";
        }

        @Override
        public void stop() {

        }
    };

    private Product cafe = new Product("Philips HD7866/61", "Philips SENSEO Quadrante, Noir - 1 ou 2 tasses", 79.99);
    private Product tv = new Television("TV Samsung UE49MU6292", "Smart TV LED incurvée 49\"", (double) 599, 49, "LED");
    private Product fridge = new Fridge("BEKO TSE 1042 F", "Réfrigérateur BEKO 130L - Classe A+ - blanc", (double) 189, 130, false);
    private Customer customer = new Customer("Juste Leblanc", "19 rue Germain Pilon, Paris");
    private Delivery lowCostRelayDelivery = new RelayDelivery(27);

    @Test
    public void Given_2productAndDelivery_When_GeneratingBill_Then_GetGoodLineNumber(){
        Bill bill = new Bill(customer, lowCostRelayDelivery);
        bill.addProduct(cafe,1);
        bill.addProduct(tv,1);
        try {
            bill.generate(writterMock);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int lineNumber = output.split("%n").length;
        assertEquals(20,lineNumber);
    }

    @Test
    public void Given_3productAndDelivery_When_GeneratingBill_Then_GetGoodTotal(){
        Bill bill = new Bill(customer, lowCostRelayDelivery);
        bill.addProduct(cafe,1);
        bill.addProduct(tv,1);
        bill.addProduct(fridge,1);
        assertEquals(870.98,bill.getTotal(),0.01);
    }

}