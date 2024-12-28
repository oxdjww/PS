import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] arr, int[] query) {
        List<Integer> list = Arrays.stream(arr)
            .boxed()
            .collect(Collectors.toList());

        for (int i = 0; i < query.length; i++) {
            int slice = query[i];
            if (i % 2 == 0) {
                list = list.subList(0, slice + 1);
            } else {
                list = list.subList(slice, list.size());
            }
        }

        return list.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}
