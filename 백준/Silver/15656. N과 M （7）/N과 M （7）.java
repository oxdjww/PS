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

        dfs(0, new ArrayList<>());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < answer.size(); i++) {
            List<Integer> list = answer.get(i);
            for (int idx : list) {
                sb.append(idx).append(" ");
            }
            if (i != answer.size() - 1)
                sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int current, List<Integer> list) {
        if (list.size() == M) {
            answer.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < N; i++) {
            list.add(arr[i]);
            dfs(i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}