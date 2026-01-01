import java.util.ArrayList;
import java.util.Arrays;
public class DFSpractice{
    public static void dfs(int node , ArrayList<ArrayList<Integer>> adjList, boolean[] visited , ArrayList<Integer> dfs){
        visited[node] = true;
        dfs.add(node);

        for(Integer it : adjList.get(node)){
            if(visited[it] == false){
                dfs(it , adjList , visited , dfs);
            }
        }
    }
    public static ArrayList<Integer> dfsTraversal(ArrayList<ArrayList<Integer>> adjList){
        int v = adjList.size();
        boolean[] visited = new boolean[v];
        visited[0] = true;
        ArrayList<Integer> dfs = new ArrayList<>();
        dfs(0,adjList,visited,dfs);
        return dfs;
    }
    public static void main(String[] args) {
        // FIXED: Proper adjacency list initialization
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).addAll(Arrays.asList(1, 2));
        adj.get(1).addAll(Arrays.asList(0, 3));
        adj.get(2).addAll(Arrays.asList(0, 4));
        adj.get(3).add(1);
        adj.get(4).add(2);

        ArrayList<Integer> result = dfsTraversal(adj);

        for (int x : result) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}