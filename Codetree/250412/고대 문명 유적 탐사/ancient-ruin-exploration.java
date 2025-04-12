import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static final int N_large = 5; // 고대 문명 전체 격자 크기입니다.
    static final int N_small = 3; // 회전시킬 격자의 크기입니다.

    // 고대 문명 격자를 정의합니다.
    static class Board {
        int[][] a = new int[N_large][N_large];

        // 생성자: 격자를 모두 0으로 초기화합니다.
        public Board() {
            for (int i = 0; i < N_large; i++) {
                for (int j = 0; j < N_large; j++) {
                    a[i][j] = 0;
                }
            }
        }

        // 주어진 y, x가 고대 문명 격자의 범위 안에 있는지 확인합니다.
        private boolean inRange(int y, int x) {
            return 0 <= y && y < N_large && 0 <= x && x < N_large;
        }

        // 현재 격자에서 sy, sx를 좌측상단으로 하여 시계방향 90도 회전을 cnt번 시행한 결과를 반환합니다.
        public Board rotate(int sy, int sx, int cnt) {
            Board result = new Board();
            for (int i = 0; i < N_large; i++) {
                for (int j = 0; j < N_large; j++) {
                    result.a[i][j] = this.a[i][j];
                }
            }
            for (int k = 0; k < cnt; k++) {
                // sy, sx를 좌측상단으로 하여 3×3 격자를 시계방향 90도 회전합니다.
                int tmp = result.a[sy + 0][sx + 2];
                result.a[sy + 0][sx + 2] = result.a[sy + 0][sx + 0];
                result.a[sy + 0][sx + 0] = result.a[sy + 2][sx + 0];
                result.a[sy + 2][sx + 0] = result.a[sy + 2][sx + 2];
                result.a[sy + 2][sx + 2] = tmp;
                tmp = result.a[sy + 1][sx + 2];
                result.a[sy + 1][sx + 2] = result.a[sy + 0][sx + 1];
                result.a[sy + 0][sx + 1] = result.a[sy + 1][sx + 0];
                result.a[sy + 1][sx + 0] = result.a[sy + 2][sx + 1];
                result.a[sy + 2][sx + 1] = tmp;
            }
            return result;
        }

        // 현재 격자에서 유물을 획득합니다.
        // 단, 새 유물 조각 채우기는 여기서 고려하지 않습니다.
        // 수정된 부분: 각 연결 그룹(유물 조각 그룹)을 찾은 후 바로 삭제하지 않고,
        // 삭제 대상 좌표들을 모두 모아서 동시에 0으로 변경합니다.
        public int calScore() {
            int score = 0;
            boolean[][] visit = new boolean[N_large][N_large];
            int[] dy = {0, 1, 0, -1}, dx = {1, 0, -1, 0};

            // 삭제될 좌표들을 모아둘 리스트 (동시 삭제용)
            List<int[]> toRemove = new ArrayList<>();

            for (int i = 0; i < N_large; i++) {
                for (int j = 0; j < N_large; j++) {
                    // 빈 칸(0)은 유물 조각이 아니므로, BFS 대상에서 제외합니다.
                    if (!visit[i][j] && a[i][j] != 0) {
                        Queue<int[]> q = new LinkedList<>();
                        // trace 큐: BFS 과정에서 해당 그룹에 속한 좌표들을 저장합니다.
                        Queue<int[]> trace = new LinkedList<>();
                        q.offer(new int[]{i, j});
                        trace.offer(new int[]{i, j});
                        visit[i][j] = true;
                        while (!q.isEmpty()) {
                            int[] cur = q.poll();
                            for (int k = 0; k < 4; k++) {
                                int ny = cur[0] + dy[k], nx = cur[1] + dx[k];
                                if (inRange(ny, nx) && !visit[ny][nx] && a[ny][nx] == a[cur[0]][cur[1]]) {
                                    q.offer(new int[]{ny, nx});
                                    trace.offer(new int[]{ny, nx});
                                    visit[ny][nx] = true;
                                }
                            }
                        }
                        // 만약 이 그룹의 크기가 3 이상이면 (유물이 되는 경우)
                        if (trace.size() >= 3) {
                            score += trace.size();
                            // 현재 그룹의 모든 좌표를 삭제 대상 리스트에 추가
                            while (!trace.isEmpty()) {
                                toRemove.add(trace.poll());
                            }
                        }
                    }
                }
            }
            // 동시에 삭제: 삭제 대상 리스트에 있는 모든 좌표를 0으로 바꿉니다.
            for (int[] cell : toRemove) {
                a[cell[0]][cell[1]] = 0;
            }
            return score;
        }

        // 유물 획득 과정에서, 비어있는 칸(0)을 spare 큐의 숫자로 채웁니다.
        // 채우는 순서는 열 번호가 작은 순, 같은 열이면 행 번호가 큰(아래쪽) 순입니다.
        public void fill(Queue<Integer> que) {
            for (int j = 0; j < N_large; j++) {
                for (int i = N_large - 1; i >= 0; i--) {
                    if (a[i][j] == 0 && !que.isEmpty()) {
                        a[i][j] = que.poll();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();  // 탐사 횟수
        int M = sc.nextInt();  // spare 큐에 들어있는 숫자 개수
        Queue<Integer> q = new LinkedList<>();
        Board board = new Board();

        // 초기 보드 상태 입력
        for (int i = 0; i < N_large; i++) {
            for (int j = 0; j < N_large; j++) {
                board.a[i][j] = sc.nextInt();
            }
        }
        // spare 큐 입력
        for (int i = 0; i < M; i++) {
            q.offer(sc.nextInt());
        }

        // 최대 K번의 탐사 과정을 진행합니다.
        while (K-- > 0) {
            int maxScore = 0;
            Board maxScoreBoard = null;
            // 회전 목표에 맞는 결과를 찾습니다.
            // (1) 유물 1차 획득 점수를 최대화,
            // (2) 회전한 각도가 가장 작은 방법,
            // (3) 회전 중심의 열이 가장 작고, 같다면 행이 가장 작은 영역을 선택합니다.
            for (int cnt = 1; cnt <= 3; cnt++) {
                for (int sx = 0; sx <= N_large - N_small; sx++) {
                    for (int sy = 0; sy <= N_large - N_small; sy++) {
                        Board rotated = board.rotate(sy, sx, cnt);
                        int score = rotated.calScore();
                        if (maxScore < score) {
                            maxScore = score;
                            maxScoreBoard = rotated;
                        }
                    }
                }
            }
            // 회전을 통해 유물을 하나도 획득하지 못하면 탐사를 종료합니다.
            if (maxScoreBoard == null) {
                break;
            }
            board = maxScoreBoard;
            // 연쇄 제거: 더 이상 추가 유물을 획득할 수 없을 때까지,
            // 새 조각을 채우고(calScore 호출) 점수를 누적합니다.
            while (true) {
                board.fill(q);
                int newScore = board.calScore();
                if (newScore == 0) break;
                maxScore += newScore;
            }

            System.out.print(maxScore + " ");
        }
    }
}
