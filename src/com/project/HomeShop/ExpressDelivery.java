package com.project.HomeShop;

public class ExpressDelivery implements Delivery{

    private String ville;
    public ExpressDelivery(String ville) {
        this.ville = ville;
    }

    @Override
    public double getPrice() {
        if(ville.equals("Paris"))
            return 6.99;
        else
            return 9.99;
    }

    @Override
    public String getInfo() {
        return "livraison express " + getPrice();
    }
}
