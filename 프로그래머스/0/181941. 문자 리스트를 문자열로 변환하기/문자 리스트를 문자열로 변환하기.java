import java.util.stream.*;

class Solution {
    public String solution(String[] arr) {
        return IntStream.range(0, arr.length)
            .mapToObj(idx -> arr[idx])
            .collect(Collectors.joining());
    }
}