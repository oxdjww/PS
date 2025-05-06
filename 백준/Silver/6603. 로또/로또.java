import java.util.*;
import java.io.*;

public class Main {

    private static int K;
    private static List<List<Integer>> answer = new ArrayList<>();
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean firstCase = true;

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("0")) {
                return;
            }

            if (!firstCase) {
                bw.write("\n");
            }
            firstCase = false;

            K = Integer.parseInt(command);
            arr = new int[K];

            for (int k = 0; k < K; k++) {
                arr[k] = Integer.parseInt(st.nextToken());
            }

            dfs(0, new ArrayList<Integer>());

            for (List<Integer> lotto : answer) {
                for (int index : lotto) {
                    bw.write(index + " ");
                }
                bw.write("\n");
            }
            bw.flush();
            answer.clear();
        }
    }

    private static void dfs(int index, List<Integer> lotto) {
        if (lotto.size() == 6) {
            answer.add(new ArrayList<>(lotto));
            return;
        }

        for (int i = index; i <= K - (6 - lotto.size()); i++) {
            lotto.add(arr[i]);
            dfs(i + 1, lotto);
            lotto.remove(lotto.size() - 1);
        }
    }
}
