import java.util.*;
import java.io.*;

public class Main {
    private static PriorityQueue<Integer> pq = new PriorityQueue<>(
        (idx1, idx2) -> Integer.compare(idx2, idx1)
    );
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++)
        {
            int input = scanner.nextInt();
            if(input == 0)
            {
                if(pq.isEmpty()) sb.append("0").append("\n");
                else sb.append(pq.poll()).append("\n");
            }
            else
            {
                pq.offer(input);
            }
        }
        System.out.print(sb.toString());
    }
}
