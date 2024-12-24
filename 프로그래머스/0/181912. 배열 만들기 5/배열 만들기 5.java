import java.util.*;
class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        List<Integer> list = new ArrayList<Integer>();
        int start = s;
        int end = s + l;
        for(int i = 0 ; i < intStrs.length ; i++)
        {
            int value = Integer.valueOf(intStrs[i].substring(start, end));
            if (value > k)
                list.add(value);
        }
        return list.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}