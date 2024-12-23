import java.util.*;
class Solution {
    public int solution(int a, int b, int c, int d) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        List<Integer> list = List.of(a,b,c,d);
        for(Integer idx: list)
        {
            hm.put(idx, hm.getOrDefault(idx, 0) + 1);
        }
        int numbers = hm.size();
        switch(numbers){
            case 1:
                return 1111 * list.get(0);
            case 2:
                if(hm.containsValue(2))
                {
                    int p = Collections.max(list);
                    int q = Collections.min(list);
                    return (p + q) * Math.abs(p - q);
                } else{
                    int p = 0;
                    int q = 0;
                    for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
                        if (entry.getValue() == 3) p = entry.getKey();
                        if (entry.getValue() == 1) q = entry.getKey();
                    }
                    return (int) Math.pow(10 * p + q, 2);
                }
            case 3:
                int p = 0;
                int q = 0;
                int r = 0;
                for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
                    if (entry.getValue() == 2) p = entry.getKey();
                    else if (q == 0) q = entry.getKey();
                    else r = entry.getKey();
                    }
                return q * r;
            case 4:
                return Collections.min(list);
            default:
                return 0;
        }
    }
}