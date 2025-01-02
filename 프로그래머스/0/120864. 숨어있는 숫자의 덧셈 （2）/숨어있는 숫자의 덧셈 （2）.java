import java.util.*;
class Solution {
    public int solution(String my_string) {
        my_string = my_string.replaceAll("[^0-9]", "-");
        String[] arr = my_string.split("[-]+");
        return Arrays.stream(arr)
            .filter(str -> !str.isEmpty())
            .mapToInt(Integer::parseInt)
            .sum();
    }
}