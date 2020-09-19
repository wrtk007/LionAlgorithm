// 시간 초과 발생

//입력 : 첫째 줄 - 듣도 못한 사람의 수 N, 보도 못한 사람의 수 M
//      2~N+1번째 줄 - 듣도 못한 사람의 이름
//      N+2~M - 보도 못한 삶의 이름
//     *이름은 띄어쓰기 없이 소문자로만 이루어지며 길이는 20이하.
//     * N, M < 500,000인 자연수
//출력 : 듣보잡의 수와 그 명단을 사전 순으로 출력 -> 교집합 출력

import java.util.*;
import java.lang.String;

public class no_1764 {
    static int N;
    static int M;
    static int k = 0;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        System.out.print("듣도 못한 사람의 수 N, 보도 못한 사람의 수 M 입력 :");
        N = sc.nextInt();
        M = sc.nextInt();


        String[] hear = new String[N];
        String[] see = new String[M];

//        System.out.println("듣도 못한 사람 N명의 이름을 작성.");
        for (int i=0; i<N; i++) {
            hear[i] = sc.next();
        }

//        System.out.println("보도 못한 사람 M명의 이름을 작성.");
        for (int i=0; i<M; i++) {
            see[i] = sc.next();
        }

        find(hear, see);
    }


    public static void find(String[] hear, String[] see) {

        Arrays.sort(hear);
        Arrays.sort(see);


        String[] ans = new String[Math.max(N,M)];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                ans[k] = comparing(hear[i], see[j]);
            }
        }

//        System.out.println("듣도 보도 못한 사람은");
        System.out.println(k);

        for (int i = 0; i < k; i++) {
            System.out.println(ans[i]);
        }
    }

    public static String comparing(String hear, String see) {
        if (hear.equals(see)) {
            k++;
            return hear;
        }
        return null;
    }
}

