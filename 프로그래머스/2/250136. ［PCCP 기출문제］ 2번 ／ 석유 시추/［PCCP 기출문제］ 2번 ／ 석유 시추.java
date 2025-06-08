import java.util.*;

public class Solution {
    private final int[] dx = {0, 1, 0, -1};
    private final int[] dy = {1, 0, -1, 0};

    private int n;
    private int m;
    private int[][] map;
    private int[][] compId;
    private List<Integer> compSize;

    public int solution(int[][] land) {
        this.map = land;
        this.n = land.length;
        this.m = land[0].length;

        compId = new int[n][m];
        compSize = new ArrayList<>();
        compSize.add(0);
        
        int id = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && compId[i][j] == 0) {
                    id++;
                    compSize.add(dfsLabel(i, j, id));
                }
            }
        }

        int answer = Integer.MIN_VALUE;
        for (int col = 0; col < m; col++) {
            boolean[] seen = new boolean[id + 1];
            int sum = 0;
            for (int row = 0; row < n; row++) {
                int cid = compId[row][col];
                if (cid > 0 && !seen[cid]) {
                    seen[cid] = true;
                    sum += compSize.get(cid);
                }
            }
            answer = Math.max(answer, sum);
        }

        return answer;
    }

    private int dfsLabel(int r, int c, int id) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{r, c});
        compId[r][c] = id;
        int size = 1;

        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int cr = current[0];
            int cc = current[1];

            for (int k = 0; k < 4; k++) {
                int nr = cr + dx[k];
                int nc = cc + dy[k];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m
                        && map[nr][nc] == 1 && compId[nr][nc] == 0) {
                    compId[nr][nc] = id;
                    stack.push(new int[]{nr, nc});
                    size++;
                }
            }
        }
        return size;
    }
}
