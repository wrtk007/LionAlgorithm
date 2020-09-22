// 배열 한 개 쓸 수 있는 방향으로 + 버블로 탐색하는 느낌...?

import java.util.*;
public class no_1764 {
    public static void main(String[] args) throws Exception{

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        ArrayList<String> compare = new ArrayList<String>();
        String[] list = new String[N+M];

        for (int i=0; i<N; i++) {
            list[i] = sc.next();
        }
        
        for (int j=N; j < N+M; j++) {
            list[j] = sc.next();
        }

        Arrays.sort(list);

        for (int n=0; n < N+M; n++) {
            if(n == N+M-1) break;
            else {

                if (list[n].equals(list[n+1])) {
                    compare.add(list[n]);
                }
            }

        }

        System.out.println(compare.size());

        for (String i : compare) {
            System.out.println(i);
        }
    }
}


