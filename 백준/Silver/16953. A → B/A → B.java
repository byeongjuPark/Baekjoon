import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
//    정수 A를 B로 바꾸려고 한다. 가능한 연산은 다음과 같은 두 가지이다.
//
//            2를 곱한다.
//            1을 수의 가장 오른쪽에 추가한다.
//    A를 B로 바꾸는데 필요한 연산의 최솟값을 구해보자.
    // 2 162
    // 2 → 4 → 8 → 81 → 162
    // 5
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int result = 1;
        while(A != B){
            if(A > B){
                result = -1;
                break;
            }
            result++;
            if(getOneDigit(B)){
                B = setOneDigit(B);
            } else if(isEven(B)){
                B = B / 2;
            } else {
                result = -1;
                break;
            }
        }

        System.out.println(result);
        // B의 1의 자리가 1이면 1을 때고, 아니면 2로 나눠
        // 1의 자리가 1을 제외한 홀수이면 만들 수 없음
    }

    public static boolean isEven(int num){
        return num % 2 == 0;
    }
    public static boolean getOneDigit(int num){
        return num % 10 == 1;
    }
    public static int setOneDigit(int num){
        return num / 10;
    }
}