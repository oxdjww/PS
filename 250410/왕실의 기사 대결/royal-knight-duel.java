import java.util.*;
import java.io.*;

public class Main {
    private static int L;
    private static int N;
    private static int Q;
    private static int[][] board, knightBoard;
    private static Knight[] knightStatus;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        board = new int[L][L];
        knightBoard = new int[L][L];
        knightStatus = new Knight[N+1];

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

            execute(commandKnight, direction);
        }
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
        // 움직일 수 없으면 continue;
        if(!canMove(commandKnight, direction)) {
            System.out.println(commandKnight + "CAN'T MOVE");
            return;
        }
        // 이동
        // moveKnight(commandKnight, direction);

        // 데미지 계산(commandKnight 제외)
        
    }

    private static boolean canMove(int commandKnight, int direction) {
        boolean flag = true;
        int nextRow;
        int nextColumn;
        int row;
        int column;
        int height;
        int width;
        switch(direction) {
            case 0: // 위쪽
                nextRow = knightStatus[commandKnight].row - 1;
                column = knightStatus[commandKnight].column;
                width = knightStatus[commandKnight].width;

                // 보드를 벗어나는 경우
                if(nextRow < 0) {
                    flag = false;
                    break;
                }
                // 벽인 경우
                for(int i = column; i < column + width; i++) {
                    if(board[nextRow][column] == 2) {
                        flag = false;
                        break;
                    }
                }

                // 다른 기사가 있는 경우
                for(int i = column; i < column + width; i++) {
                    int nextKnight = knightBoard[nextRow][column];
                    if(nextKnight != 0) {
                        flag = canMove(nextKnight, direction);
                    }
                }
                break;

            case 1: // 오른쪽
                nextColumn = knightStatus[commandKnight].row + 1;
                row = knightStatus[commandKnight].row;
                height = knightStatus[commandKnight].height;

                // 보드를 벗어나는 경우
                if(nextColumn >= L) {
                    flag = false;
                    break;
                }
                // 벽인 경우
                for(int i = row; i < row + height; i++) {
                    if(board[row][nextColumn] == 2) {
                        flag = false;
                        break;
                    }
                }

                // 다른 기사가 있는 경우
                for(int i = row; i < row + height; i++) {
                    int nextKnight = knightBoard[row][nextColumn];
                    if(nextKnight != 0) {
                        flag = canMove(nextKnight, direction);
                    }
                }
                break;

            case 2: // 아래쪽
                nextRow = knightStatus[commandKnight].row + 1;
                column = knightStatus[commandKnight].column;
                width = knightStatus[commandKnight].width;
                System.out.println(nextRow + "행 " + column + "열 부터 높이 " + width + "만큼 검사");
                // 보드를 벗어나는 경우
                if(nextRow >= L) {
                    return false;
                }
                
                // 벽인 경우
                for(int i = column; i < column + width; i++) {
                    if(board[nextRow][i] == 2) {
                        return false;
                    }
                }

                // 다른 기사가 있는 경우
                for(int i = column; i < column + width; i++) {
                    int nextKnight = knightBoard[nextRow][i];
                    if(nextKnight != 0) {
                        return canMove(nextKnight, direction);
                    }
                }
                return true;

            case 3: //왼쪽
                nextColumn = knightStatus[commandKnight].row - 1;
                row = knightStatus[commandKnight].row;
                height = knightStatus[commandKnight].height;

                // 보드를 벗어나는 경우
                if(nextColumn < 0) {
                    flag = false;
                    break;
                }
                // 벽인 경우
                for(int i = row; i < row + height; i++) {
                    if(board[row][nextColumn] == 2) {
                        flag = false;
                        break;
                    }
                }

                // 다른 기사가 있는 경우
                for(int i = row; i < row + height; i++) {
                    int nextKnight = knightBoard[row][nextColumn];
                    if(nextKnight != 0) {
                        flag = canMove(nextKnight, direction);
                    }
                }
                break;

            default:
                break;
        }
        return flag;
    }

    private static void moveKnight(int knightNumber, int direction) {
        
    }
}

class Knight {
    int row;
    int column;
    int height;
    int width;
    int power;
    int damage = 0;

    public Knight(int row, int column, int height, int width, int power) {
        this.row = row;
        this.column = column;
        this.height = height;
        this.width = width;
        this.power = power;
    }
}