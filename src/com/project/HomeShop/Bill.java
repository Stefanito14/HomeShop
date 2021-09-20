package com.project.HomeShop;

import java.io.IOException;
import java.io.NotActiveException;
import java.util.HashMap;
import java.util.Map;

public class Bill {
    private Customer customer;
    private Map<Product,Integer> products = new HashMap<Product, Integer>();
    private Delivery delivery;

    public Bill(Customer customer, Delivery delivery) {
        this.customer = customer;
        this.delivery = delivery;
    }

    /**
     * Add a product with a quantity to the bill
     * @param product product to add
     * @param quantity quantity of the product to add
     */
    public void addProduct(Product product, Integer quantity){
        this.products.put(product,quantity);
    }

    public Customer getCustomer() {
        return customer;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void generate(Writter writter) throws IOException {
        if (products.isEmpty())
            throw new NoProductInBillException();
        writter.start();
        writter.writeLine("HomeShop compagnie");
        writter.writeLine("1 Place Charles de Gaulle, 75008 Paris");
        writter.writeLine("");
        writter.writeLine("Facture à l'attention de : ");
        writter.writeLine(customer.getFullname());
        writter.writeLine(customer.getAddress());
        writter.writeLine("");
        writter.writeLine("Mode de livraison : " + delivery.getInfo());
        writter.writeLine("");
        writter.writeLine("Produits : ");
        writter.writeLine("-----------------------------------------------------");
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            Product product = entry.getKey();
            Integer quantity = entry.getValue();
            writter.writeLine(product.getName() + " - " + product.getPrice() + " - " + quantity + " unité(s)");
            writter.writeLine(product.getDescription());
            writter.writeLine("");
        }
        writter.writeLine("Livraison : " + delivery.getPrice());
        writter.writeLine("-----------------------------------------------------");
        writter.writeLine("Total : " + this.getTotal());
        writter.stop();
    }

    public double getTotal(){
        double total = 0;

        for (Map.Entry<Product,Integer> entry : products.entrySet()){
            Product product = entry.getKey();
            Integer quantity = entry.getValue();
            total += product.getPrice() * quantity;
        }

        total += delivery.getPrice();
        return total;
    }
}
