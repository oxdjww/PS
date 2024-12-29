import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        List<Integer> list = Arrays.stream(arr)
            .boxed()
            .collect(Collectors.toList());
        int firstStart = intervals[0][0];
        int firstEnd = intervals[0][1];
        int secondStart = intervals[1][0];
        int secondEnd = intervals[1][1];
        List<Integer> answer = new ArrayList<Integer>();
        answer.addAll(list.subList(firstStart, firstEnd+1));
        answer.addAll(list.subList(secondStart, secondEnd+1));
        return answer.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}