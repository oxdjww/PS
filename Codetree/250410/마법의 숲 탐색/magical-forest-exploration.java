import java.util.*;
import java.io.*;

public class Main {
    private static int R;
    private static int C;
    private static int K;
    private static Golem[] golemStatus;
    private static int[][] board;
    private static int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 초기 위치 고려 상위 3행 더
        board = new int[R+3][C];
        golemStatus = new Golem[K+1];

        int answer = 0;

        for(int golemNumber = 1; golemNumber <= K; golemNumber++) {
            st = new StringTokenizer(br.readLine());
            int initColumn = Integer.parseInt(st.nextToken());
            int wayOut = Integer.parseInt(st.nextToken());

            setGolemOnBoard(golemNumber, initColumn - 1);
            golemStatus[golemNumber] = new Golem(1, initColumn, wayOut);

            answer = execute(golemNumber);
            print();
        }

        System.out.println(answer);
    }

    private static int execute(int golemNumber) {
        if(canMoveSouth(golemNumber)) {
            moveSouth(golemNumber);
        } else if(canMoveWest(golemNumber)) {
            moveWest(golemNumber);
        } else(canMoveEast(golemNumber)) {
            moveEast(golemNumber);
        }
    }

    private static moveSouth(int golemNumber) {
        int centerRow = golemStatus[golemNumber].row;
        int centerColumn = golemStatus[golemNumber].column;

        // 기존 골렘 위치 삭제
        for(int i = 0; i < directions.length; i++) {
            board[centerRow][centerColumn] = 0;
        }

        // 새 위치
        for(int i = 0; i < directions.length; i++) {
            board[centerRow+1][centerColumn] = 0;
        }
    }

    private static moveWest(int golemNumber) {
        int centerRow = golemStatus[golemNumber].row;
        int centerColumn = golemStatus[golemNumber].column;

        // 기존 골렘 위치 삭제
        for(int i = 0; i < directions.length; i++) {
            board[centerRow][centerColumn] = 0;
        }

        // 새 위치
        for(int i = 0; i < directions.length; i++) {
            board[centerRow+1][centerColumn-1] = 0;
        }
    }

    private static moveEast(int golemNumber) {
        int centerRow = golemStatus[golemNumber].row;
        int centerColumn = golemStatus[golemNumber].column;

        // 기존 골렘 위치 삭제
        for(int i = 0; i < directions.length; i++) {
            board[centerRow][centerColumn] = 0;
        }

        // 새 위치
        for(int i = 0; i < directions.length; i++) {
            board[centerRow+1][centerColumn+1] = 0;
        }
    }

    private static boolean canMoveSouth(int golemNumber) {
        int centerRow = golemStatus[golemNumber].row;
        int centerColumn = golemStatus[golemNumber].column;
        
        // 골렘의 중앙(정령)이 보드 R - 2행에 왔으면
        if(centerRow >= R - 2) return false;

        if(board[centerRow + 1][centerColumn - 1] != 0) return false;
        if(board[centerRow + 2][centerColumn] != 0) return false;
        if(board[centerRow + 1][centerColumn + 1] != 0) return false;

        return true;
    }

    private static boolean canMoveWest(int golemNumber) {
        int centerRow = golemStatus[golemNumber].row;
        int centerColumn = golemStatus[golemNumber].column;
        
        // 골렘의 중앙(정령)이 보드 R - 2행에 왔으면
        if(centerRow >= R - 2) return false;

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
        if(centerRow >= R - 2) return false;

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
    int row, col;
    int wayOut;

    public Golem(int row, int col, int wayOut) {
        this.row = row;
        this.col = col;
        this.wayOut = wayOut;
    }
}