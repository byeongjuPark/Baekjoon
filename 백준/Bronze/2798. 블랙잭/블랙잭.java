import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList list = new ArrayList<Integer>();
        int result = 0;
        int temp = 0;
        int n = sc.nextInt();
        int m = sc.nextInt();
        for(int i =0; i<n ; i++){
            list.add(sc.nextInt());
        }
        
        for(int i = 0 ; i<n; i++){
            for(int j = 0; j<n; j++){
                for(int k = 0; k < n; k++){
                    if(i!=j && j!=k && k!=i){
                        temp=(Integer)list.get(i) + (Integer)list.get(j) + (Integer)list.get(k);
                        if(temp <= m){
                            if(result < temp){
                                result = temp;
                            }
                        }
                    }

                }
            }
        }
        System.out.println(result);
    }
}