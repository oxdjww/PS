import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        long N = new Scanner(System.in).nextLong();
        
        System.out.print((long)(Math.pow(Math.pow(2, N) + 1, 2)));
    }
}