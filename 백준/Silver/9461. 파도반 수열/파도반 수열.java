import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        long[] dp = new long[101];
        
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        
        for (int i = 4; i <= 100; i++)
        {
            dp[i] = dp[i - 2] + dp[i - 3];
        }

        int T = scanner.nextInt();
        
        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            System.out.println(dp[N]);
        }
    }
}
