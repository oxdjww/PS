class Solution {

    private static boolean[][] graph;
    private static int answer;

    public int solution(int n, int[][] results) {
        graph = new boolean[n + 1][n + 1];
        answer = 0;

        for (int[] result : results) {
            int winner = result[0];
            int loser = result[1];
            graph[winner][loser] = true;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (graph[i][k] && graph[k][j]) {
                        graph[i][j] = true;
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            int win = checkWin(i);
            int lose = checkLose(i);

            if (win + lose == n - 1) answer++;
        }

        return answer;
    }

    private static int checkWin(int player) {
        int count = 0;
        for (int i = 1; i < graph.length; i++) {
            if (graph[player][i]) count++;
        }
        return count;
    }

    private static int checkLose(int player) {
        int count = 0;
        for (int i = 1; i < graph.length; i++) {
            if (graph[i][player]) count++;
        }
        return count;
    }
}
