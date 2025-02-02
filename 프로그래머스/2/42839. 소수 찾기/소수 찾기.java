import java.util.HashSet;
import java.util.Set;

class Solution {
    Set<Integer> set = new HashSet<>();

    public int solution(String numbers){
        boolean[] used = new boolean[numbers.length()];
        dfs("", numbers, used);

        int count = 0;
        for (int num : set) {
            if (isPrime(num)) {
                count++;
            }
        }

        return count;
    }

    private void dfs(String current, String numbers, boolean[] used) {
        if (!current.equals(""))
        {
            set.add(Integer.valueOf(current));
        }

        for (int i = 0; i < numbers.length(); i++)
        {
            if (!used[i])
            {
                used[i] = true;
                dfs(current + numbers.charAt(i), numbers, used);
                used[i] = false;
            }
        }
    }

    private boolean isPrime(int n)
    {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i * i <= n; i++)
        {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
