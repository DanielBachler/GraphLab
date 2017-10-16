
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    private static final String matrixFile = "matrix.txt";
    private static final String infoFile = "matrixInfo.txt";
    private static char[] labels;
    private static int[][] aMatrix;
    private static int numLabels;
    private static LinkedList<Node> arrays = new LinkedList<>();
    private static String dfsResults = "";
    private static String dfsResults2 = "";

    public static void main(String[] args) throws FileNotFoundException {
        readFromFile();
        createNodes();
        System.out.println("Depth First Search Visits:");
        depthFirst(arrays.get(0));
        System.out.println("\nBreadth First Search Visits:");
        breadthFirst(arrays.get(0));
        System.out.println("\nMinimum Spanning Tree:");
        //
        System.out.println();
        minnimumSpanningTree1(arrays.get(0));
        minimumSpanningTree();
    }

    //Reads the needed information into the program
    public static void readFromFile() throws FileNotFoundException {
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
        for (int i = 0; i < numLabels; i++) {
            labels[i] = tempLabels.charAt(i);
        }

        //Reads in adjacency matrix.
        aMatrix = new int[numLabels][numLabels];
        fileReader = new Scanner(matrix);
        for (int i = 0; i < numLabels; i++) {
            String row = fileReader.nextLine();
            for (int j = 0; j < numLabels; j++) {
                int insert = 2;
                if (row.charAt(j) == 48) {
                    insert = 0;
                } else if (row.charAt(j) == 49) {
                    insert = 1;
                }
                aMatrix[i][j] = insert;
            }
        }
    }

    //Prints the matrix
    public static void printStuff() {
        for (int i = 0; i < aMatrix.length; i++) {
            for (int j = 0; j < aMatrix[i].length; j++) {
                System.out.print(aMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void depthFirst(Node start) {
        resetNodes();
        Stack<Node> stack = new Stack<>();
        stack.push(start);
        while (!stack.isEmpty()) {
            Node temp = stack.peek();
            if (!temp.visited) {
                System.out.print(temp.label + " ");
                dfsResults += temp.label;
                temp.visited = true;
            }

            if (!temp.allNeighborsVisited()) {
                stack.push(temp.firstUnvisitedNeighbor());
            } else {
                stack.pop();
            }
        }


    }

    public static void breadthFirst(Node start) {
        resetNodes();
        Queue<Node> queue = new LinkedList<>();
        queue.add(start);
        System.out.print(start.label + " ");
        Node temp = start;
        temp.visited = true;
        while (!queue.isEmpty()) {
            temp = queue.remove();
            Node tempy = null;
            while ((tempy = temp.firstUnvisitedNeighbor()) != null) {
                tempy.visited = true;
                System.out.print(tempy.label + " ");
                queue.add(tempy);
            }
        }
    }

    public static void minimumSpanningTree() {
        System.out.println();
        System.out.println(dfsResults2);
        for (int i = 0; i < dfsResults2.length() - 1; i++) {
            if(dfsResults2.charAt(i+1) == '+') {
                System.out.print(dfsResults2.charAt(i+2) + "" + dfsResults2.charAt(i+3) + " ");
                i = i + 2;

            }
            else {
                System.out.print(dfsResults2.charAt(i) + "" + dfsResults2.charAt(i+1) + " ");
            }
        }

    }

    public static void createNodes() {
        //Making Nodes
        for (int i = 0; i < labels.length; i++) {
            Node temp = new Node(i, labels[i]);
            arrays.add(temp);
        }
        //Find neighbors and give to each node
        for (int i = 0; i < aMatrix.length; i++) {
            LinkedList<Node> neighbors = new LinkedList<>();
            for (int j = 0; j < aMatrix[i].length; j++) {
                if (aMatrix[i][j] == 1) {
                    neighbors.add(arrays.get(j));
                }
            }
            Node temp = arrays.get(i);
            temp.addNeighbors(neighbors);
            //arrays.set(i, temp);
        }
    }

    //Resets nodes to be used in new algorithm
    public static void resetNodes() {
        for (Node n : arrays) {
            n.visited = false;
        }
    }

    public static void minnimumSpanningTree1(Node start) {
        resetNodes();
        Stack<Node> stack = new Stack<>();
        stack.push(start);
        int i = 0;
        while (!stack.isEmpty()) {

            Node temp = stack.peek();
            if (temp == start && i != 0 && i != (labels.length - 1) * 2) {
                System.out.print("+" + " " + start.label + " ");
                dfsResults2 += ("+" + start.label);
            }
            i++;
            if (!temp.visited) {
                System.out.print(temp.label + " ");
                dfsResults2 += (temp.label);
                temp.visited = true;
            }

            if (!temp.allNeighborsVisited()) {
                stack.push(temp.firstUnvisitedNeighbor());
            } else {
                stack.pop();
            }
        }
       // dfsResults2 += " ";
    }
}
