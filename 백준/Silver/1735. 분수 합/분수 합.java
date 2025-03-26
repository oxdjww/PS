import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        
        long a = scanner.nextInt();
        long A = scanner.nextInt();

        long b = scanner.nextInt();
        long B = scanner.nextInt();

        long child = a * B + A * b;
        long parent = A * B;
        
        long div = gcd(child, parent);

        System.out.print(child/div + " " + parent/div);
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
