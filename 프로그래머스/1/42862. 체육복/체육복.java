import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] students = new int[n + 1];
        
        for (int r : reserve)
        {
            students[r]++;
        }
        
        for (int l : lost)
        {
            students[l]--;
        }
        
        for (int i = 1; i <= n; i++)
        {
            if (students[i] == -1)
            {
                if (i > 1 && students[i - 1] == 1)
                {
                    students[i] = 0;
                    students[i - 1] = 0;
                } else if (i < n && students[i + 1] == 1)
                {
                    students[i] = 0;
                    students[i + 1] = 0;
                }
            }
        }
        
        int count = 0;
        for (int i = 1; i <= n; i++)
        {
            if (students[i] >= 0)
            {
                count++;
            }
        }
        
        return count;
    }
}
