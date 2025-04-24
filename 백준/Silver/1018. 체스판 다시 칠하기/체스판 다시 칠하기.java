import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] arr = new char[N][M];
        boolean[][] re = new boolean[N][M];
        for (int i = 0; i < re.length; i++) {
            Arrays.fill(re[i], false);
        }

        for (int i = 0; i < N; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                arr[i][j] = line[j];
            }
        }
        int answer = Integer.MAX_VALUE;
        boolean flag = true;
        for (int row = 0; row <= N - 8; row++) {
            for (int column = 0; column <= M - 8; column++) {
                if (arr[row][column] == 'B')
                    flag = false;

                int tmp1 = 0; // 시작점이 W라고 가정
                int tmp2 = 0; // 시작점이 B라고 가정

                for (int k = row; k < row + 8; k++) {
                    for (int l = column; l < column + 8; l++) {
                        if ((k + l) % 2 == 0) {
                            if (arr[k][l] == 'W')
                                tmp1++;
                            if (arr[k][l] == 'B')
                                tmp2++;
                        } else {
                            if (arr[k][l] == 'B')
                                tmp1++;
                            if (arr[k][l] == 'W')
                                tmp2++;
                        }
                    }
                }
                answer = Math.min(answer, Math.min(tmp1, tmp2));

            }
        }
        System.out.println(answer);
    }
}