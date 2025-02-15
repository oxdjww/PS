import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        
        int start = 1;
        int end = 1;
        int count = 1;
        int sum = 1;
        while(end < N)
        {
            if(sum == N)
            {
                count++;
                end++;
                sum += end;
            }
            else if(sum > N)
            {
                sum -= start;
                start++;
            }
            else
            {
                end++;
                sum += end;
            }
        }
        System.out.println(count);
    }
}