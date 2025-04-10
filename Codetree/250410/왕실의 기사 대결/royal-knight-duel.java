import java.util.*;
import java.io.*;

public class Main {
    private static int L;
    private static int N;
    private static int Q;
    private static int[][] board, knightBoard;
    private static Knight[] knightStatus;
    private static int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private static boolean[] moved;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        board = new int[L][L];
        knightBoard = new int[L][L];
        knightStatus = new Knight[N+1];
        moved = new boolean[N+1];
        // 체스판 초기화
        for(int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < L; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 초기 기사 정보
        for(int knightNumber = 1; knightNumber <= N; knightNumber++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            putKnightsOnTheBoard(knightNumber, r - 1, c - 1, h, w, k);
        }
        // print(board);
        // print(knightBoard);
        // printKnightStatus();

        for(int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int commandKnight = Integer.parseInt(st.nextToken());
            if(knightStatus[commandKnight].power == 0) continue;
            int direction = Integer.parseInt(st.nextToken());

            if(knightStatus[commandKnight].alive){
                execute(commandKnight, direction);
            }
        }

        int answer = 0;
        for(int i = 1; i < knightStatus.length; i++) {
            Knight node = knightStatus[i];
            // System.out.println(i + "번 기사(" + node.alive + ") 누적 데미지: " + node.damage);
            if(node.alive) {
                answer += node.damage;
            }
        }
        System.out.println(answer);
    }

    private static void printKnightStatus() {
        for(int i = 1 ; i < knightStatus.length ; i++) {
            System.out.println(knightStatus[i].row);
            System.out.println(knightStatus[i].column);
            System.out.println(knightStatus[i].height);
            System.out.println(knightStatus[i].width);
            System.out.println(knightStatus[i].power);
        }
    }

    private static void putKnightsOnTheBoard(int knightNumber, int r, int c, int h, int w, int k) {
        for(int i = r; i < r + h; i++) {
            for(int j = c; j < c + w; j++) {
                knightBoard[i][j] = knightNumber;
            }
        }
        knightStatus[knightNumber] = new Knight(r, c, h, w, k);
    }

    private static void print(int[][] arr) {
        for(int i = 0 ; i < L ; i++) {
            for(int j = 0 ; j < L ; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void execute(int commandKnight, int direction) {
        // System.out.println(commandKnight + " MOVE TO " + direction);
        // 움직일 수 없으면 continue;
        if(!canMove(commandKnight, direction)) {
            // System.out.println(commandKnight + "CAN'T MOVE");
            return;
        }
        // System.out.println("CAN MOVE!!");
        // 이동
        moveKnight(commandKnight, direction);
        // print(knightBoard);
        // 데미지 계산(commandKnight 제외)
        calculateDamage(commandKnight);
        // print(knightBoard);
        Arrays.fill(moved, false);
    }

    private static void calculateDamage(int excludeKnight) {
        for(int i = 0; i < L; i++) {
            for(int j = 0; j < L; j++) {
                int knightNumber = knightBoard[i][j];
                if (board[i][j] == 1 && knightNumber != 0 && knightNumber != excludeKnight && moved[knightNumber]) {
                    int resultPower = knightStatus[knightNumber].power - 1;
                    if(resultPower <= 0) {
                        killKnight(knightNumber);
                    }
                    knightStatus[knightNumber].damage += 1;
                }
            }
        }
    }

    private static void killKnight(int knightNumber) {
        knightStatus[knightNumber].alive = false;
        for(int i = 0; i < L; i++) {
            for(int j = 0; j < L; j++) {
                if(knightBoard[i][j] == knightNumber) {
                    knightBoard[i][j] = 0;
                }
            }
        }
    }

    private static boolean canMove(int knightNumber, int direction) {
        int row = knightStatus[knightNumber].row;
        int column = knightStatus[knightNumber].column;
        int height = knightStatus[knightNumber].height;
        int width = knightStatus[knightNumber].width;
        // System.out.println("TRY " + knightNumber + "(" + row + ", " + column + ") MOVE TO " + direction);
        
        for(int i = row; i < row + height; i++) {
            for(int j = column; j < column + width; j++) {
                int nr = i + directions[direction][0];
                int nc = j + directions[direction][1];

                // 벽 체크
                if(isWall(nr,nc)) {
                    return false;
                }

                int next = knightBoard[nr][nc];

                if(next == 0 || next == (knightNumber)) {
                    continue;
                }

                if(!canMove(next, direction)) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean isWall(int r, int c) {
        return r < 0 || c < 0 || r >= L || c >= L || board[r][c] == 2;
    }
    
    private static void moveKnight(int knightNumber, int direction) {
        int row = knightStatus[knightNumber].row;
        int column = knightStatus[knightNumber].column;
        int height = knightStatus[knightNumber].height;
        int width = knightStatus[knightNumber].width;
        // System.out.println("MOVE " + knightNumber + "(" + row + ", " + column + ") MOVE TO " + direction);

        for(int i = row; i < row + height; i++) {
            for(int j = column; j < column + width; j++) {
                int nr = i + directions[direction][0];
                int nc = j + directions[direction][1];

                int next = knightBoard[nr][nc];

                if(next == 0 || next == knightNumber) {
                    continue;
                }
                
                moveKnight(next, direction);
            }
        }

        moved[knightNumber] = true;

        switch(direction) {
            case 0:
                moveUp(knightNumber, direction);
                break;
            case 1:
                moveRight(knightNumber, direction);
                break;
            case 2:
                moveDown(knightNumber, direction);
                break;
            case 3:
                moveLeft(knightNumber, direction);
                break;
        }

        knightStatus[knightNumber].row += directions[direction][0];
        knightStatus[knightNumber].column += directions[direction][1];
    }

    private static void moveUp(int knightNumber, int direction) {
        int row = knightStatus[knightNumber].row;
        int column = knightStatus[knightNumber].column;
        int height = knightStatus[knightNumber].height;
        int width = knightStatus[knightNumber].width;

        for (int r = row; r < row + height; r++) {
            for (int c = column; c < column + width; c++) {
                int nr =  r + directions[direction][0];
                int nc =  c + directions[direction][1];

                knightBoard[r][c] = 0;
                knightBoard[nr][nc] = (knightNumber);
            }
        }
    }

    private static void moveRight(int knightNumber, int direction) {
        int row = knightStatus[knightNumber].row;
        int column = knightStatus[knightNumber].column;
        int height = knightStatus[knightNumber].height;
        int width = knightStatus[knightNumber].width;

        for (int c = column + width - 1; c >= column; c--) {
            for (int r = row; r < row + height; r++) {
                int nr =  r + directions[direction][0];
                int nc =  c + directions[direction][1];

                knightBoard[r][c] = 0;
                knightBoard[nr][nc] = (knightNumber);
            }
        }
    }

    private static void moveDown(int knightNumber, int direction) {
        int row = knightStatus[knightNumber].row;
        int column = knightStatus[knightNumber].column;
        int height = knightStatus[knightNumber].height;
        int width = knightStatus[knightNumber].width;

        for (int r = row + height - 1; r >= row; r--) {
            for (int c = column; c < column + width; c++) {
                int nr =  r + directions[direction][0];
                int nc =  c + directions[direction][1];

                knightBoard[r][c] = 0;
                knightBoard[nr][nc] = (knightNumber);
            }
        }
    }

    private static void moveLeft(int knightNumber, int direction) {
        int row = knightStatus[knightNumber].row;
        int column = knightStatus[knightNumber].column;
        int height = knightStatus[knightNumber].height;
        int width = knightStatus[knightNumber].width;

        for (int c = column; c < column + width; c++) {
            for (int r = row; r < row + height; r++) {
                int nr =  r + directions[direction][0];
                int nc =  c + directions[direction][1];

                knightBoard[r][c] = 0;
                knightBoard[nr][nc] = (knightNumber);
            }
        }
    }
}

class Knight {
    int row;
    int column;
    int height;
    int width;
    int power;
    int damage = 0;
    boolean alive = true;

    public Knight(int row, int column, int height, int width, int power) {
        this.row = row;
        this.column = column;
        this.height = height;
        this.width = width;
        this.power = power;
        this.alive = true;
    }
}
