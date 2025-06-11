import java.util.*;
import java.io.*;

class Main {
    private static int N;
    private static int M;
    private static int[] arr;
    private static ArrayList<List<Integer>> answer = new ArrayList<>();

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        dfs(new boolean[N], new ArrayList<>());

        for (List<Integer> list : answer) {
            for (int idx : list) {
                System.out.print(idx + " ");
            }
            System.out.println();
        }
    }

    private static void dfs(boolean[] visited, List<Integer> list) {
        if (list.size() == M) {
            answer.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list.add(arr[i]);
                dfs(visited, list);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }
}