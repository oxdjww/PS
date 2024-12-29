import java.util.*;
import java.util.stream.*;
class Solution {
    public String[] solution(String[] str_list) {
        List<String> list = Arrays.stream(str_list)
            .collect(Collectors.toList());
        if(list.contains("l") == false && list.contains("r") == false)
            return new String[]{};
        for(int i = 0 ; i < list.size() ; i++)
        {
            if(list.get(i).equals("l"))
            {
                return list.subList(0, i).stream()
                    .toArray(String[]::new);
            }
            if(list.get(i).equals("r"))
            {
                return list.subList(i+1, list.size()).stream()
                    .toArray(String[]::new);
            }
        }
        return new String[]{};
    }
}