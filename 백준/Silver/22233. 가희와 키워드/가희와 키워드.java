import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> keywords = new HashSet<>();

        for (int i = 0; i < N; i++) {
            keywords.add(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            String line = br.readLine();
            String[] lineArray = line.split(",");
            for (String input : lineArray) {
                if (keywords.contains(input)) {
                    keywords.remove(input);
                }
            }
            bw.write(String.valueOf(keywords.size()));
            bw.newLine();
        }
        bw.flush();
    }
}