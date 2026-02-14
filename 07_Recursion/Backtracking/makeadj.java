import java.util.ArrayList;
import java.util.List;

public class makeadj {
    public static List<List<Integer>> makeadj(boolean[][] matrix) {
        List<List<Integer>> adjlist = new ArrayList<>();
        for (int r = 0; r < matrix.length; r++) {
            List<Integer> list = new ArrayList<>();
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c]) {
                    list.add(c);
                }
            }
            adjlist.add(list);
        }
         return adjlist;
     }

    public static void main(String[] args) {
        int N = 4; // Number of nodes

        // Create a sample graph with edges (0,1), (1,2), (2,3), (3,0), (0,2)
        boolean[][] graph = new boolean[N][N];
        graph[0][1] = graph[1][0] = true;
        graph[1][2] = graph[2][1] = true;
        graph[2][3] = graph[3][2] = true;
        graph[3][0] = graph[0][3] = true;
        graph[0][2] = graph[2][0] = true;

        List<List<Integer>> adjlist = makeadj(graph);
        for (int i = 0; i < adjlist.size(); i++) {
            System.out.println("Node " + i + " -> " + adjlist.get(i));
        }
    }
}



