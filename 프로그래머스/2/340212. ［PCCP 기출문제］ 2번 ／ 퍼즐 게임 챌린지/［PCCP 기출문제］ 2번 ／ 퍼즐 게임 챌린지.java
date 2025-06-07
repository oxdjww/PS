import java.util.*;

class Solution {
    private static int[] diffs;
    private static int[] times;
    
    public int solution(int[] d, int[] t, long limit) {
        diffs = d;
        times = t;
        int maxDiff = Arrays.stream(d).max().getAsInt();

        int answer = 0;
        int start = 1;
        int end = maxDiff;
        
        while(start <= end){
            int mid = (start + end) / 2;
            long timeCost = solve(mid);
            
            if(timeCost <= limit) {
                answer = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        return answer;
    }
    
    private static long solve(int level) {
        long time = 0L;
        int time_prev = 0;
        
        for(int i = 0; i < diffs.length; i++) {
            int diff = diffs[i];
            int time_cur = times[i];
            
            if(diff <= level) {
                time += time_cur;
            } else {
                time += (time_cur + time_prev) * (long)(diff - level);
                time += time_cur;
            }
            
            time_prev = time_cur;
        }
        
        return time;
    }
}