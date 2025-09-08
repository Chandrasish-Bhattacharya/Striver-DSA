import java.util.Arrays;
import java.util.Comparator;

public class Job_sequencing_Problem {

    public int[] JobScheduling(int[][] Jobs) {
        // Sort jobs by profit in descending order
        Arrays.sort(Jobs, (a, b) -> b[2] - a[2]);

        // Find the maximum deadline
        int maxDeadline = 0;
        for (int[] job : Jobs) {
            maxDeadline = Math.max(maxDeadline, job[1]);
        }

        // Track occupied time slots
        boolean[] slot = new boolean[maxDeadline];
        int total_profit = 0;
        int count = 0;

        for (int[] job : Jobs) {
            // Try to find a free slot from job[1] - 1 to 0
            for (int j = job[1] - 1; j >= 0; j--) {
                if (!slot[j]) {
                    slot[j] = true;
                    total_profit += job[2];
                    count++;
                    break;
                }
            }
        }

        return new int[]{count, total_profit};
    }

    public static void main(String[] args) {
        Job_sequencing_Problem jobSequencing = new Job_sequencing_Problem();
        int[][] Jobs = {
            {1, 4, 40},
            {2, 1, 10},
            {3, 1, 40},
            {4, 1, 30}
        };
        int[] result = jobSequencing.JobScheduling(Jobs);
        System.out.println("Number of jobs done: " + result[0]);
        System.out.println("Total profit: " + result[1]);
    }
}
