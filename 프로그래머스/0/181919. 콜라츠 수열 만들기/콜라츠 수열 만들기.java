import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int n) {
        List<Integer> list = new ArrayList<>();
        do{
            list.add(n);
            n = n%2 == 0 ? n /= 2 : n *3 + 1;
        }while(n != 1);
        list.add(1);
        return list.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}