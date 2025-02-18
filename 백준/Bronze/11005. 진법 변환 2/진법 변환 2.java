import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long number = scanner.nextLong();
        int B = scanner.nextInt();

        int k = 0;
        while (Math.pow(B, k) <= number) {
            k++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = k - 1; i >= 0; i--) 
        {
            long power = (long)Math.pow(B, i);
            long digit = number / power;
            sb.append(digit >= 10 ? String.valueOf((char)('A' + digit - 10)) : digit);
            number = number % power;
        }

        System.out.println(sb.toString());
    }
}
