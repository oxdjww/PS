import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int count = 0;
        for(int i = 1 ; i <= N ; i++)
        {
            if(N%i == 0)
            {
                count++;
                if(count == K)
                {
                    System.out.print(i);
                    return;
                }
            }
        }
        System.out.print(0);
    }
}