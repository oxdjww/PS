import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        LinkedList<Integer> dq = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            dq.offerFirst(i);
        }
        st = new StringTokenizer(br.readLine());
        int count = 0;
        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(st.nextToken());
            int index = dq.indexOf(target);
            if (index < dq.size() / 2) {
                while (true) {
                    int current = dq.peekLast();
                    if (current == target) {
                        dq.pollLast();
                        break;
                    } else {
                        count++;
                        current = dq.pollFirst();
                        dq.offerLast(current);
                    }
                }
            } else {
                while (true) {
                    int current = dq.peekLast();
                    if (current == target) {
                        dq.pollLast();
                        break;
                    } else {
                        count++;
                        current = dq.pollLast();
                        dq.offerFirst(current);
                    }
                }
            }
        }
        System.out.println(count);
    }
}
