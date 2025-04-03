import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long a = Long.parseLong(br.readLine());
        long b = Long.parseLong(br.readLine());
        long c = Long.parseLong(br.readLine());

        if(a == 60 && a == b && b == c) {
            System.out.print("Equilateral");
        }
        else if(a + b + c == 180) {
            if(a == b || b == c || c == a) {
                System.out.print("Isosceles");
            } else {
                System.out.print("Scalene");
            }
        } else {
            System.out.print("Error");
        }
    }
}

