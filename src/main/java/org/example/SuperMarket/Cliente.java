package org.example.SuperMarket;

public class Cliente extends Thread{

    private Cajas cajas;
    private int clientNumber;
    private int numCaja;

    public Cliente (int clientNumber, Cajas cajas) {
        this.clientNumber = clientNumber;
        this.cajas = cajas;
    }

    @Override
    public void run() {
        System.out.println("Client "+clientNumber+" arrived.");
        try {
            sleep((long) (Math.random()*(10001-500)+500));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        getCaja();
        cajas.startShpping(clientNumber,numCaja);
        try {
            sleep((long) (Math.random()*(10001-500)+500));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        cajas.StarPaying(clientNumber,numCaja,(int) (Math.random()*100+1));
    }

    public int getCaja() {
        numCaja= (int) (Math.random()*10+1);
        return numCaja;
    }

}
