import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        
        int[] A = new int[N];
        for (int i = 0; i < N; i++)
        {
            A[i] = scanner.nextInt();
        }

        int[] dp = new int[N];
        Arrays.fill(dp, 1);

        for (int i = 1; i < N; i++)
        {
            for (int j = 0; j < i; j++)
            {
                if (A[i] > A[j])
                {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int result = Arrays.stream(dp).max().getAsInt();
        System.out.println(result);
    }
}
