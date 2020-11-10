import java.util.*;

//일곱난쟁이
public class no_2309 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = 9;
        int[] arr = new int[n];
        int sum = 0;

        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        
        Arrays.sort(arr);

        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                
                // i와 j번째 난쟁이 뺐을 때 100이면 보여주기
                if (sum - arr[i] - arr[j] == 100) {

                    for (int k=0; k<n; k++) {
                        if (i == k || j == k){
                            continue;
                        }
                        System.out.println(arr[k]);
                    }

                }
            }
        }
    }
}

//초과되는 합인 것을 빼기