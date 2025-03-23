import java.util.*;
import java.io.*;

public class Main {
    static int[][] paper;
    static int white = 0;
    static int blue = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        paper = new int[N][N];

        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++)
                paper[i][j] = sc.nextInt();

        divide(0, 0, N);

        System.out.println(white);
        System.out.println(blue);
    }

    static void divide(int x, int y, int size)
    {
        if(isSameColor(x, y, size))
        {
            if(paper[x][y] == 0) white++;
            else blue++;
            return;
        }

        int half = size / 2;
        divide(x, y, half);
        divide(x, y + half, half);
        divide(x + half, y, half);
        divide(x + half, y + half, half);
    }

    static boolean isSameColor(int x, int y, int size) {
        int color = paper[x][y];

        for(int i = x; i < x + size; i++)
            for(int j = y; j < y + size; j++)
                if(paper[i][j] != color)
                    return false;

        return true;
    }
}
