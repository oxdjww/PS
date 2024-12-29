import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(int[] num_list) {
        return IntStream.range(0, num_list.length)
            .filter(idx -> num_list[idx] < 0)
            .findFirst()
            .orElse(-1);
    }
}