/**
 * @author: Yusuf Shaik (100 655 451)
 * Professor: Professor Zeinab
 * Assignment Name: Assignment 1
 * Due Date: February 20th 2019
 *
 * The purpose of this program is to take values from a file, and sort them into a min heap
 * The first line in the text file should contain the number of values (Eg: if the values are "4 5 3 2 1", then the first line should be 5)
 * The Second line should contain the actual values wished to be converted into a min heap. eg: "4 5 3 2 1"
 * The program will output the number of swaps it took to convert the values into a min heap, the locations of each swapped value, as well as the time it took for the algorithm to run
 *
 * PREVIOUS ATTEMPTS ARE INCLUDED IN AN ATTATCHED FILE TO SHOW PROGRESSION OF WORK
 *
 */

import java.io.*;
import java.util.Scanner;

public class MinHeap {

    public static void main(String args[])throws Exception {

        //This records the start time of the algorithm. The actual algorithm only starts here
        //Before this, the program is only taking in input
        double startTime=System.currentTimeMillis();

        //Initialize swap counter
        int m=0;

        //Set a variable equal to the file, and allow a file to be accepted through command prompt
        File data= new File(args[0]);

        BufferedReader fileReader= new BufferedReader(new FileReader(data));

        String value;

        //Set counter that will determine which line of the code is being read
        int y=0;

        //Set temporary variables
        String input1="";
        String input="";

        //Read through the file and set variables equal to first and second line
        while((value = fileReader.readLine())!=null)
        {
            y++;
            if(y==1){
                input1=value;
            }
            if(y==2){
                input=value;
            }

        }
        //Convert the first line read into an integer
        int n=Integer.parseInt(input1);



        //Convert the input from the user into a String Array
        String[] inputArray=input.split( " ");

        //Convert the Array of Strings into an Array of Integers
        int[] testArray = new int[inputArray.length+1];

        for (int i=0; i<inputArray.length; i++){

            testArray[i+1]=Integer.parseInt(inputArray[i]);
        }
        String swappedLocations="";

        //  Algorithm will run n times based on the number of values in the array
        for (int j = 0; j <n; j++) {

            //IF THERE ARE AN EVEN NUMBER OF VALUES IN THE ARRAY
            if(testArray.length%2==0) {
                for (int i = 1; i <= (testArray.length - 1) / 2; i++) {
                    if ((testArray[i]) > testArray[2 * i]) {
                        int hold = (testArray[i]);
                        testArray[i] = testArray[2 * i];
                        testArray[2 * i] = hold;
                        swappedLocations+= i + " " + (2 * i) + "\n";
                        m++;
                    }

                    if (testArray[i] > testArray[2 * i + 1]) {
                        int hold2 = testArray[i];
                        testArray[i] = testArray[2 * i + 1];
                        testArray[2 * i + 1] = hold2;
                        swappedLocations+= i + " " + (2 * i) + "\n";
                        m++;
                    }
                    else {
                        m += 0;
                    }
                }
            }
            //IF THERE IS AN ODD NUMBER OF VALUES IN THE ARRAY
            if(testArray.length%2==1){

                for (int i = 1; i <= (testArray.length)/ 2; i++) {
                    if ((testArray[i]) > testArray[2 * i]) {
                        int hold = (testArray[i]);
                        testArray[i] = testArray[2 * i];
                        testArray[2 * i] = hold;
                        swappedLocations+= i + " " + (2 * i) + "\n";
                        m++;
                    }

                    if ((2*i+1)<testArray.length && testArray[i] > testArray[2* i + 1]) {
                        int hold2 = testArray[i];
                        testArray[i] = testArray[2 * i + 1];
                        testArray[2 * i + 1] = hold2;
                        swappedLocations+= i + " " + (2 * i) + "\n";

                        m++;
                    }
                    else{m+=0;}
                }
            }




        }
        //Prints the number of swaps and swapped locations
        System.out.println(m);
        System.out.println(swappedLocations);

        //Calculates and prints the time it too for the algorithm to run
        double endTime=System.currentTimeMillis();
        double finalTime=((endTime-startTime));
        System.out.print("It took ");
        System.out.format("%.3f", finalTime/1000);
        System.out.println(" seconds for the algorithm to run");



    }
}




