import java.util.*;
import java.io.*;

public class Main {
    static int getOrder(int size, int r, int c) {
        if (size == 1) return 0;
    
        int half = size / 2;
        int area = (half) * (half);
    
        if (r < half && c < half)
        {
            // 왼쪽 위
            return getOrder(half, r, c);
        }
        else if (r < half && c >= half)
        {
            // 오른쪽 위
            return area * 1 + getOrder(half, r, c - half);
        }
        else if (r >= half && c < half)
        {
            // 왼쪽 아래
            return area * 2 + getOrder(half, r - half, c);
        }
        else
        {
            // 오른쪽 아래
            return area * 3 + getOrder(half, r - half, c - half);
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int r = scanner.nextInt();
        int c = scanner.nextInt();

        int size = (int)Math.pow(2, N);
        int result = getOrder(size, r, c);
        System.out.println(result);
    }
}