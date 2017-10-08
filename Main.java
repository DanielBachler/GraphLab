package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    private static final String matrixFile = "matrix.txt";
    private static final String infoFile = "matrixInfo.txt";
    private static char[] labels;
    private static int[][] aMatrix;

    public static void main(String[] args) throws FileNotFoundException{
        readFromFile();
    }

    //Reads the needed information into the program
    public static void readFromFile() throws FileNotFoundException{
        //Creates both files, and the scanner for reading.
        //Files are not needed at samne time so only one scanner is needed
        File matrix = new File(matrixFile);
        File info = new File(infoFile);
        Scanner fileReader = new Scanner(info);

        //Gets the labels as one string, then creates and populates the labels array
        String tempLabels = fileReader.next();
        fileReader.close();
        int numLabels = tempLabels.length();
        labels = new char[numLabels];
        for(int i = 0; i < numLabels; i++) {
            labels[i] = tempLabels.charAt(i);
        }

        //Reads in adjacency matrix.
        aMatrix = new int[numLabels][numLabels];
        fileReader = new Scanner(matrix);
        for(int i = 0; i < numLabels; i++) {
            String row = fileReader.nextLine();
            for(int j = 0; j < numLabels; j++) {
                aMatrix[i][j] = row.charAt(j);
            }
        }
    }
}
