import java.util.*;

class Solution {
    private static Queue<Integer> q1 = new LinkedList<>();
    private static Queue<Integer> q2 = new LinkedList<>();
    private static int target = 0;
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long queue1Total = 0;
        long queue2Total = 0;
        
        for(int i = 0 ; i < queue1.length ; i++)
        {
            int q1Value = queue1[i];
            int q2Value = queue2[i];
            target += q1Value + q2Value;
            q1.offer(q1Value);
            queue1Total += q1Value;
            q2.offer(q2Value);
            queue2Total += q2Value;
        }
        if(target % 2 == 1) return -1;
        target /= 2;
        
        int iter = queue1.length * 4;
        while(iter-- > 0)
        {
            if(q1.isEmpty() || q2.isEmpty())
            {
                return -1;
            }
            if(queue1Total < queue2Total)
            {
                int value = q2.poll();
                queue2Total -= value;
                q1.offer(value);
                queue1Total += value;
                answer++;
            }
            else if(queue1Total > queue2Total)
            {
                int value = q1.poll();
                queue1Total -= value;
                q2.offer(value);
                queue2Total += value;
                answer++;
            }
            else
            {
                return answer;
            }
        }
        return -1;
    }
}