//문제
//        요세푸스 문제는 다음과 같다.
//
//        1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고, 양의 정수 K(≤ N)가 주어진다.
//        이제 순서대로 K번째 사람을 제거한다. 한 사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 계속해 나간다.
//        이 과정은 N명의 사람이 모두 제거될 때까지 계속된다.
//        원에서 사람들이 제거되는 순서를 (N, K)-요세푸스 순열이라고 한다.
//        예를 들어 (7, 3)-요세푸스 순열은 <3, 6, 2, 7, 5, 1, 4>이다.
//
//        N과 K가 주어지면 (N, K)-요세푸스 순열을 구하는 프로그램을 작성하시오.
//입력
//        첫째 줄에 N과 K가 빈 칸을 사이에 두고 순서대로 주어진다. (1 ≤ K ≤ N ≤ 5,000)


import java.io.*;
import java.util.*;

public class BJ_1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();

        StringBuilder sb = new StringBuilder();
        sb.append("<");

//        1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있음
        for (int i=1; i<=N; i++) {
            q.add(i);
        }

//        큐가 빌 때까지
        while (q.size() != 0) {
//            0번부터 K-2번째 사람까지는 제거하지 않고 다시 큐에 삽입
            for (int i=0; i<K-1; i++) {
                q.add(q.poll());
            }
//            마지막에 남은 사람인 경우 바로 출력 sb에 추가하고 >로 닫기
            if (q.size() == 1) {
                sb.append(q.poll()+">");
            }
            else {
//                K-1번째 사람일 때 출력할 sb에 저장
                sb.append(q.poll()+", ");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
