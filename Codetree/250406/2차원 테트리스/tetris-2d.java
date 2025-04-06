import java.util.*;
import java.io.*;

public class Main {
    private static boolean[][] blue = new boolean[4][4];
    private static boolean[][] yellow = new boolean[6][4];
    private static boolean[][] red = new boolean[6][4];
    private static int score = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] commands = new int[n][3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            commands[i][0] = Integer.parseInt(st.nextToken());
            commands[i][1] = Integer.parseInt(st.nextToken());
            commands[i][2] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < commands.length ; i++) {
            int type = commands[i][0];
            int row = commands[i][1];
            int col = commands[i][2];
            
            fromBlueTo(yellow, type, row, col);

            if(type == 2) {
                type = 3;
                fromBlueTo(red, type, col, 3 - row);
            }
            else if(type == 3 ) {
                type = 2;
                fromBlueTo(red, type, col, 3 - row - 1);
            } else {
                fromBlueTo(red, type, col, 3 - row);
            }

            checkArray(yellow);
            checkLightArray(yellow);
            
            checkArray(red);
            checkLightArray(red);
        }

        System.out.println(score);
        int count = 0;
        for(int i = 2 ; i < red.length ; i++) {
            for(int j = 0 ; j < red[i].length ; j++) {
                if(red[i][j]) count++;
                if(yellow[i][j]) count++;
            }
        }
        System.out.println(count);
    }
    private static void fromBlueTo(boolean[][] arr, int type, int row, int col) {
        switch (type) {
            case 1:
                arr[1][col] = true;
                for(int r = 1, c = col; r < arr.length - 1 && !arr[r+1][col] ; r++) {
                    arr[r][col] = false;
                    arr[r+1][col] = true;
                }
                break;
            case 2:
                arr[1][col] = true;
                arr[1][col+1] = true;
                for(int r = 1, c = col; r < arr.length - 1 && !arr[r+1][col] && !arr[r+1][col+1] ; r++) {
                    arr[r][col] = false;
                    arr[r][col+1] = false;
                    arr[r+1][col] = true;
                    arr[r+1][col+1] = true;
                }
                break;
            case 3:
                arr[0][col] = true;
                arr[1][col] = true;
                for(int r = 0, c = col; r < arr.length - 2 && !arr[r+2][col] ; r++) {
                    arr[r][col] = false;
                    arr[r+1][col] = false;
                    arr[r+1][col] = true;
                    arr[r+2][col] = true;
                }
                break;
            default:
                break;
        }
    }
    private static void checkArray(boolean[][] arr) {
        for(int i = arr.length - 1; i >= 0 ; i--) {
            int count = 0;
            for(int j = 0; j < arr[i].length; j++) {
                if(arr[i][j]) count++;
            }
            if(count == 4) {
                score++;
                down(arr, i);
                checkArray(arr);
                break;
            }
        }
    }
    private static void down(boolean[][] arr, int line) {
        for(int i = line - 1 ; i >= 0 ; i--) {
            for(int j = 0 ; j < arr[i].length ; j++) {
                arr[i+1][j] = arr[i][j];
                arr[i][j] = false;
            }
        }
    }

    private static void checkLightArray(boolean[][] arr) {
        int count = 0;
        for(int i = 0 ; i < 2 ; i++) {
            boolean flag = false;
            for(int j = 0 ; j < arr[i].length ; j++) {
                if(arr[i][j]) flag = true;
            }
            if(flag) count++;
        }
        for(int i = 0 ; i < count ; i++) {
            down(arr, 5);
        }
    }
}