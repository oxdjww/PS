import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static int m;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dfs(0, 0, new ArrayList<>(), new boolean[n + 1]);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void dfs(int start, int depth, List<Integer> current, boolean[] visited) {
        if (depth == m) {
            for (int num : current) {
                sb.append(num + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            visited[i] = true;
            current.add(i);
            dfs(i, depth + 1, new ArrayList<>(current), visited);
            visited[i] = false;
            current.remove(current.size() - 1);
        }
    }
}