import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] waiting = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++)
        {
            waiting[i] = Integer.parseInt(st.nextToken());
        }
        
        Stack<Integer> stk = new Stack<>();
        int idx = 1;
        for(int i = 0 ; i < N ; i++)
        {
            while (!stk.isEmpty() && stk.peek() == idx) {
                stk.pop();
                idx++;
            }
            
            if(waiting[i] != idx)
            {
                stk.push(waiting[i]);
            }
            else
            {
                idx++;
            }
        }
        while(stk.size() != 0)
        {
            if(stk.peek() == idx)
            {
                stk.pop();
                idx++;
            }
            else
            {
                break;
            }
        }
        System.out.println(stk.size() == 0 ? "Nice" : "Sad");
    }
}