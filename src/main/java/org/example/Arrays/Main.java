package org.example.Arrays;

public class Main {
    public static void main(String[] args) {
        NumGenerator numGenerator = new NumGenerator(100,10);
        numGenerator.arrayGenerator();

        SearchingThread thread1 = new SearchingThread(numGenerator,1);
        SearchingThread thread2 = new SearchingThread(numGenerator,2);
        SearchingThread thread3 = new SearchingThread(numGenerator,3);
        SearchingThread thread4 = new SearchingThread(numGenerator,4);
        SearchingThread thread5 = new SearchingThread(numGenerator,5);
        SearchingThread thread6 = new SearchingThread(numGenerator,6);
        SearchingThread thread7 = new SearchingThread(numGenerator,7);
        SearchingThread thread8 = new SearchingThread(numGenerator,8);
        SearchingThread thread9 = new SearchingThread(numGenerator,9);
        SearchingThread thread10 = new SearchingThread(numGenerator,10);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
        thread8.start();
        thread9.start();
        thread10.start();

        System.out.println("Highest number is "+numGenerator.getFinalNumber());

    }
}