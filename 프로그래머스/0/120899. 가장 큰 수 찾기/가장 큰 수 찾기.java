import java.util.stream.*;
import java.util.*;
class Solution {
    public int[] solution(int[] array) {
        int max = Arrays.stream(array).max().getAsInt();
        return new int[]{max, Arrays.stream(array).boxed().collect(Collectors.toList()).indexOf(max)};
    }
}