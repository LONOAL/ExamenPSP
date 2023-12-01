package org.example.Arrays;

import java.util.ArrayList;

public class SearchingThread extends Thread {

    private int highestNum = 0;
    private NumGenerator numGenerator;
    private ArrayList<Integer> numList;
    private int arrayNum;

    public SearchingThread (NumGenerator numGenerator, int arrayNum) {
        this.numGenerator = numGenerator;
        this.arrayNum = arrayNum;
    }

    @Override
    public void run() {
        numList = numGenerator.splitArray(arrayNum-1);
        highestNum = numGenerator.getHighestNumer(numList);
        System.out.println(highestNum);
        numGenerator.addFinals(highestNum);
    }

    public int getHighestNum() {
        return highestNum;
    }


}
