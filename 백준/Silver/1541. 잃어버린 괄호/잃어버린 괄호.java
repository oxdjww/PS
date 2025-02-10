import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String expression = br.readLine();
        
        String[] parts = expression.split("-");

        int result = calculate(parts[0]);

        for (int i = 1; i < parts.length; i++)
        {
            result -= calculate(parts[i]);
        }

        System.out.println(result);
    }

    public static int calculate(String str)
    {
        int sum = 0;
        String[] numbers = str.split("\\+");

        for (String number : numbers)
        {
            sum += Integer.parseInt(number);
        }

        return sum;
    }
}
