import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> days = new LinkedList<>();
        for(int i = 0 ; i < progresses.length ; i++)
        {
            days.add((100 - progresses[i]) % speeds[i] > 0 ? (100 - progresses[i]) / speeds[i] + 1 : (100 - progresses[i]) / speeds[i]);
        }
        int idx = 0;
        while(!days.isEmpty())
        {
            int current = days.poll();
            int count = 1;

            while (!days.isEmpty() && days.peek() <= current) {
                days.poll();
                count++;
            }

            answer.add(count);
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}