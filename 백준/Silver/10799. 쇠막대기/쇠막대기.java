import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] line = br.readLine().toCharArray();
        Stack<Character> stk = new Stack<>();
        int answer = 0;
        for (int i = 0; i < line.length; i++) {
            char current = line[i];

            if (current == '(') {
                stk.push(current);
            } else {
                stk.pop();
                if (line[i - 1] == '(') {
                    answer += stk.size();
                } else {
                    answer += 1;
                }
            }
        }
        System.out.println(answer);
    }
}