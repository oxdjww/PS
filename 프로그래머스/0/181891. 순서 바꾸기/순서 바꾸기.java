import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int[] num_list, int n) {
        List<Integer> list = Arrays.stream(num_list)
            .boxed()
            .collect(Collectors.toList());
        List<Integer> first = list.subList(0, n);
        List<Integer> second = list.subList(n, list.size());
        List<Integer> answer = new ArrayList<>();
        answer.addAll(second);
        answer.addAll(first);
        return answer.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}