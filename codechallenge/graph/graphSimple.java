package codechallenge.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;


public class graphSimple {
    public static class Node {
        private  int id;
        LinkedList<Node> adjacent = new LinkedList<>();
    
        private Node(int id) {
            this.id = id;
        }
    }

    private Node getNode(int id) {}

    private void addEdge(int source,  int destination) {

    }

    public boolean hasPathDfs(int source, int destination) {
        Node s = getNode(source);
        Node d = getNode(destination);
        HashSet<Integer> visited = new HashSet<>();

        return hasPathDfs(s, d, visited);
    }

    private boolean hasPathDfs(Node source, Node destination, HashSet<Integer>  visited) {
        if(visited.contains(source.id)) {
            return false;
        }

        visited.add(source.id);

        if(source == destination) {
            return  true;
        }

        for(Node child: source.adjacent) {
            if(hasPathDfs(child, destination, visited)) {
                return true;
            }
        }
        return false;
    }


    //BFS approach with a queue
    public boolean hasPathBfs(Node source, Node destination) {
        Queue<Node> nextToVisit = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        nextToVisit.add(source);

        if(source == destination) {
            return true;
        }

        while(!nextToVisit.isEmpty()) {
            Node node = nextToVisit.remove();
            if(node == destination) {
                return true;
            }

            if(visited.contains(node.id)) {
                continue;
            }
            visited.add(node.id);

            for(Node child : node.adjacent) {
                nextToVisit.add(child);
            }
        }

        return false;
    }
}
