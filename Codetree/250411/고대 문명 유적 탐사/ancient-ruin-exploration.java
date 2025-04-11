import java.util.*;
import java.io.*;

public class Main {
    
    private static int K;                       // 턴 수
    private static int M;                       // 벽면 숫자 개수 (spare 큐 크기)
    private static int[][] board = new int[5][5]; // 5×5 보드
    private static Queue<Integer> spare = new LinkedList<>();  // spare 큐

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
    
        K = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        // 보드 입력
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    
        // spare 큐 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            spare.offer(Integer.parseInt(st.nextToken()));
        }
    
        ArrayList<Integer> turnResults = new ArrayList<>();
        for (int turn = 0; turn < K; turn++) {
            int turnScore = execute();
            // 만약 어떤 턴에서 한번도 유물을 획득하지 못하면 그 즉시 탐사를 종료함.
            if (turnScore == 0) break;
            turnResults.add(turnScore);
        }
        
        // 각 턴 점수를 공백으로 구분하여 출력
        for (int i = 0; i < turnResults.size(); i++) {
            System.out.print(turnResults.get(i));
            if (i < turnResults.size() - 1)
                System.out.print(" ");
        }
    }
    
    // 한 턴을 실행: 최적 회전 방법으로 3×3 영역 회전 후, 연쇄적으로 유물 제거(및 채우기) 수행
    private static int execute() {
        int totalScore = 0;
        int[] optimum = findOptimum();
        int centerRow = optimum[0];
        int centerCol = optimum[1];
        int rotateCount = optimum[2];
        
        // 실제 board에서 해당 3×3 영역을 rotateCount번 회전 (각 회전은 90도씩)
        for (int i = 0; i < rotateCount; i++) {
            rotate90(board, centerRow, centerCol);
        }
        
        // 연쇄 제거 및 채우기 (유물이 더 이상 생성되지 않을 때까지)
        int score;
        do {
            score = removeRelics(board);
            totalScore += score;
            if(score > 0) {
                fillRelics(board, spare);
            }
        } while(score != 0);
        
        return totalScore;
    }
    
    // 가능한 모든 회전(3×3 부분의 중심 (1,1)~(3,3), 회전각 90°, 180°, 270°)에 대해
    // "연쇄 제거" 후 총 유물 획득 점수를 시뮬레이션하여, 
    // (1) 전체 획득 점수가 최대, (2) 회전 각도가 작고, (3) 중심 좌표의 열, 그리고 행이 작은 순으로 선택
    private static int[] findOptimum() {
        int bestRow = -1, bestCol = -1, bestRotate = -1;
        int maxScore = -1;
        
        // 가능한 회전 중심: 행,열 모두 1~3 (1-based)
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                // 회전 각도: k번의 90도 (k=1,2,3)
                for (int k = 1; k <= 3; k++) {
                    int[][] copyBoard = createCopyOf2DArray(board);
                    Queue<Integer> copySpare = new LinkedList<>(spare);
                    // k번 회전 적용
                    for (int r = 0; r < k; r++) {
                        rotate90(copyBoard, i, j);
                    }
                    // 연쇄 제거를 시뮬레이션하여 총 점수를 산출
                    int score = simulateChain(copyBoard, copySpare);
                    
                    // 조건: (1) score 최대, (2) k 최소, (3) 중심 좌표의 열, (4) 중심 좌표의 행이 최소
                    if (score > maxScore ||
                       (score == maxScore && k < bestRotate) ||
                       (score == maxScore && k == bestRotate && (j < bestCol || (j == bestCol && i < bestRow)))) {
                        bestRow = i;
                        bestCol = j;
                        bestRotate = k;
                        maxScore = score;
                    }
                }
            }
        }
        return new int[]{bestRow, bestCol, bestRotate};
    }
    
    // simulateChain: 주어진 board와 spare 복사본을 가지고 연쇄적으로 유물 제거 및 채우기를 수행한 후
    // 누적 점수를 반환 (board와 spare의 실제 상태는 변경되지 않음)
    private static int simulateChain(int[][] boardCopy, Queue<Integer> spareCopy) {
        int totalScore = 0;
        while (true) {
            int score = removeRelics(boardCopy);
            if(score == 0) break;
            totalScore += score;
            fillRelics(boardCopy, spareCopy);
        }
        return totalScore;
    }
    
    // 3×3 격자 (중심 좌표 (row, col))를 시계 방향으로 90도 회전
    private static void rotate90(int[][] matrix, int row, int col) {
        int[][] temp = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                temp[i][j] = matrix[row + i - 1][col + j - 1];
            }
        }
        
        matrix[row - 1][col - 1] = temp[2][0];
        matrix[row - 1][col]     = temp[1][0];
        matrix[row - 1][col + 1] = temp[0][0];
        
        matrix[row][col - 1]     = temp[2][1];
        matrix[row][col]         = temp[1][1];
        matrix[row][col + 1]     = temp[0][1];
        
        matrix[row + 1][col - 1] = temp[2][2];
        matrix[row + 1][col]     = temp[1][2];
        matrix[row + 1][col + 1] = temp[0][2];
    }
    
    // board의 깊은 복사본 반환
    private static int[][] createCopyOf2DArray(int[][] array) {
        int[][] copy = new int[5][5];
        for (int i = 0; i < 5; i++) {
            copy[i] = Arrays.copyOf(array[i], 5);
        }
        return copy;
    }
    
    // board의 (row, col)가 유효한지 검사 (0~4)
    private static boolean isValidPoint(int row, int col) {
        return row >= 0 && row < 5 && col >= 0 && col < 5;
    }
    
    // 유물 제거: 상하좌우로 연결된 같은 숫자 그룹이 3개 이상이면 제거하고, 해당 그룹의 크기만큼 점수를 반환.
    // 제거된 자리는 0으로 채움.
    private static int removeRelics(int[][] matrix) {
        int score = 0;
        boolean[][] visited = new boolean[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (!visited[i][j] && matrix[i][j] != 0) {
                    int value = matrix[i][j];
                    Queue<int[]> queue = new LinkedList<>();
                    List<int[]> group = new ArrayList<>();
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                    while (!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        group.add(cur);
                        int[] dr = {0, 1, 0, -1};
                        int[] dc = {1, 0, -1, 0};
                        for (int d = 0; d < 4; d++) {
                            int nr = cur[0] + dr[d], nc = cur[1] + dc[d];
                            if (isValidPoint(nr, nc) && !visited[nr][nc] && matrix[nr][nc] == value) {
                                visited[nr][nc] = true;
                                queue.offer(new int[]{nr, nc});
                            }
                        }
                    }
                    if (group.size() >= 3) {
                        score += group.size();
                        for (int[] cell : group) {
                            matrix[cell[0]][cell[1]] = 0;
                        }
                    }
                }
            }
        }
        return score;
    }
    
    // 중력 효과 및 빈 칸 채우기:
    // 각 열마다 아래쪽(행 번호 큰 쪽)으로 non-zero 값들을 모으고,
    // 남은 빈 칸에는 spare 큐에서 순서대로 숫자를 꺼내 채움.
    // 채우는 순서는 "열 번호 오름차순, 같은 열이면 행 번호 내림차순"임.
    private static void fillRelics(int[][] matrix, Queue<Integer> spareQueue) {
        for (int col = 0; col < 5; col++) {
            int pointer = 4;
            // non-zero 값들을 아래쪽부터 채움
            for (int row = 4; row >= 0; row--) {
                if (matrix[row][col] != 0) {
                    matrix[pointer][col] = matrix[row][col];
                    pointer--;
                }
            }
            // 남은 빈 칸 (pointer ~ 0)에 대해 spare 큐의 숫자로 채움
            while (pointer >= 0) {
                matrix[pointer][col] = spareQueue.poll();
                pointer--;
            }
        }
    }
}
    