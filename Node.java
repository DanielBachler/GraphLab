
import java.util.LinkedList;

public class Node {
    public int value;
    public char label;
    public LinkedList<Node> neighbors;
    public boolean visited = false;

    public Node(int value, char label) {
        this.value = value;
        this.label = label;
    }

    public void addNeighbors(LinkedList<Node> neighbors) {
        this.neighbors = neighbors;
    }

    //Checks for unvisited neighbors, if none are found then -1 is returned.
    //Returns the first found neighbor that has not been visited
    public Node firstUnvisitedNeighbor() {
        for(Node n : neighbors) {
            if(!n.visited) {
                return n;
            }
        }
        return null;
    }

    public boolean allNeighborsVisited() {
        boolean visited = true;
        for(Node n: neighbors) {
            if(!n.visited) {
                visited = false;
            }
        }
        return visited;
    }

    //REturns a boolean that represents whether all neighbors have been visited
    public boolean allNVisted() {
        boolean allVisited = false;
        for(Node n: neighbors) {
            if(!n.visited) {
                allVisited = false;
            }
        }
        return allVisited;
    }
}
