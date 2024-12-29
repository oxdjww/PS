import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(int[] num_list) {
        OptionalInt first = IntStream.range(0, num_list.length)
            .filter(idx -> num_list[idx] < 0)
            .findFirst();
        return first.isPresent() ? first.getAsInt() : -1;
    }
}