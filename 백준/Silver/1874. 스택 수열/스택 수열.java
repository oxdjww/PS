import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> stk = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int N =Integer.parseInt(st.nextToken());
        int index = 1;
        for(int i = 0 ; i < N ; i++)
        {
            int currentInput = Integer.parseInt(br.readLine());

            while(index <= currentInput)
            {
                stk.push(index);
                sb.append("+\n");
                index++;
            }
            if(!stk.isEmpty() && stk.peek() == currentInput)
            {
                stk.pop();
                sb.append("-\n");
            }
            else
            {
                System.out.println("NO");
                return;
            }
        }
        
        System.out.print(sb);
    }
}