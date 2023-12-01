package org.example.SuperMarket;

public class Main {
    public static void main(String[] args) {

        Cajas cajas = new Cajas(10);
        Cliente cliente;
        for (int i = 1; i < 11; i++) {
            cliente = new Cliente(i,cajas);
            cliente.start();
        }

    }
}