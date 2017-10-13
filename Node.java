public class Node {
    public int value;
    public char label;
    public int[] neighbors;
    public boolean visited = false;

    public Node(int value, char label, int[] neighbors) {
        this.value = value;
        this.label = label;
        this.neighbors = neighbors;
    }

    //Checks for unvisited neighbors, if none are found then -1 is returned
    public int firstUnvisitedNeighbor() {

        return -1;
    }
}
