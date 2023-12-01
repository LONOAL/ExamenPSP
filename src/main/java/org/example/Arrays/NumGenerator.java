package org.example.Arrays;

import java.util.ArrayList;

public class NumGenerator {

    private int arrayCapacity;
    private int arrayNumber;
    private ArrayList<Integer> numbers= new ArrayList<Integer>();
    private ArrayList<Integer> finalArray = new ArrayList<Integer>();


    public NumGenerator(int arrayCapacity, int arrayNumber){
        this.arrayCapacity = arrayCapacity;
        this.arrayNumber = arrayNumber;
    }

    public int getHighestNumer(ArrayList<Integer> numbers) {
        int highestNum=0;
        for (int i = 0; i < numbers.size(); i++){
            if (numbers.get(i)>highestNum){
                highestNum=numbers.get(i);
            }
        }
        return highestNum;

    }

    /**
     * Method that generates an array of random numbers
     */
    public void arrayGenerator(){
        int randomNumber = 0;
        for (int i = 0; i < arrayCapacity; i++) {
            randomNumber = (int) (Math.random()*(1001-500)+500);
            numbers.add(randomNumber);
            randomNumber=0;
        }
    }

    public ArrayList<Integer> splitArray(int arrayNumber){
        ArrayList<Integer> finalArray = new ArrayList<Integer>();
        ArrayList<Integer> tempArray = new ArrayList<Integer>();
        int arrayIndex = 0;
        int count = 0;
        for (int number: numbers) {
            tempArray.add(number);
            count++;
            if (arrayIndex==arrayNumber){
                finalArray=tempArray;
                return finalArray;
            }
            if (count==100/this.arrayNumber){
                count=0;
                tempArray.clear();
                arrayIndex++;
            }
        }
        return finalArray;
    }

    public void addFinals(int highest){
        finalArray.add(highest);
    }
    public synchronized int getFinalNumber(){
        while (finalArray.size()<10){
            try {
                wait(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return getHighestNumer(finalArray);
    }


}
