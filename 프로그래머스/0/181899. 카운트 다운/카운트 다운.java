import java.util.stream.*;
class Solution {
    public int[] solution(int start_num, int end_num) {
        return IntStream.rangeClosed(end_num, start_num)
            .map(n -> start_num - (n - end_num))
            .toArray();
    }
}