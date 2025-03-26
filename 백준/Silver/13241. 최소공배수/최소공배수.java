import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        
        long A = scanner.nextInt();
        long B = scanner.nextInt();
        System.out.print(A * B / gcd(A, B));
    }

    private static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
