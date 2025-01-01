import java.util.*;
class Solution {
    public int solution(int n) {
        return n - countPrime(n) - 1;
    }
    private int countPrime(int n) {
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);
        int count = 0;
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i=2; i<=n; i++) {
            if (isPrime[i]) {
                count++;
                for (int j = i*2; j<=n; j = j+i) {
                    isPrime[j] = false;
                }
            }
        }
        return count;
    }
}