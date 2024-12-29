import java.util.*;
class Solution {
    public int solution(String[] order) {
        HashMap<String,String> hm = new HashMap<>();
        hm.put("anything", "iceamericano");
        
        hm.put("iceamericano", "iceamericano");
        hm.put("americanoice", "iceamericano");
        hm.put("americano", "iceamericano");
        
        hm.put("hotamericano", "hotamericano");
        hm.put("americanohot", "hotamericano");
        
        hm.put("icecafelatte", "icecafelatte");
        hm.put("cafelatteice", "cafelatteice");
        hm.put("cafelatte", "icecafelatte");
        
        hm.put("hotcafelatte", "hotcafelatte");
        hm.put("cafelattehot", "cafelattehot");
        int total = 0;
        for(int i = 0 ; i < order.length ; i++)
        {
            String menu = hm.get(order[i]);
            if(menu.contains("americano"))
                total += 4500;
            if(menu.contains("cafelatte"))
                total += 5000;
        }
        return total;
    }
}