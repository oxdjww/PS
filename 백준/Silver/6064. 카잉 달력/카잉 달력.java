import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        
        StringBuilder sb = new StringBuilder();
        while (T-- > 0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            int answer = -1;            
            
            for (int i = 0; i < N; i++) {
                long year = (long) x + (long) i * M;
              
                if (year > (long) M * N)
                {
                    break;
                }
                
                if (y == N)
                {
                    if (year % N == 0)
                    {
                        answer = (int) year;
                        break;
                    }
                }
                else
                {
                    if (year % N == y)
                    {
                        answer = (int) year;
                        break;
                    }
                }
            }
            
            sb.append(answer).append("\n");
        }
        
        System.out.print(sb);
    }
}
