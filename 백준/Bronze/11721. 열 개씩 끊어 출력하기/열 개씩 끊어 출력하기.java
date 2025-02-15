import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        for(int i = 0 ; i < word.length() ; i+=10)
        {
            if(i + 10 > word.length())
                System.out.println(word.substring(i));
            else
                System.out.println(word.substring(i, i+10));
        }
    }
}