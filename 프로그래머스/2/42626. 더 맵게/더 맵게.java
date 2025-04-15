import java.util.*;

class Solution {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    public int solution(int[] scoville, int K) {
        int count = 0;
        int answer = 0;
        for(int i = 0; i < scoville.length; i++) {
            int current = scoville[i];
            if(current >= K) {
                count++;
            }
            pq.offer(current);
        }
        // System.out.println("COUNT: " + count);
        
        while(!pq.isEmpty() && pq.size() > 1 && pq.peek() < K) {
            answer++;
            int a = pq.poll();
            int b = pq.poll();
            
            // System.out.println(a + " + " + b);
            
            int newMenu = a + b * 2;
            if(newMenu > K) {
                pq.offer(newMenu);
                // System.out.println("COUNT: " + count + ", PQ SIZE: " + pq.size());
            }
            else {
                pq.offer(newMenu);
            }
        }
        return pq.peek() < K ? -1 : answer;
    }
}