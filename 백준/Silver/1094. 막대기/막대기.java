import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        int x = new Scanner(System.in).nextInt();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(64);
        int sum = 64;
        int answer = 1;
        while (sum > x) {
            int shortest = queue.poll();
            int halfShortest = shortest / 2;
            if (sum - halfShortest >= x) {
                queue.offer(halfShortest);
                sum -= halfShortest;
            } else {
                queue.offer(halfShortest);
                queue.offer(halfShortest);
                answer++;
            }
        }
        System.out.println(answer);
    }
}