import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = s.length();

        int totalA = 0;
        for (char c : s.toCharArray()) {
            if (c == 'a')
                totalA++;
        }

        int minSwap = Integer.MAX_VALUE;
        int currentB = 0;

        for (int i = 0; i < totalA; i++) {
            if (s.charAt(i) == 'b')
                currentB++;
        }
        minSwap = currentB;

        for (int i = 1; i < n; i++) {
            int outIdx = (i - 1) % n;
            int inIdx = (i + totalA - 1) % n;

            if (s.charAt(outIdx) == 'b')
                currentB--;
            if (s.charAt(inIdx) == 'b')
                currentB++;

            minSwap = Math.min(minSwap, currentB);
        }

        System.out.println(minSwap);
    }
}
