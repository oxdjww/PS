import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();
        int time = 0;
        int currentWeight = 0;
        int idx = 0;

        for (int i = 0; i < bridge_length; i++) {
            bridge.add(0);
        }

        while (idx < truck_weights.length || currentWeight > 0) {
            time++;

            // 다리에서 트럭 제거
            currentWeight -= bridge.poll();

            // 새로운 트럭을 다리에 올릴 수 있는지 확인
            if (idx < truck_weights.length && currentWeight + truck_weights[idx] <= weight) {
                bridge.add(truck_weights[idx]);
                currentWeight += truck_weights[idx];
                idx++;
            } else {
                // 무게를 초과하면 빈칸 추가
                bridge.add(0);
            }
        }
        return time;
    }
}
