import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();
        
        String S = scanner.next();
        int count = 0, answer = 0;

        for (int i = 0; i + 2 < M; i++)
        {
            if(S.substring(i, i + 3).equals("IOI"))
            {
                count++;
                i++;
                if(count == N)
                {
                    count--;
                    answer++;
                }
            }
            else 
            {
                count = 0;
            }
        }

        System.out.println(answer);
    }
}