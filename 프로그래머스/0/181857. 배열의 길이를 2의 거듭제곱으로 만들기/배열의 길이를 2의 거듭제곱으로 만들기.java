import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = Arrays.stream(arr)
            .boxed()
            .collect(Collectors.toList());
        while(!isPowerOfTwo(list.size())){
            list.add(0);
        }
        return list.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
    private static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}