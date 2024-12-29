import java.util.*;
class Solution {
    public String solution(String n_str) {
        List<Character> list = new ArrayList<>();
        for(char index: n_str.toCharArray())
            list.add(index);
        StringBuilder sb= new StringBuilder();
        boolean flag = true;
        for(int i = 0 ; i <list.size() ; i++)
        {
            if(flag && list.get(i) == '0')
                continue;
            else {
                sb.append(list.get(i));
                flag = false;
            }
        }
        return sb.toString();
    }
}