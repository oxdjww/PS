import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();
        int e = scanner.nextInt();
        int f = scanner.nextInt();
        for(int x = -999 ; x < 1000 ; x++)
        {
            for(int y = -999 ; y < 1000 ; y++)
            {
                if(a * x + b * y == c && d * x + e * y == f)
                {
                    System.out.print(x + " " + y);
                }
            }
        }
    }
}