import java.io.*;
import java.util.*;

public class Main {
    private static Set<Character> usedKeys = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            String[] words = line.split(" ");
            int index = -1;
            int pos = 0;

            for (String word : words) {
                char c = word.charAt(0);
                if (!usedKeys.contains(Character.toLowerCase(c))) {
                    usedKeys.add(Character.toLowerCase(c));
                    index = pos;
                    break;
                }
                pos += word.length() + 1;
            }

            if (index == -1) {
                for (int j = 0; j < line.length(); j++) {
                    char c = line.charAt(j);
                    if (c == ' ')
                        continue;
                    if (!usedKeys.contains(Character.toLowerCase(c))) {
                        usedKeys.add(Character.toLowerCase(c));
                        index = j;
                        break;
                    }
                }
            }

            if (index != -1) {
                System.out
                        .println(line.substring(0, index) + "[" + line.charAt(index) + "]" + line.substring(index + 1));
            } else {
                System.out.println(line);
            }
        }
    }
}
