import java.io.*;
import java.util.*;

public class Main {
    private static Deque<Integer> dq = new LinkedList<>();
    private static int L;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++)
        {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int idx = 0 ; idx < N ; idx++)
        {
            while(!dq.isEmpty() && dq.peekFirst() <= idx - L) dq.pollFirst();
            while(!dq.isEmpty() && arr[dq.peekLast()] > arr[idx]) dq.pollLast();
            dq.offerLast(idx);  

            sb.append(arr[dq.peekFirst()]).append(" ");
        }

        System.out.print(sb.toString());
    }
}