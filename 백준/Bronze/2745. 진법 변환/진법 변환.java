import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String number = scanner.next();
        int B = scanner.nextInt();

        int answer = 0;
        for(int i = 0 ; i < number.length() ; i++)
        {
            char ch = number.charAt(number.length()- 1 - i);
            int n;
            if (ch >= 'A' && ch <= 'Z') {
                n = ch - 'A' + 10;
            }
            else
            {
                n = ch - '0';
            }
            answer += Math.pow(B, i) * n;
        }
        System.out.println(answer);
    }
}
