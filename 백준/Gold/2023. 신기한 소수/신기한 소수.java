import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int depth;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        depth = scanner.nextInt();

        singi(2, 1);
        singi(3,1);
        singi(5,1);
        singi(7,1);
        System.out.print(sb);
    }
    private static void singi(int number, int localDepth)
    {
        if(localDepth == depth)
        {
            if(isPrime(number))
            {
                sb.append(number + "\n");
            }
            return;
        }
        for(int i = 1 ; i < 10 ; i+=2)
        {
            if(isPrime(number * 10 + i))
            {
                singi(number * 10 + i, localDepth + 1);
            }
        }
    }
    private static boolean isPrime(int number)
    {
        for(int i = 2 ; i <= Math.sqrt(number) ; i++)
        {
            if(number % i == 0) return false;
        }
        return true;
    }
}