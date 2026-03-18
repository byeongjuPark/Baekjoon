import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, R, C, count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        int len = (int) Math.pow(2, N);
        count = 0;
        divide(0, 0, len);
    }

    static void divide(int r, int c, int len) {
        if (len == 1) {
            System.out.println(count);
            return;
        }

        int halfLen = len / 2;

        // 1사분면
        if (R < r + halfLen && C < c + halfLen) {
            divide(r, c, halfLen);
        }
        // 2사분면
        else if (R < r + halfLen && C >= c + halfLen) {
            count += halfLen * halfLen;
            divide(r, c + halfLen, halfLen);
        }
        // 3사분면
        else if (R >= r + halfLen && C < c + halfLen) {
            count += 2 * halfLen * halfLen;
            divide(r + halfLen, c, halfLen);
        }
        // 4사분면
        else {
            count += 3 * halfLen * halfLen;
            divide(r + halfLen, c + halfLen, halfLen);
        }
    }
}
