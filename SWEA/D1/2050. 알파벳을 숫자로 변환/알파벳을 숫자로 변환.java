import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        String inputStr = sc.nextLine();
        char alpha[] = inputStr.toCharArray();
        for(int i = 0 ; i < alpha.length; i++){
            char a = (char) (alpha[i] -  'A' + 1);
            System.out.print((int)a + " ");
        }
	}
}