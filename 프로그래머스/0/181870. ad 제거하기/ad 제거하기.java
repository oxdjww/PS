import java.util.*;
import java.util.stream.*;
class Solution {
    public String[] solution(String[] strArr) {
        List<String> list = Arrays.stream(strArr)
            .collect(Collectors.toList());
        Iterator<String> iter = list.iterator();
        while(iter.hasNext())
        {
            if(iter.next().contains("ad"))
                iter.remove();
        }
        return list.stream()
            .toArray(String[]::new);
    }
}