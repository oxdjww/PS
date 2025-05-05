import java.util.*;

class Solution {
    List<String> answer = null;
    boolean[] visited;

    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, (a, b) -> a[0].equals(b[0]) ? a[1].compareTo(b[1]) : a[0].compareTo(b[0]));
        visited = new boolean[tickets.length];

        List<String> route = new ArrayList<>();
        route.add("ICN");
        dfs("ICN", route, tickets, 0);

        return answer.toArray(new String[0]);
    }

    private void dfs(String curr, List<String> route, String[][] tickets, int usedCount) {
        if (usedCount == tickets.length) {
            if (answer == null) {
                answer = new ArrayList<>(route);
            }
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(curr)) {
                visited[i] = true;
                route.add(tickets[i][1]);

                dfs(tickets[i][1], route, tickets, usedCount + 1);

                // 백트래킹
                visited[i] = false;
                route.remove(route.size() - 1);
            }
        }
    }
}
