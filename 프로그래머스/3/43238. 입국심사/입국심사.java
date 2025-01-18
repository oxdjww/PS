class Solution {
    public long solution(int n, int[] times) {
        long start = 1;
        long end = 0;
        for (int time : times) {
            end = Math.max(end, (long) time);
        }
        end *= n;
        
        long answer = end;
        
        while(start <= end)
        {
            long mid = (start + end) / 2;
            long pass = 0;
            
            for(int time : times)
            {
                pass += mid / time;
                
                if(pass >= n) break;
            }
            
            if(pass >= n)
            {
                answer = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return answer;
    }
}