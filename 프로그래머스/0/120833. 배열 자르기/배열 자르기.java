import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int[] numbers, int num1, int num2) {
        return Arrays.stream(numbers)
            .boxed()
            .collect(Collectors.toList())
            .subList(num1, num2+1)
            .stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}