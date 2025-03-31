import java.util.*;

public class Main {
    static final int MAX = 1_000_000;
    static boolean[] isPrime = new boolean[MAX + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        sieve();

        while (T-- > 0)
        {
            int N = sc.nextInt();
            int count = countGoldbachPartitions(N);
            System.out.println(count);
        }

        sc.close();
    }

    static void sieve()
    {
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= MAX; i++)
        {
            if (isPrime[i]) {
                for (int j = i * i; j <= MAX; j += i)
                {
                    isPrime[j] = false;
                }
            }
        }
    }

    static int countGoldbachPartitions(int N)
    {
        int count = 0;
        for (int i = 2; i <= N / 2; i++)
        {
            if (isPrime[i] && isPrime[N - i])
            {
                count++;
            }
        }
        return count;
    }
}
