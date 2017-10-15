package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    private static final String matrixFile = "matrix.txt";
    private static final String infoFile = "matrixInfo.txt";
    private static char[] labels;
    private static int[][] aMatrix;
    private static int numLabels;
    private static LinkedList<Node> arrays;
    private static char[] visited;

    public static void main(String[] args) throws FileNotFoundException{
        readFromFile();
        depthFirst();
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
        numLabels = tempLabels.length();
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
                int insert = 2;
                if(row.charAt(j) == 48) {
                    insert = 0;
                } else if(row.charAt(j) == 49) {
                    insert = 1;
                }
                aMatrix[i][j] = insert;
            }
        }
        //Initializes visited with the proper length
        visited = new char[numLabels];
    }

    public static void breadthFirstSearch() {
        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(0);
        while(!queue.isEmpty()) {
            for(int i = 0; i < numLabels; i++) {

            }
        }

    }

    //Prints the matrix
    public static void printStuff() {
        for(int i = 0; i < aMatrix.length; i++) {
            for(int j = 0; j < aMatrix[i].length; j++){
                System.out.print(aMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void depthFirst(){

        Stack<Integer> stack = new Stack<>();
        Integer[] temp;
        temp = arrays.get(0);
        stack.push(0);
        visited[0] = 1;
        while (!stack.isEmpty()){
            System.out.print(labels[(stack.pop())]);

            for (int i = 0; i < temp.length; i++) {
                if (visited[temp[i]] == 0) {
                    stack.push(temp[i]);
                    visited [temp[i]] = 1;
                    temp = arrays.get(temp[i]);
                }

            }
        }


    }
}
