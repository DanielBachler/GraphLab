public class Node {
    public int value;
    public char label;
    public Node[] neighbors;
    public boolean visited = false;

    public Node(int value, char label, Node[] neighbors) {
        this.value = value;
        this.label = label;
        this.neighbors = neighbors;
    }

    //Checks for unvisited neighbors, if none are found then -1 is returned
    public int firstUnvisitedNeighbor() {
        for(int i = 0; i < neighbors.length; i++) {
            if(!neighbors[i].visited) {
                return i;
            }
        }
        return -1;
    }
}
