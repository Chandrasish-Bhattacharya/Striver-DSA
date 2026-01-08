
import java.util.ArrayList;
import java.util.List;

// Input: adj=[ [1, 0, 0, 1], [0, 1, 1, 0], [0, 1, 1, 0], [1, 0, 0, 1] ]
// Output: 2
// Explanation: In this graph, there are two provinces: [1, 4] and [2, 3]. City 1 and city 4 have a path between them, and city 2 and city 3 also have a path between them. There is no path between any city in province 1 and any city in province 2.
// Input: adj= [ [1, 0, 1], [0, 1, 0], [1, 0, 1] ]
// Output: 2
// Explanation :  The graph clearly has 2 Provinces [1,3] and [2]. As city 1 and city 3 has a path between them they belong to a single province. City 2 has no path to city 1 or city 3 hence it belongs to another province.
// Problem Statement: Given an undirected graph with V vertices. Two vertices u and v belong to a single province if there is a path from u to v or v to u. Find the number of provinces. The graph is given as an n x n matrix adj where adj[i][j] = 1 if the ith city and the jth city are directly connected, and adj[i][j] = 0 otherwise.
public class Numberofprovinces {

    public int findCircleNum(int[][] isConnected) {
        int v = isConnected.length;
        boolean visited[] = new boolean[v];
        int count = 0;
        List<List<Integer>> adj = new ArrayList<>();
        // lets make the sub list 
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        // now we can convert the adj matrix to the adj matrix to adj list 
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                count++;
                dfs(i, adj, visited);
            }
        }
        return count;
    }

    public static void dfs(int node, List<List<Integer>> adj, boolean[] visited) {
        visited[node] = true;
        for (Integer i : adj.get(node)) {
            if (visited[i] == false) {
                dfs(i, adj, visited);
            }
        }
    }

    public class Main {

        public static void main(String[] args) {
            // Input adjacency matrix
            int[][] adj = {
                {1, 0, 1},
                {0, 1, 0},
                {1, 0, 1}
            };

            // Number of vertices
            int V = 3;

            // Create object of Solution class
            Numberofprovinces sol = new Numberofprovinces();

            // Call function and print result
            System.out.println(sol.findCircleNum(adj));
        }
    }
}
