import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String num = sc.next();
        int result =0;
        for(int i = 0; i<n;i++){
            int parseInt = Integer.parseInt(String.valueOf(num.charAt(i)));
            result+=parseInt;

        }
        System.out.println(result);
        

    }
}
