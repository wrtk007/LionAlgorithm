import java.util.*;

//아홉 개의 숫자 중 합이 100이 되는 일곱 개의 숫자를 찾는 프로그램을 작성하시오
public class epper_2018_7 {
    public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[9];
        int sum = 0;

        for (int i=0; i<9; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++ ) {
                if (sum - arr[i] - arr[j] == 100){
                    arr[i] = -1;
                    arr[j] = -1;
                }
            }
        }

        for(int i=0; i<9; i++) {
            if(arr[i] > -1) {
                System.out.println(arr[i]);
            }
        }

    }
}
