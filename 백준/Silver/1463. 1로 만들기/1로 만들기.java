import java.io.*;
import java.util.*;

public class Main {
    private static Queue<int[]> queue = new LinkedList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        queue.offer(new int[]{n, 0});

        while(!queue.isEmpty())
        {
            int[] cur = queue.poll();
            int value = cur[0];
            int count = cur[1];
            
            if(value == 1)
            {
                System.out.print(count);
                return;
            }

            if(value % 3 == 0)
                queue.offer(new int[]{value/3, count+1});
            if(value % 2 == 0)
                queue.offer(new int[]{value/2, count+1});
            queue.offer(new int[]{value - 1, count+1});
        }
    }
}