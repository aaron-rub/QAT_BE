package com.nighthawk.spring_portfolio.mvc.jordans;

public abstract class Jordan {
    private String name;
    private String make;
    private double price;

    public Jordan(String name, String make, double price) {
        this.name = name;
        this.make = make;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getMake() {
        return make;
    }

    public double getPrice() {
        return price;
    }

    // Abstract method for sorting
    public abstract void sortJordan();
}
