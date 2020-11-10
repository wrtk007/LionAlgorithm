import java.util.*;

public class epper_2018_10 {
    public static int solution(int[] n, int[][] r, int goal) {
        int answer = 0;
        int n_len = n.length;
        int[][] adj = new int[n_len][n_len];
        int[] time = new int[n_len];
        int[] total = new int[n_len];
        int[] inDegree = new int[n_len];

        System.arraycopy(n, 0, time, 0, n_len);
//        for (int i=0; i<n_len; i++) {
//            time[i] = n[i];
//        }

        for(int[] ints : r) {
            int X = ints[0] - 1;
            int Y = ints[1] - 1;
            adj[X][Y] = 1;
            inDegree[Y]++;
        }

//        for (int i=0; i<r.length; i++) {
//        }

        LinkedList<Integer> queue = new LinkedList<Integer>();

        for (int i=0; i<n_len; i++) {
            if (inDegree[i] == 0) {
                total[i] = time[i];
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int q = queue.poll();
            for (int i=0; i<n_len; i++) {
                if (adj[q][i] == 1) {
                    total[i] = Math.max(total[i], total[q]+time[i]);
                    if (--inDegree[i] == 0 )queue.add(i);
                }
            }
        }

        return answer = total[goal-1];
    }


    public static void main (String args[]) {
        int[] n = {10,20,100,20};
        int[][] r = {{1,2},{1,3},{2,4},{3,4}};

        int goal = 4;

        System.out.println(solution(n,r,goal));


    }

}


