import java.util.stream.*;
import java.util.*;
class Solution {
    public int[] solution(int[] num_list) {
        List<Integer> arr = Arrays.stream(num_list)
            .boxed()
            .collect(Collectors.toList());
        int last = arr.get(arr.size()-1);
        int lastBefore = arr.get(arr.size()-2);
        Integer add = last > lastBefore ? last - lastBefore : last * 2;
        arr.add(add);
        return arr.stream()
            .mapToInt(i -> i)
            .toArray();
    }
}