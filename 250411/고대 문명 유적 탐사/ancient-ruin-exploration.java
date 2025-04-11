import java.util.*;
import java.io.*;

public class Main {
    
    private static int K;
    private static int M;
    private static int[][] board = new int[5][5];
    private static Queue<Integer> spare = new LinkedList<>();
    private static int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            spare.offer(Integer.parseInt(st.nextToken()));
        }

        // print(board);

        int answer = 0;
        for(int i = 0; i < K; i++) {
            answer += execute();
        }
        System.out.println(answer);
    }

    private static int execute() {
        int relicCount = 0;
        int[] optimumConditions = findOptimum();

        int optimumRow = optimumConditions[0];
        int optimumColumn = optimumConditions[1];
        int optimumRotate = optimumConditions[2];
        
        while(optimumRotate-- < 0) {
            rotate90(board, optimumRow, optimumColumn);
        }

        // do {
        //     relicCount += collectRelic();

        //     fillRelic();
        // } while(relicExists());

        return relicCount;
    }

    private static void rotate90(int[][] matrix, int row, int column) {
        System.out.println(row + ", " + column + " 기준으로 90도 회전");
        // 3x3 부분 배열을 기준으로 시계방향 90도 회전
        int[][] temp = new int[3][3];
        
        // 3x3 배열 복사
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                temp[i][j] = matrix[row + i - 1][column + j - 1];
            }
        }

        // 90도 시계방향 회전 후 원래 위치에 다시 저장
        matrix[row-1][column-1] = temp[2][0];
        matrix[row-1][column] = temp[1][0];
        matrix[row-1][column+1] = temp[0][0];

        matrix[row][column-1] = temp[2][1];
        matrix[row][column] = temp[1][1];
        matrix[row][column+1] = temp[0][1];

        matrix[row+1][column-1] = temp[2][2];
        matrix[row+1][column] = temp[1][2];
        matrix[row+1][column+1] = temp[0][2];
    }

    private static int[][] createCopyOf2DArray(int[][] array) {
        int[][] copy = new int[5][5];
        for(int i = 0; i < board.length; i++) {
            copy[i] = Arrays.copyOf(board[i], board[i].length);
        }
        return copy;
    }

    private static int[] findOptimum() {
        int optimumRow = -1;
        int optimumColumn = -1;
        int optimumRotate = -1;
        int maxCount = -1;
        for(int i = 1; i < 4; i++) {
            for(int j = 1; j < 4; j++) {
                int[][] copy = createCopyOf2DArray(board);

                for(int k = 1; k <= 4; k++) {
                    rotate90(copy, i, j);
                    List<Point> pangRelicsList = countRelics(copy);
                    int relicsCount = 0;
                    for(int l = 0; l < pangRelicsList.size(); l++) {
                        relicsCount += pangRelicsList.get(l).count;
                    }
                    if(maxCount < relicsCount) {
                        optimumRow = i;
                        optimumRow = j;
                        maxCount = relicsCount;
                        optimumRotate = k;
                    }
                    System.out.println("아래 보드 유물 개수: " + relicsCount);
                    print(copy);
                }
            }
        }
        return new int[]{optimumRow, optimumColumn, optimumRotate};
    }

    private static boolean isValidPoint(int row, int column) {
        return row >= 0 && row < 5 && column >= 0 && column < 5;
    }

    private static List<Point> countRelics(int[][] matrix) {
        Queue<Point> queue = new LinkedList<>();
        List<Point> pang = new ArrayList<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        // 모든 칸 다 넣기
        for(int row = 0; row < matrix.length; row++) {
            for(int column = 0; column < matrix[row].length; column++) {
                // relicsCount += dfs(matrix, false, row, column, 1, 1, visited);
                List<int[]> tmp = new ArrayList<>();
                tmp.add(new int[]{row, column});
                queue.offer(new Point(row, column, 1, tmp));
            }
        }

        while(!queue.isEmpty()) {
            Point current = queue.poll();
            int currentRow = current.row;
            int currentColumn = current.column;
            int currentCount = current.count;
            int currentNumber = matrix[currentRow][currentColumn];

            for(int i = 0; i < directions.length; i++) {
                int nextRow = currentRow + directions[i][0];
                int nextColumn = currentColumn + directions[i][1];

                if(isValidPoint(nextRow, nextColumn) && 
                        current.history.get(0) && 
                        currentNumber == matrix[nextRow][nextColumn]) {
                    System.out.println(currentRow + ", " + currentColumn + " -> " + nextRow + ", " + nextColumn + "(" + (currentCount + 1)  + ")");
                    List<int[]> currentHistory = new ArrayList<>(current.history);
                    currentHistory.add(new int[]{nextRow, nextColumn});
                    queue.offer(new Point(nextRow, nextColumn, currentCount + 1, currentHistory));
                    visited[nextRow][nextColumn] = true;
                } else if (currentCount >= 3) {
                    pang.add(current);
                }
            }
        }

        return pang;
    }
    

    private static void print(int[][] matrix) {
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

class Point {
    int row, column;
    int count;
    List<int[]> history;

    public Point(int row, int column, int count, List<int[]> history) {
        this.row = row;
        this.column = column;
        this.count = count;
        this.history = history;
    }
}