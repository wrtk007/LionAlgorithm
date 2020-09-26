//문제
//        숫자 카드는 정수 하나가 적혀져 있는 카드이다. 상근이는 숫자 카드 N개를 가지고 있다.
//        정수 M개가 주어졌을 때, 이 수가 적혀있는 숫자 카드를 상근이가 가지고 있는지 아닌지를 구하는 프로그램을 작성하시오.
//
//입력
//        첫째 줄에 상근이가 가지고 있는 숫자 카드의 개수 N(1 ≤ N ≤ 500,000)이 주어진다.
//        둘째 줄에는 숫자 카드에 적혀있는 정수가 주어진다.
//        숫자 카드에 적혀있는 수는 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다.
//        두 숫자 카드에 같은 수가 적혀있는 경우는 없다.
//        셋째 줄에는 M(1 ≤ M ≤ 500,000)이 주어진다.
//        넷째 줄에는 상근이가 가지고 있는 숫자 카드인지 아닌지를 구해야 할 M개의 정수가 주어지며,
//        이 수는 공백으로 구분되어져 있다. 이 수도 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다
//
//출력
//        첫째 줄에 입력으로 주어진 M개의 수에 대해서,
//        각 수가 적힌 숫자 카드를 상근이가 가지고 있으면 1을, 아니면 0을 공백으로 구분해 출력한다.
//예제 입력
//          5
//          63 2 10 -10 4
//          8
//          10 9 -5 2 3 4 5  -10
//
//예제 출력
// 1 0 0 1 1 0 0 1


import java.util.*;

public class no_10815 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("상근이가 가지고 있는 숫자 카드의 개수를 입력하시오");

        int N = sc.nextInt();
        int[] SG = new int[N];
        for (int n=0; n<N; n++) {
            SG[n] = sc.nextInt();
        }

        int M = sc.nextInt();
        int[] check = new int[M];
        for(int n=0; n<M; n++) {
            check[n] = sc.nextInt();
        }

    }

    public static int[] insertsort(int[] arr) {
        //좌측 : 정렬 배열 - 우측 : 비정렬 배열
        int i, j, key;
        for (i = 1; i<arr.length; i++) {
            key = arr[i];
            for (j = i - 1; j >= 0 && arr[j]>key; j--)
                arr[j + 1] = arr[j];
            arr[j + 1] = key;
        }
        return arr;
    }
}
