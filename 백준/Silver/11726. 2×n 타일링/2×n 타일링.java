import java.io.*;

public class Main {
    static int[] array = new int[1001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        array[1] = 1;
        array[2] = 2;
        for (int i = 3; i <= num; i++) {
            array[i] = (array[i-1] + array[i-2]) % 10007;
        }
        System.out.println(array[num]);
    }
}
