import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();
        for(int n = 0 ; n < N ; n++)
        {
            st = new StringTokenizer(br.readLine());
            int val = Integer.parseInt(st.nextToken());
            list.add(val);
        }
        Collections.sort(list, Collections.reverseOrder());
        int sum = 0;
        int count = 0;
        for (int num : list)
        {
            if (sum >= K) break;

            while (sum + num <= K)
            {
                sum += num;
                count++;
            }
        }
        System.out.println(count);
    }
}