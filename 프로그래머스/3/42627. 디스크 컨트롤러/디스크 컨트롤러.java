import java.util.*;

class Solution {
    private static final int 작업번호 = 0;
    private static final int 요청시간 = 1;
    private static final int 소요시간 = 2;
    
    PriorityQueue<int[]> pq = new PriorityQueue<>( new Comparator<int[]>() {
        @Override
        public int compare(int[] job1, int[] job2) {
            int job1Number = job1[0];
            int job2Number = job2[0];
            
            int job1RequestTime = job1[1];
            int job2RequestTime = job2[1];
            
            int job1TimeRequired = job1[2];
            int job2TimeRequired = job2[2];
            
            if (job1TimeRequired != job2TimeRequired) {
                return job1TimeRequired - job2TimeRequired;
            } else if (job1RequestTime != job2RequestTime) {
                return job1RequestTime - job2RequestTime;
            } else {
                return job1Number - job2Number;
            }
        }
    });
    
    public int solution(int[][] jobs) {
        int[][] realJobs = new int[jobs.length][3];
        
        for(int i = 0; i < jobs.length; i++) {
            realJobs[i][작업번호] = i;
            realJobs[i][요청시간] = jobs[i][0];
            realJobs[i][소요시간] = jobs[i][1];
        }
        
        // 요청 시간 기준 정렬
        Arrays.sort(realJobs, Comparator.comparingInt( job -> job[1]));
        
        int currentTime = 0, index = 0;
        List<Integer> answer = new ArrayList<>();
        
        while(answer.size() < jobs.length) {
            while(index < realJobs.length && realJobs[index][요청시간] <= currentTime) {
                pq.offer(realJobs[index]);
                index++;
            }
            
            if(pq.isEmpty()) {
                currentTime = realJobs[index][요청시간];
                continue;
            }
            
            int[] currentJob = pq.poll();
            int currentRequiredTime = currentJob[소요시간];
            answer.add(currentTime + currentRequiredTime - currentJob[요청시간]);
            currentTime += currentRequiredTime;
        }
        
        int sum = 0;
        for(Integer a: answer) {
            sum += a;
        }
        return sum / answer.size();
    }
}