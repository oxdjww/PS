import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static int m;
    private static List<List<Integer>> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dfs(0, 0, new ArrayList<>());

        for (List<Integer> list : answer) {
            for (int idx : list) {
                System.out.print(idx + " ");
            }
            System.out.println();
        }
    }

    private static void dfs(int start, int depth, List<Integer> current) {
        if (depth == m) {
            answer.add(new ArrayList<>(current));
            return;
        }

        for (int i = start + 1; i <= n; i++) {
            current.add(i);
            dfs(i, depth + 1, new ArrayList<>(current));
            current.remove(current.size() - 1);
        }
    }
}