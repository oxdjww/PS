import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        List<Integer> list = new ArrayList<>();
        Arrays.stream(array).forEach(list::add);
        
        for(int i = 0 ; i < commands.length ; i++)
        {
            int start = commands[i][0];
            int end = commands[i][1];
            int target = commands[i][2];
            List<Integer> sub = new ArrayList<>(list.subList(start-1, end));
            Collections.sort(sub);
            answer[i] = sub.get(target-1);
        }
        return answer;
    }
}