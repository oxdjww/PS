import java.io.*;
import java.util.*;

public class Main {
    private static StringTokenizer st;
    private static Deque<Integer> dq = new LinkedList<>();
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < N ; i++)
        {
            execute(br.readLine());
        }
        System.out.print(sb.toString());
    }
    private static void execute(String input)
    {
        st = new StringTokenizer(input);
        String command = st.nextToken();
        switch (command) {
            case "1":
                dq.offerFirst(Integer.parseInt(st.nextToken()));
                break;

            case "2":
                dq.offerLast(Integer.parseInt(st.nextToken()));
                break;
            
            case "3":
                sb.append(dq.isEmpty() ? "-1" : dq.pollFirst()).append("\n");
                break;

            case "4":
                sb.append(dq.isEmpty() ? "-1" : dq.pollLast()).append("\n");
                break;

            case "5":
                sb.append(dq.size()).append("\n");
                break;

            case "6":
                sb.append(dq.isEmpty() ? "1" : "0").append("\n");
                break;

            case "7":
                sb.append(dq.isEmpty() ? "-1" : dq.peekFirst()).append("\n");
                break;

            case "8":
                sb.append(dq.isEmpty() ? "-1" : dq.peekLast()).append("\n");
                break;

            default:
                break;
        }
    }
}