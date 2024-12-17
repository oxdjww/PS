import java.util.stream.*;
class Solution {
    public int solution(int[] num_list) {
        int odd_sum = 0;
        int even_sum = 0;
        odd_sum = IntStream.range(0, num_list.length)
            .filter(idx -> ((idx+1) % 2) != 0)
            .map(idx -> num_list[idx])
            .sum();
        even_sum = IntStream.range(0, num_list.length)
            .filter(idx -> ((idx+1) % 2) == 0)
            .map(idx -> num_list[idx])
            .sum();
        return odd_sum >= even_sum ? odd_sum : even_sum;
    }
}