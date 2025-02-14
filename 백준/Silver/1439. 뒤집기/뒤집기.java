import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        
        int zeroGroup = 0;
        int oneGroup = 0;

        char prevChar = S.charAt(0);
        if (prevChar == '0') zeroGroup++;
        else oneGroup++;

        for (int i = 1; i < S.length(); i++) {
            char currentChar = S.charAt(i);
            if (currentChar != prevChar) {
                if (currentChar == '0') zeroGroup++;
                else oneGroup++;
            }
            prevChar = currentChar;
        }

        System.out.println(Math.min(zeroGroup, oneGroup));
    }
}
