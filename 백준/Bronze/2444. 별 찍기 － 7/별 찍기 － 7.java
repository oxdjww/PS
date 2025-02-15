import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String blank = " ";
        String star = "*";
        for(int i = 1 ; i <= n ; i++)
        {
            System.out.print(blank.repeat(n-i));
            System.out.print(star.repeat(2*i-1));
            System.out.println();
        }
        for(int i = n-1 ; i >= 1 ; i--)
        {
            System.out.print(blank.repeat(n-i));
            System.out.print(star.repeat(2*i-1));
            System.out.println();
        }
    }
}