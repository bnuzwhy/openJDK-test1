package com.why.thread.productcustomer;

public class Main {
    public static void main(String[] args) {

        SynContainer container = new SynContainer();
        new Product(container).start();
        new Customer(container).start();
    }
}
