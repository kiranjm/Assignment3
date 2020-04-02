package com.examplef.kiran.assignment3;

public class order
{
    private String name;
    private double price;
    private int quantity;
    private int tip;

    public double getPrice() {
        return price;
    }

    public int getTip() {
        return tip;
    }

    public void setTip(int tip) {
        this.tip = tip;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public order()
    {
        this.name="";
        this.price=0.0;
        this.quantity=0;
        this.tip=0;

    }
}
