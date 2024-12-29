import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int[] num_list) {
        List<Integer> list = Arrays.stream(num_list)
            .boxed()
            .collect(Collectors.toList());
        Collections.sort(list);
        return IntStream.range(0, 5)
            .map(idx -> Integer.valueOf(list.get(idx)))
            .toArray();
    }
}