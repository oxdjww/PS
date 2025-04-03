import java.util.*;
import java.io.*;

public class Main {
    private static List<PriorityQueue> list = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < n ; i++)
        {
            list.add(new PriorityQueue<Integer>(Collections.reverseOrder()));
        }
        
        for(int i = 0 ; i < n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < n ; j++) {
                list.get(j).offer(Integer.parseInt(st.nextToken()));
            }
        }
        int answer = -1;
        for(int i = 0 ; i < n ; i++)
        {
            int maxValue = Integer.MIN_VALUE;
            int maxIndex = -1;
            for(int j = 0 ; j < n ; j++) {
                // System.out.println("peek: " + (int)list.get(j).peek() + ", j = " + j );
                if (maxValue < (int)list.get(j).peek()) {
                    maxValue = (int)list.get(j).peek();
                    maxIndex = j;
                }
            }
            answer = (int)list.get(maxIndex).poll();
            // System.out.println("answer: " + answer);
        }
        System.out.print(answer);
    }
}