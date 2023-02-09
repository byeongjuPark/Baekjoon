import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int silver = sc.nextInt();
        int gold = sc.nextInt();
        int platinum = sc.nextInt();
        int diamond = sc.nextInt();
        String levelStr = sc.next();
        int sum = 0;
        int lastMonth = 0;
        String str[] = levelStr.split("");
        for(int i = 0; i<N ; i++){
            // 첫 번째 달 계산
            // str[i] - 1
            if(i==0){
                if(str[i].equals("B")){
                    sum += silver - 1;
                    lastMonth = silver -1;
                }else if(str[i].equals("S")){
                    sum += gold -1;
                    lastMonth = gold - 1; 
                }else if(str[i].equals("G")){
                    sum += platinum -1;
                    lastMonth = platinum - 1; 
                }else if(str[i].equals("P")){
                    sum += diamond -1;
                    lastMonth = diamond - 1; 
                }else if(str[i].equals("D")){
                    sum += diamond;
                    lastMonth = diamond;
                }
            }else if(str[i].equals("B")){
                lastMonth = silver -1 - lastMonth;
                sum += lastMonth;
            }else if(str[i].equals("S")){
                lastMonth = gold - 1 - lastMonth; 
                sum += lastMonth;
            }else if(str[i].equals("G")){
                lastMonth = platinum - 1 - lastMonth; 
                sum += lastMonth;
            }else if(str[i].equals("P")){
                lastMonth = diamond - 1 - lastMonth; 
                sum += lastMonth;
            }else if(str[i].equals("D")){
                lastMonth = diamond;
                sum += lastMonth;
            }
            System.out.print("");
            
        }
        System.out.println(sum);
    }
}
