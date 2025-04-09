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
            int commandNight = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());

            execute(commandNight, direction);
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

    private static void execute(int commandNight, int direction) {
        // 움직일 수 없으면 continue;
        if(!canMove(commandNight, direction)) {
            continue;
        }
        // 이동
        moveKnight(commandNight, direction)
        // 데미지 계산(commandNight 제외)
        
    }

    private static boolean canMove(int commandNight, int direction) {
        boolean flag = false;
        switch(dircetion) {
            case 0: // 위쪽
                int nextRow = knightStatus[commandNight].row - 1;
                if(nextRow >= 0) flag = true;
                break;

            case 1: // 오른쪽
                int nextColumn = knightStatus[commandNight].column + 1;
                if(nextColumn < L) flag = true;
                break;

            case 2: // 아래쪽
                int nextRow = knightStatus[commandNight].row + 1;
                if(nextRow < L) flag = true;
                break;

            case 3: //왼쪽
                int nextColumn = knightStatus[commandNight].column - 1;
                if(nextColumn >= 0) flag = true;
                break;

            default:
                break;
        }
        return flag;
    }

    private static void moveKnight(int commandNight, int direction) {
        
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