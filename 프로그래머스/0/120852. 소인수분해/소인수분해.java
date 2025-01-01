import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int n) {
        boolean[] prime = genPrime(n);

        int primeCount = 0;
        for (boolean isPrime : prime) {
            if (isPrime) primeCount++;
        }

        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < prime.length; i++) {
            if (prime[i] && n % i == 0) {
                answer.add(i);
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    private boolean[] genPrime(int n)
    {
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        
        for(int i = 2 ; i <= n ; i++)
        {
            if(isPrime[i])
            {
                for(int j = i * 2 ; j <= n ; j+=i)
                {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }
}