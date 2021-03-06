import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    private static final String matrixFile = "matrix.txt";
    private static final String infoFile = "matrixInfo.txt";
    private static char[] labels;
    private static int[][] aMatrix;
    private static int numLabels;
    private static LinkedList<Integer[]> arrays;
    private static char[] visited;

    public static void main(String[] args) throws FileNotFoundException{
        readFromFile();
        makeArrays();
        depthFirt();
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

    //Creates a linked list with a number of arrays equal to tags
    //Every array contains the tags each tag is linked to, EX. A is connected to B and C
    //So the array that corresponds to A has the number that represents B and C
    public static void makeArrays() {
        //Initializes the linked list
        arrays = new LinkedList<>();
        //Counts through the amount of labels
        for(int i = 0; i < aMatrix[0].length; i++) {
            //Creates but doesn't initialize the integer array needed so it can be accessed throughout
            Integer[] temp;
            //The size the temp array needs to be, default 0
            int neededSize = 0;
            //Iterates through one row, for the specific line we're on
            for(int j = 0; j < aMatrix[i].length; j++)
                //If a connection is found increase needed size
                if(aMatrix[i][j] == 1)
                    neededSize++;
            //Initializes the temp array to the proper size
            temp = new Integer[neededSize];
            //Runs through the line again, checking for 1's
            for(int j = 0, k = 0; j < aMatrix[i].length; j++)
                //If a 1 is found, puts the label index into temp and increments k
                if(aMatrix[i][j] == 1)
                    temp[k++] = j;
            //Puts the array into arrays
            arrays.add(temp);
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
    public static void depthFirt(){

        Stack<Integer> stack = new Stack<>();
        Integer[] temp;
        temp = arrays.get(0);
        stack.push(0);
        visited[0] = 1;
        while (!stack.isEmpty()){
            System.out.print(labels[(stack.pop())]);

            for (int i = 0; i < temp.length; i++) {

                temp = arrays.get(temp[i]);
                if (visited[temp[i]] == 0) {
                    stack.push(temp[i]);
                    visited [temp[i]] = 1;
                    temp = arrays.get(temp[i]);
                }

            }
        }


    }
}
