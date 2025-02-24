import java.io.*;
import java.util.*;

public class Main {
    private static PriorityQueue<int[]> pq = new PriorityQueue<>(
        (arr1, arr2) -> arr1[1] == arr2[1] ? Integer.compare(arr1[0], arr2[0]) : Integer.compare(arr1[1], arr2[1])
    );
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++)
        {
            int input = Integer.parseInt(br.readLine());

            if (input != 0)
            {
                pq.add(new int[]{input, Math.abs(input)});
            }
            else
            {
                if (pq.isEmpty())
                {
                    sb.append("0\n");
                }
                else
                {
                    int[] top = pq.poll();
                    sb.append(top[0]).append("\n");
                }
            }
        }

        System.out.print(sb);
    }
}
