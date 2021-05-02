//문제
//        그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 
//        단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 
//        더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.
//
//입력
//        첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 
//        탐색을 시작할 정점의 번호 V가 주어진다. 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다.
//        어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 입력으로 주어지는 간선은 양방향이다.
import  java.util.*;

public class no_1260 {
    static int i, j;
    static ArrayList<Integer> DFS(int[][] q, int V, int N) {
        ArrayList a = new ArrayList<Integer>();
        boolean[] visit = new boolean[N];

        for(i=1; i<q.length; i++) {
        }

        return a;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();//정점의 개수
        int M = sc.nextInt();//간선의 개수
        int V = sc.nextInt();//탐색을 시작할 정점의 번호

        int g[][] = new int[N+1][N+1];
        for (i=1; i<N+1; i++) {
            for (j=1; j<N+1; j++) {
                g[i][j] = 0;
            }
        }

        for (i=0; i<M; i++) {
            int a = sc.nextInt(); //간선의 시작점
            int b = sc.nextInt(); //간선의 도착점
            g[a][b] = 1;
            g[b][a] = 1;
        }

        DFS(g,V,N);

    }
}
