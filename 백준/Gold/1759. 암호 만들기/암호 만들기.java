import java.util.*;
import java.io.*;

public class Main {

    private static int L, C;
    private static List<String> answer = new ArrayList<>();
    private static String[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new String[C];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            arr[i] = st.nextToken();
        }

        Arrays.sort(arr);

        // acistw

        dfs("", 0, 0, 0);

        for (int i = 0; i < answer.size(); i++) {
            bw.write(answer.get(i) + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static void dfs(String curr, int index, int vowelCount, int nonVowelCount) {
        if (curr.length() == L) {
            // System.out.println(curr);
            if (vowelCount >= 1 && nonVowelCount >= 2)
                answer.add(curr);
            return;
        }

        for (int i = index; i < C; i++) {
            String next = arr[i];
            if (isVowel(next)) {
                dfs(curr + next, i + 1, vowelCount + 1, nonVowelCount);
            } else {
                dfs(curr + next, i + 1, vowelCount, nonVowelCount + 1);
            }
        }
    }

    private static boolean isVowel(String ch) {
        return ch.equals("a") || ch.equals("e") || ch.equals("i") || ch.equals("o") || ch.equals("u");
    }
}
