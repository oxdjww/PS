import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        boolean flag = false;
        Stack<Character> stk = new Stack<>();
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);
            if (current == '<') {
                flag = true;
            }
            if (current == '>') {
                result += current;
                flag = false;
                continue;
            }

            if (flag) {
                while (!stk.isEmpty()) {
                    result += stk.pop();
                }
                result += current;
                continue;
            } else {
                if (current == ' ') {
                    while (!stk.isEmpty()) {
                        result += stk.pop();
                    }
                    result += current;
                    continue;
                }
                stk.push(current);
                continue;
            }
        }

        while (!stk.isEmpty()) {
            result += stk.pop();
        }

        System.out.println(result);
    }

    private static String reverseString(String str) {
        String result = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            result += str.charAt(i);
        }
        return result;
    }
}