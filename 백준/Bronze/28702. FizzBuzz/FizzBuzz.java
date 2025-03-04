import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = -1;
        for(int i = 0 ; i < 3 ; i++)
        {
            String input = br.readLine();
            if(Character.isDigit(input.charAt(0)))
            {
                int number = Integer.parseInt(input);
                if(i == 0)
                {
                    answer = number + 3;
                    break;
                }
                else if(i == 1)
                {
                    answer = number + 2;
                    break;
                }
                else
                {
                    answer = number + 1;
                    break;
                }
            }
        }
        if(answer % 3 == 0)
        {
            if(answer % 5 == 0)
            {
                System.out.println("FizzBuzz");
            }
            else
            {
                System.out.println("Fizz");
            }
        }
        else if(answer % 5 ==0)
        {
            System.out.println("Buzz");
        }
        else
        {
            System.out.println(answer);
        }
    }
}
