import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        int testcase = scanner.nextInt();
        for(int i = 0 ; i < testcase ; i++)
        {
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            sb.append(A * B / gcd(A, B)).append("\n");
        }
        System.out.print(sb);
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
