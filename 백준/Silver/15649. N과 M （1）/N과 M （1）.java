import java.io.*;
import java.util.*;

public class Main {
    private static int[] arr;
    private static List<List<Integer>> answer = new ArrayList<>();
    private static int n;
    private static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = i;
        }

        // for (int i = 1; i <= n; i++) {
        dfs(new ArrayList<>(), new boolean[n + 1]);
        // }

        for (List<Integer> list : answer) {
            for (int element : list) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static void dfs(List<Integer> combine, boolean[] visited) {
        if (combine.size() == m) {
            answer.add(new ArrayList<>(combine));
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                combine.add(i);
                visited[i] = true;
                dfs(combine, visited);
                combine.remove(combine.size() - 1);
                visited[i] = false;
            }
        }
    }
}
