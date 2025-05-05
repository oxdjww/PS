import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int current = 0;
        
        Queue<Integer> bridge = new LinkedList<>();
        for(int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }
        int index = 0;
        int count = 0;
        int time = 0;
        while(count < truck_weights.length) {
            time++;
            
            // 다리에서 하차
            int out = bridge.poll();
            // 다리 무게 감량
            current -= out;
            // 진짜 트럭이면 (0아님)
            if (out > 0) count++;
            
            if(index < truck_weights.length) {
                // 새로운 트럭을 다리에 올릴 수 있는지
                if (bridge.size() + 1 <= bridge_length && current + truck_weights[index] <= weight) {
                    current += truck_weights[index];
                    bridge.offer(truck_weights[index]);
                    index++;
                } else {
                    // 가짜 트럭
                    bridge.offer(0);
                }
            } 
        }
        return time;
    }
}