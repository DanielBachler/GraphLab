package com.company;

import java.util.LinkedList;

public class Node {
    public int value;
    public char label;
    public LinkedList<Node> neighbors;
    public boolean visited = false;

    public Node(int value, char label, LinkedList<Node> neighbors) {
        this.value = value;
        this.label = label;
        this.neighbors = neighbors;
    }

    //Checks for unvisited neighbors, if none are found then -1 is returned.
    //Returns the first found neighbor that has not been visited
    public int firstUnvisitedNeighbor() {
        for(Node n : neighbors) {
            if(!n.visited) {
                return n.value;
            }
        }
        return -1;
    }
}
