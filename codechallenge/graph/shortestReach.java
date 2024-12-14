/**
 * 
  HackerRank: https://www.hackerrank.com/challenges/bfsshortreach/problem
 * 
 * Consider an undirected graph where each edge weighs 6 units. Each of the nodes is labeled consecutively from 1 to n.

You will be given a number of queries. For each query, you will be given a list of edges describing an undirected graph. After you create a representation of the graph, you must determine and report the shortest distance to each of the other nodes from a given starting position using the breadth-first search algorithm (BFS). Return an array of distances from the start node in node number order. If a node is unreachable, return

for that node.

Example
The following graph is based on the listed inputs:

            (1)     (5)
          /    \
         (2)    (3)
                 |
                (4)

// number of nodes
// number of edges

// starting node

All distances are from the start node
. Outputs are calculated for distances to nodes through : . Each edge is units, and the unreachable node has the required return distance of

.

Function Description

Complete the bfs function in the editor below. If a node is unreachable, its distance is

.

bfs has the following parameter(s):

    int n: the number of nodes
    int m: the number of edges
    int edges[m][2]: start and end nodes for edges
    int s: the node to start traversals from

Returns
int[n-1]: the distances to nodes in increasing node number order, not including the start node (-1 if a node is not reachable)

Input Format

The first line contains an integer
, the number of queries. Each of the following

sets of lines has the following format:

    The first line contains two space-separated integers 

and
, the number of nodes and edges in the graph.
Each line
of the subsequent lines contains two space-separated integers, and , that describe an edge between nodes and
.
The last line contains a single integer,

    , the node number to start from.

Constraints

Sample Input

2
4 2
1 2
1 3
1
3 1
2 3
2

Sample Output

6 6 -1
-1 6

Explanation

We perform the following two queries:

    The given graph can be represented as:
    image
    where our start node, 

, is node . The shortest distances from to the other nodes are one edge to node , one edge to node , and an infinite distance to node (which it is not connected to). We then return an array of distances from node to nodes , , and (respectively):

.

The given graph can be represented as:
image
where our start node,
, is node . There is only one edge here, so node is unreachable from node and node has one edge connecting it to node . We then return an array of distances from node to nodes , and (respectively):

    .

Note: Recall that the actual length of each edge is
, and we return as the distance to any node that is unreachable from .
 */
package codechallenge.graph;


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



public class shortestReach {
    public static class Node {
        int id;
        LinkedList<Node> adjacent = new LinkedList<>();
    
        public Node(int id) {
            this.id = id;
        }
    }
    
    
    /*
     * Complete the 'bfs' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER m
     *  3. 2D_INTEGER_ARRAY edges
     *  4. INTEGER s
     */

    public static List<Integer> bfs(int numberOfNodes, int numberOfEdges, List<List<Integer>> edges, int startingNode) {
        // Write your code here
        List<Integer> output = new ArrayList<>();
        //build graph
        Node startNode  = buildGraph(edges, startingNode);
        Node cursorNode = startNode;
        Integer height = 6;
        HashSet<List> visited = new HashSet<>();
        Integer level = 1;

        for(int i = 0; i < numberOfEdges; i++) {
            output.add(-1);
        }
        
        for(int i = 0; i < edges.size(); i++) {
            List<Integer> edge = edges.get(i);
            Integer distance = getLevel(cursorNode, edge, level, visited) - 1;
            output.set(i, distance <= 0 ? -1 : height * distance);
            visited = new HashSet<>();
            cursorNode = startNode;
        }

        return output;
    }

    public static Node getNode(Integer id, Node node) {
        if(node == null) {
            return null;
        }

        if(node.id == id) {
            return node;
        }


        for(Node child : node.adjacent) {
            if(getNode(id, child) != null) {
                return child;
            }
        }

        return null;
    }

    public static Integer getLevel(Node node, List<Integer> edge, Integer level, HashSet<List> visited) {
        if(visited.contains(edge)) {
            return level;
        }
        visited.add(edge);

        if(edge.get(1) == node.id) {
            return level;
        }

        for(Node child : node.adjacent) {
            System.out.println("Calling with child: " + child.id + " node to find: " + node.id + visited );
            return level + getLevel(child, edge, level , visited);
        }

        return 0;
    }

    //BFS uses a queue
    public static Node buildGraph(List<List<Integer>> edges, int startingNode) {
        Node startNode = new Node(startingNode);
        Queue<List<Integer>> nextToBuildQueue = new LinkedList<>();
        HashSet<List> alreadyCreated = new HashSet();

        for(List<Integer> edge : edges) {
            Integer firstNode = edge.get(0);
            if( firstNode == startingNode) {
                nextToBuildQueue.add(edge); //add all edges from starting node.
            }
        }

        while(! nextToBuildQueue.isEmpty()) {
            List<Integer> toBuild = nextToBuildQueue.remove();
            Integer parentID = toBuild.get(0);
            Integer childId = toBuild.get(1);
           
            if(alreadyCreated.contains(toBuild)) {
                continue; //skip building
            }
            Node parent = getNode(parentID, startNode);
            parent.adjacent.add(new Node(childId));
            alreadyCreated.add(toBuild);

            //find all next to parent and add to list
            for(List<Integer> edge: edges) {
                Integer firstEdge = edge.get(0);
                if(!alreadyCreated.contains(edge) && childId == firstEdge) {
                    nextToBuildQueue.add(edge);
                }
            }

        }

        return startNode;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                List<List<Integer>> edges = new ArrayList<>();

                IntStream.range(0, m).forEach(i -> {
                    try {
                        edges.add(
                            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                int s = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> result = shortestReach.bfs(n, m, edges, s);

                bufferedWriter.write(
                    result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                    + "\n"
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}

