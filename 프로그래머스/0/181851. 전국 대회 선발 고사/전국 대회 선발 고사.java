import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        List<ArrayList<Integer>> list = IntStream.range(0, rank.length)
            .filter(idx -> attendance[idx])
            .mapToObj(idx -> new ArrayList<>(Arrays.asList(idx, rank[idx])))
            .collect(Collectors.toList());
        list.sort(Comparator.comparingInt(idx -> idx.get(1)));
        return 10000 * list.get(0).get(0) + 100 * list.get(1).get(0) + list.get(2).get(0);
    }
}