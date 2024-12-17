import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        if(i%2==0)
            System.out.printf("%d is even\n", i);
        else
            System.out.printf("%d is odd\n", i);
    }
}