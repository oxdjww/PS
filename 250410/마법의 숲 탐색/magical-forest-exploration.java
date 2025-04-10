import java.util.*;
import java.io.*;

public class Main {
    private static int R;
    private static int C;
    private static int K;
    private static Golem[] golemStatus;
    private static int[][] board;
    private static boolean[][] visited;
    private static int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 초기 위치 고려 상위 3행 더
        board = new int[R+3][C];
        visited = new boolean[R+3][C];
        golemStatus = new Golem[K+1];

        int answer = 0;

        for(int golemNumber = 1; golemNumber <= K; golemNumber++) {
            st = new StringTokenizer(br.readLine());
            int initColumn = Integer.parseInt(st.nextToken());
            int wayOut = Integer.parseInt(st.nextToken());

            setGolemOnBoard(golemNumber, initColumn - 1);
            golemStatus[golemNumber] = new Golem(1, initColumn - 1, wayOut);

            // print();
            answer += execute(golemNumber);            
            // print();
        }

        System.out.println(answer);
    }

    private static int execute(int golemNumber) {
        while(true) {
            if(canMoveSouth(golemNumber)) {
                moveSouth(golemNumber);
                continue;
            } else if(canMoveWest(golemNumber)) {
                moveWest(golemNumber);
                continue;
            } else if(canMoveEast(golemNumber)) {
                moveEast(golemNumber);
                continue;
            }
            break;
        }

        // print();

        if(!checkGolemOutOfBoard(golemNumber)) {
            // 골렘이 숲 밖이면 점수합산 X
            clearBoard();
            return 0;
        }

        int result = moveJungryoungToBottom(golemNumber);
        return result;
    }

    private static void clearBoard() {
        for(int i = 0; i < board.length; i++) {
            Arrays.fill(board[i], 0);
        }
    }

    private static boolean checkGolemOutOfBoard(int golemNumber) {
        int centerRow = golemStatus[golemNumber].row;
        int centerColumn = golemStatus[golemNumber].column;
        // System.out.println(golemNumber + "번 골렘의 중앙값: " + centerRow + ", "  +centerColumn);

        for(int i = 0; i < directions.length; i++) {
            int nr = centerRow + directions[i][0];
            int nc = centerColumn + directions[i][1];
            if(!isValidPoint(nr, nc)) {
                // System.out.println("GOLEM OUT: " + nr + ", " + nc);
                return false;
            }
        }
        return true;
    }

    private static boolean isValidPoint(int row, int column) {
        return row >= 3 && row < R + 3 && column >= 0 && column < C && board[row][column] != 0;
    }

    private static int moveJungryoungToBottom(int golemNumber) {
        visited = new boolean[R+3][C];

        // System.out.println("MOVE JUNGRYUNG");
        int centerRow = golemStatus[golemNumber].row;
        int centerColumn = golemStatus[golemNumber].column;

        Queue<int[]> queue = new LinkedList<>();
        // 시작
        queue.offer(new int[]{centerRow, centerColumn});

        // System.out.println(golemNumber + "번 골렘 출구: " + (golemStatus[golemNumber].row + directions[golemStatus[golemNumber].wayOut][0]) + ", " + (
        // golemStatus[golemNumber].column + directions[golemStatus[golemNumber].wayOut][1]));

        int maxRow = 0;
        while(!queue.isEmpty()) {
            // 뽑고
            int[] current = queue.poll();
            // 방문 처리
            visited[current[0]][current[1]] = true;
            // System.out.print("[" + current[0] + ", " + current[1] + "] ");
            // 최대 행값 갱신
            maxRow = Math.max(maxRow, current[0] - 2);
            
            // 현재 칸의 골렘 넘버를 찾는다
            int currentGolemNumber = board[current[0]][current[1]];

            // 동서남북 점검
            for(int i = 0; i < directions.length; i++) {
                int nr = current[0] + directions[i][0];
                int nc = current[1] + directions[i][1];

                int nWayOut = golemStatus[currentGolemNumber].wayOut;
                // System.out.println("CURRENT: " + current[0] + ", " + current[1]);
                if(isValidPoint(nr, nc) && !visited[nr][nc]) { // 다음칸이 0이 아니고 보드를 벗어나지 않고며, 방문하지 않은 경우만 
                    if(board[nr][nc] == currentGolemNumber) { // 같은 골렘 내부
                        queue.offer(new int[]{nr, nc});
                        visited[nr][nc] = true;
                    } else if(
                        current[0] == golemStatus[currentGolemNumber].row + directions[nWayOut][0] &&
                        current[1] == golemStatus[currentGolemNumber].column + directions[nWayOut][1]
                    ) { // 다음칸이 같은 골렘 내부가 아니면 현재 위치가 출구일 경우에만 
                        queue.offer(new int[]{nr, nc});
                        visited[nr][nc] = true;
                    }
                    // 그런것도 아니라면 추가 X
                }
            }
        }
        // System.out.println();
        // System.out.println("적립: " + maxRow);
        return maxRow;
    }

    private static void moveSouth(int golemNumber) {
        // System.out.println("MOVE SOUTH");
        int centerRow = golemStatus[golemNumber].row;
        int centerColumn = golemStatus[golemNumber].column;

        // 기존 골렘 위치 삭제
        board[centerRow][centerColumn] = 0;
        for(int i = 0; i < directions.length; i++) {
            board[centerRow + directions[i][0]][centerColumn + directions[i][1]] = 0;
        }

        // 새 위치
        board[centerRow + 1][centerColumn] = golemNumber;
        for(int i = 0; i < directions.length; i++) {
            board[centerRow + 1 + directions[i][0]][centerColumn + directions[i][1]] = golemNumber;
        }

        // 새 위치 반영
        golemStatus[golemNumber].row = centerRow + 1;
    }

    private static void moveWest(int golemNumber) {
        // System.out.println("MOVE WEST");
        int centerRow = golemStatus[golemNumber].row;
        int centerColumn = golemStatus[golemNumber].column;

        // 기존 골렘 위치 삭제
        board[centerRow][centerColumn] = 0;
        for(int i = 0; i < directions.length; i++) {
            board[centerRow + directions[i][0]][centerColumn + directions[i][1]] = 0;
        }

        // 새 위치
        board[centerRow + 1][centerColumn - 1] = golemNumber;
        for(int i = 0; i < directions.length; i++) {
            board[centerRow+ 1 + directions[i][0]][centerColumn - 1 + directions[i][1]] = golemNumber;
        }
        
        // 새 위치 반영
        golemStatus[golemNumber].row = centerRow + 1;
        golemStatus[golemNumber].column = centerColumn - 1;

        // 출구 반시계방향으로 이동
        int wayOutResult = golemStatus[golemNumber].wayOut - 1;
        golemStatus[golemNumber].wayOut = wayOutResult < 0 ? 3 : wayOutResult;
    }

    private static void moveEast(int golemNumber) {
        // System.out.println("MOVE EAST");
        int centerRow = golemStatus[golemNumber].row;
        int centerColumn = golemStatus[golemNumber].column;

        // 기존 골렘 위치 삭제
        board[centerRow][centerColumn] = 0;
        for(int i = 0; i < directions.length; i++) {
            // System.out.println((centerRow + directions[i][0]) + ", " + (centerColumn + directions[i][1]));

            board[centerRow + directions[i][0]][centerColumn + directions[i][1]] = 0;
        }

        // 새 위치
        board[centerRow + 1][centerColumn + 1] = golemNumber;
        for(int i = 0; i < directions.length; i++) {
            // System.out.println((centerRow + 1 + directions[i][0]) + ", " + (centerColumn + 1 + directions[i][1]));

            board[centerRow + 1 + directions[i][0]][centerColumn + 1 + directions[i][1]] = golemNumber;
        }

        // 새 위치 반영
        golemStatus[golemNumber].row = centerRow + 1;
        golemStatus[golemNumber].column = centerColumn + 1;

        // 출구 시계방향으로 이동
        int wayOutResult = golemStatus[golemNumber].wayOut + 1;
        golemStatus[golemNumber].wayOut = wayOutResult > 3 ? 0 : wayOutResult;
    }

    private static boolean canMoveSouth(int golemNumber) {
        int centerRow = golemStatus[golemNumber].row;
        int centerColumn = golemStatus[golemNumber].column;
        
        // 골렘의 중앙(정령)이 보드 R - 2행에 왔으면
        if(centerRow >= R + 1) return false;

        if(board[centerRow + 1][centerColumn - 1] != 0) return false;
        if(board[centerRow + 2][centerColumn] != 0) return false;
        if(board[centerRow + 1][centerColumn + 1] != 0) return false;

        return true;
    }

    private static boolean canMoveWest(int golemNumber) {
        int centerRow = golemStatus[golemNumber].row;
        int centerColumn = golemStatus[golemNumber].column;
        
        // 골렘의 중앙(정령)이 보드 R - 2행에 왔으면
        if(centerRow >= R + 1) return false;
        // 골렘의 중앙(정령)이 보드 1열에 왔으면
        if(centerColumn <= 1) return false;

        // 남쪽 점검
        if(board[centerRow - 1][centerColumn - 1] != 0) return false;
        if(board[centerRow][centerColumn - 2] != 0) return false;
        if(board[centerRow + 1][centerColumn - 1] != 0) return false;

        // 서쪽 점검
        if(board[centerRow + 1][centerColumn - 2] != 0) return false;
        if(board[centerRow + 2][centerColumn - 1] != 0) return false;

        return true;
    }

    private static boolean canMoveEast(int golemNumber) {
        int centerRow = golemStatus[golemNumber].row;
        int centerColumn = golemStatus[golemNumber].column;
        
        // 골렘의 중앙(정령)이 보드 R - 2행에 왔으면
        if(centerRow >= R + 1) return false;
        // 골렘의 중앙(정령)이 보드 C - 2행에 왔으면
        if(centerColumn >= C - 2) return false;

        // 남쪽 점검
        if(board[centerRow - 1][centerColumn + 1] != 0) return false;
        if(board[centerRow][centerColumn + 2] != 0) return false;
        if(board[centerRow + 1][centerColumn + 1] != 0) return false;

        // 동쪽 점검
        if(board[centerRow + 2][centerColumn + 1] != 0) return false;
        if(board[centerRow + 1][centerColumn + 2] != 0) return false;

        return true;
    }

    private static void setGolemOnBoard(int golemNumber, int initColumn) {
        board[1][initColumn] = golemNumber;
        for(int i = 0; i < directions.length; i++) {
            board[1 + directions[i][0]][initColumn + directions[i][1]] = golemNumber;
        }
    }

    private static void print() {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

class Golem {
    int row, column;
    int wayOut;

    public Golem(int row, int column, int wayOut) {
        this.row = row;
        this.column = column;
        this.wayOut = wayOut;
    }
}