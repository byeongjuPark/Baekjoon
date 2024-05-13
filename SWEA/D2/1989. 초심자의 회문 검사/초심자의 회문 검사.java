import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int result = 1;
			String word = sc.next();
            String[] wordArr = word.split("");
            for(int i = 0; i < word.length() /2; i++){
                if(!wordArr[i].equals(wordArr[word.length()-i -1])){
                    result = 0;
                }
            }

            System.out.println("#" + test_case + " " + result);
		}
	}
}