package com.project.HomeShop;

public class Product {

    private String name;
    private String description;
    private Double price;


    /**
     * Display a full description of the product
     */
    public void look(){

    }

    /**
     * Add a product to the bill
     * @param bill concerned bill
     * @param quantity quantity of product to add
     */
    public void buy(Bill bill, Integer quantity){

    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
