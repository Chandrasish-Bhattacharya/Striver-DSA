
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
public class ConnectedComponents{
    public static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adjList){
        ArrayList<Integer> bfsTraversal = new ArrayList<>();
        int v = adjList.size();
        boolean[] visited = new boolean[v];
        Queue<Integer> q = new LinkedList<>(); 

        q.add(0);
        visited[0] = true;

        while(!q.isEmpty()){
            Integer node = q.poll();
            bfsTraversal.add(node);

            for(Integer it : adjList.get(node)){
                if(!visited[it]){
                    visited[it] = true;
                    q.add(it);
                }
            }
        }
        return bfsTraversal;
    }
    public static void main(String args[]) {

        ArrayList < ArrayList < Integer >> adj = new ArrayList < > ();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(4);
        adj.get(4).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(1).add(3);
        adj.get(3).add(1);
        
        ArrayList < Integer > ans = bfs(adj);
        int n = ans.size(); 
        for(int i = 0;i<n;i++) {
            System.out.print(ans.get(i)+" "); 
        }
    }
}