import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stk = new Stack<>();

        for(int i = 0 ; i < N ; i++)
        {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            switch (command) {
                case 1:
                    stk.push(Integer.parseInt(st.nextToken()));
                    break;
                case 2:
                if(stk.isEmpty()) System.out.println(-1);
                else System.out.println(stk.pop());
                    break;
                case 3:
                    System.out.println(stk.size());
                    break;
                case 4:
                    if(stk.empty()) System.out.println(1);
                    else System.out.println(0);
                    break;
                case 5:
                    if(stk.isEmpty()) System.out.println(-1);
                    else System.out.println(stk.peek());
                    break;
                default:
                    break;
            }
        }
    }
}