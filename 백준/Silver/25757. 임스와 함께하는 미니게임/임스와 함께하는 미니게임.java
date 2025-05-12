import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        String gameType = st.nextToken();

        Set<String> played = new HashSet<>();
        int to = 0;
        int count = 1;
        int answer = 0;
        if (gameType.equals("Y"))
            to = 2;
        else if (gameType.equals("F"))
            to = 3;
        else
            to = 4;
        for (int i = 0; i < n; i++) {
            String user = br.readLine();

            if (!played.contains(user)) {
                played.add(user);
                count++;

                if (count >= to) {
                    answer++;
                    count = 1;
                }
            }
        }
        System.out.println(answer);
    }
}