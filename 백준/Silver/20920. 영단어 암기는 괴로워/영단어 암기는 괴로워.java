import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> count = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            if (input.length() >= M) {
                count.put(input, count.getOrDefault(input, 0) + 1);
            }
        }
        List<String> dict = new ArrayList<>(count.keySet());

        Collections.sort(dict, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (count.get(s1) != count.get(s2)) {
                    return Integer.compare(count.get(s2), count.get(s1));
                } else if (s1.length() != s2.length()) {
                    // 빈도수로 비교 불가
                    return Integer.compare(s2.length(), s1.length());
                } else {
                    return s1.compareTo(s2);
                }
            }
        });
        for (String element : dict) {
            bw.write(String.valueOf(element));
            bw.newLine();
        }
        bw.flush();
    }
}