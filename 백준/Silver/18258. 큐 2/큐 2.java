import java.io.*;
import java.util.*;

public class Main {
    private static Deque<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < N; i++) {
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            String command = st.nextToken();
            
            switch (command) {
                case "push":
                    int arg = Integer.parseInt(st.nextToken());
                    queue.offer(arg);
                    break;

                case "pop":
                    sb.append(queue.isEmpty() ? "-1" : queue.poll()).append("\n");
                    break;

                case "size":
                    sb.append(queue.size()).append("\n");
                    break;

                case "empty":
                    sb.append(queue.isEmpty() ? "1" : "0").append("\n");
                    break;

                case "front":
                    sb.append(queue.isEmpty() ? "-1" : queue.peek()).append("\n");
                    break;

                case "back":
                    sb.append(queue.isEmpty() ? "-1" : queue.peekLast()).append("\n");
                    break;

                default:
                    break;
            }
        }
        System.out.print(sb.toString());
    }
}
