import java.util.*;

public class epper_2018_9 {
    public static int[] solution(int n,int m) {
        int[] answer = {};
        int min = Math.min(n,m);
        answer = new int[min+1];

        int total = n+m;
        if (n != 1 && m != 1)
            total -= (m-2) * (n-2);

        int j=0;
        for (int i=1; i<=min; i++) {
            if (i==1) {
                answer [j++] = 1;
                continue;
            }

            if (total % i  == 0) {
                if (n%i ==0) {
                    if ((m-2)%i==0) answer[j++] = i;
                    else if ((m-1)%i == 0 && (n-2)%i ==0)
                        answer[j++] = i;
                } else if (n%i == 1) {
                    if ((m-1)%i == 0)answer[j++] = i;
                    else if ((m-2)%i == 0 && m%i == 0)answer[j++] = i;
                }
            }
        }
        return answer;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int min = Math.min(N,M);
        int[] answer = solution(N,M);
        for (int i=0; i<min; i++) {
            if (answer[i] != 0) {
                System.out.println(answer[i]);
            }
        }

    }

}
