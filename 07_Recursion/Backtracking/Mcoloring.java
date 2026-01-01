// M - Coloring Problem
// Problem Statement: Given an undirected graph and a number m, determine if the graph can be colored with at most m colors such that no two adjacent vertices of the graph are colored with the same color.
// Example 1:
// Input:
// N = 4  
// M = 3  
// E = 5  
// Edges[] = {  
//   (0, 1),  
//   (1, 2),  
//   (2, 3),  
//   (3, 0),  
//   (0, 2)  
// }  
// Output:
//  1  
// Explanation:
// It is possible to color the given graph using 3 colors, so the answer is 1 (possible)
// Example 2:
// Input:
  
// N = 3  
// M = 2  
// E = 3  
// Edges[] = {  
//   (0, 1),  
//   (1, 2),  
//   (0, 2)  
// }  
// Output:
//  0  
// Explanation:
  
// It is not possible to color the graph using 2 colors as it forms a triangle, which requires at least 3 colors. Hence, the answer is 0 (not possible).
public class Mcoloring {
    public static boolean isSafe(int node, int[][] edges, int[] color, int n, int col) {
        for (int it : edges[node]) {
            if (color[it] == col) return false;
        }
        return true;
    }

    public static boolean GraphSol(int node, int[][] edges, int[] color, int n, int m) {
        if (node == n) { // all nodes covered
            return true;
        }

        for (int i = 1; i <= m; i++) {
            if (isSafe(node, edges, color, n, i)) {
                color[node] = i;
                if (GraphSol(node + 1, edges, color, n, m)) {
                    return true;
                }
                color[node] = 0;
            }
        }
        return false;
    }

    public static boolean GraphColoring(int[][] edges, int m, int n) { 
        int[] color = new int[n];   // should be n, not m
        return GraphSol(0, edges, color, n, m);
    }

    public static void main(String[] args) {
        // Example graph: 4 nodes
        int n = 4; // number of nodes
        int m = 3; // number of colors

        // adjacency list representation
        int[][] edges = {
            {1, 2},    // neighbors of node 0
            {0, 2},    // neighbors of node 1
            {0, 1, 3}, // neighbors of node 2
            {2}        // neighbors of node 3
        };

        if (GraphColoring(edges, m, n)) {
            System.out.println("Graph can be colored with " + m + " colors.");
        } else {
            System.out.println("Graph cannot be colored with " + m + " colors.");
        }
    }
}
