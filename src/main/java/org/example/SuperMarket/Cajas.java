package org.example.SuperMarket;

import java.util.ArrayList;
import java.util.Arrays;

public class Cajas {

    private int capacity;

    private ArrayList<ArrayList<Integer>> cajas;
    private ArrayList<Integer> caja;
    private boolean occupied;
    private boolean paying;
    private int money=0;




    public Cajas(int capacity) {
        occupied = false;
        paying = false;
        this.capacity = capacity;
        cajas = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < capacity; i++) {
            caja = new ArrayList<>(Arrays.asList(new Integer[10]));
            for (int x = 0; x < caja.size(); x++) {
                caja.set(x, 0);
            }
            cajas.add(caja);
        }
    }


    public synchronized void startShpping(Integer clientNumber, int numCaja) {
        while (occupied) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        occupied = true;
        caja = cajas.get(numCaja-1);
        for (Integer i : caja) {
            if (i == 0) {
                caja.set(caja.indexOf(i), clientNumber);
                break;
            }
        }
        occupied=false;
        System.out.println("Client " + clientNumber + " joined box "+numCaja+".");
        printCajas();
        notifyAll();
    }

    public synchronized void StarPaying (int clientNumber, int numCaja, int paid) {
        while (paying) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        paying = true;
        caja = cajas.get(numCaja-1);
        while (caja.get(0) != clientNumber) {
            try {
                paying=false;
                wait();
                paying= true;
                caja = cajas.get(numCaja-1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        caja.remove(0);
        caja.add(0);
        money += paid;
        paying=false;
        System.out.println("Client " + clientNumber + " payed "+paid+".");
        printCajas();
        notifyAll();
    }

    public void printCajas(){
        int count = 1;
        for (ArrayList<Integer> i : cajas){
            System.out.println("Caja "+count+": "+i.toString());
            count++;
        }
    }

}
