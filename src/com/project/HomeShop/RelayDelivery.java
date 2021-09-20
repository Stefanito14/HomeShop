package com.project.HomeShop;

public class RelayDelivery implements Delivery{

    public RelayDelivery(int relayNumber) {
        this.relayNumber = relayNumber;
    }

    private int relayNumber;
    @Override
    public double getPrice() {
        if (relayNumber>=1 && relayNumber <= 22)
            return 0;
        else if(relayNumber >22 && relayNumber <= 47)
            return 2.99;
        else
            return 4.99;

    }
}
