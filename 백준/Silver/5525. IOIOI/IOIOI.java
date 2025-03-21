import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();
        
        String pattern = "";
        String[] arr = {"I", "O"};
        for(int i = 0 ; i < N * 2 ; i++)
        {
            pattern += arr[i%2];
        }
        pattern += "I";
        // System.out.print(pattern);

        String S = scanner.next();
        int count = 0;
        int patternLength = pattern.length();

        for (int i = 0; i <= M - patternLength; i++)
        {
            if (S.substring(i, i + patternLength).equals(pattern))
            {
                count++;
            }
        }

        System.out.println(count);
    }
}