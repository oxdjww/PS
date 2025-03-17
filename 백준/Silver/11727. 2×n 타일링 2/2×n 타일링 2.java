import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        long[] dp = new long[1001];
        
        dp[1] = 1;
        dp[2] = 3;
        
        for (int i = 3; i <= 1000; i++)
        {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 2]) % 10007;
        }

        int n = scanner.nextInt();
        
        System.out.println(dp[n]);
    }
}
