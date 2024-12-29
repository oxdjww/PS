import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int[] num_list) {
        List<Integer> list = Arrays.stream(num_list)
            .boxed()
            .collect(Collectors.toList());
        Collections.sort(list);
        return list.subList(5, list.size()).stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}