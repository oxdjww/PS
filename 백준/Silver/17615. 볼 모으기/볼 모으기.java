import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] balls = br.readLine().toCharArray();

        int totalR = 0, totalB = 0;
        for (char c : balls) {
            if (c == 'R') totalR++;
            else totalB++;
        }

        // 왼쪽에서부터 연속된 R, B 개수
        int leftR = 0, leftB = 0;
        for (char c : balls) {
            if (c == 'R') leftR++;
            else break;
        }
        for (char c : balls) {
            if (c == 'B') leftB++;
            else break;
        }

        // 오른쪽에서부터 연속된 R, B 개수
        int rightR = 0, rightB = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (balls[i] == 'R') rightR++;
            else break;
        }
        for (int i = N - 1; i >= 0; i--) {
            if (balls[i] == 'B') rightB++;
            else break;
        }

        int moveRLeft = totalR - leftR;
        int moveRRight = totalR - rightR;
        int moveBLeft = totalB - leftB;
        int moveBRight = totalB - rightB;

        int answer = Math.min(Math.min(moveRLeft, moveRRight), Math.min(moveBLeft, moveBRight));
        System.out.println(answer);
    }
}
