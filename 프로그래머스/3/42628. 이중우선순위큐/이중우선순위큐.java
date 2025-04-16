import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        List<Integer> queue = new ArrayList<>();
        
        for(int i = 0; i < operations.length; i++) {
            String line = operations[i];
            String[] charArray = line.split(" ");
            String command = charArray[0];
            String arg = charArray[1];
            
            if(command.equals("I")) {
                queue.add(Integer.parseInt(arg));
                Collections.sort(queue);
            } else {
                if(queue.size() == 0)
                    continue;
                if(arg.equals("1")) {
                    queue.remove(queue.size()-1);
                } else {
                    queue.remove(0);
                }
            }
        }
        if(queue.size() == 0) {
            return new int[]{0, 0};
        } else {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < queue.size(); i++) {
                max = Math.max(max, queue.get(i));
                min = Math.min(min, queue.get(i));
            }
            return new int[]{max, min};
        }
    }
}