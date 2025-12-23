import java.util.ArrayList;
import java.util.Arrays;

public class DFS {
    public static void dfs(int node , ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> dfslist){
        visited[node] = true;
        dfslist.add(node);

        for(Integer it : adj.get(node)){
            if(!visited[it]){
                dfs(it , adj , visited , dfslist);
            }
        }
    }  

    public static ArrayList<Integer> dfsTraversal(int v , ArrayList<ArrayList<Integer>> adj){
        boolean visited[] = new boolean[v+1];
        visited[0] = true;
        ArrayList<Integer> dfslist = new ArrayList<>();
        dfs(0 , adj , visited , dfslist);
        return dfslist; 
    }

    public static void main(String[] args) {
        int V = 5;

        // FIXED: Proper adjacency list initialization
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).addAll(Arrays.asList(1, 2));
        adj.get(1).addAll(Arrays.asList(0, 3));
        adj.get(2).addAll(Arrays.asList(0, 4));
        adj.get(3).add(1);
        adj.get(4).add(2);

        ArrayList<Integer> result = dfsTraversal(V, adj);

        for (int x : result) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
