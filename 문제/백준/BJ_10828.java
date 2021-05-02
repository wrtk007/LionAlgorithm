//문제
//        정수를 저장하는 스택을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.
//
//        명령은 총 다섯 가지이다.
//
//        push X: 정수 X를 스택에 넣는 연산이다.
//        pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//        size: 스택에 들어있는 정수의 개수를 출력한다.
//        empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
//        top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.

//        입력
//        첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)이 주어진다.
//        둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다.
//        주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다.
//        문제에 나와있지 않은 명령이 주어지는 경우는 없다.

import java.io.*;
import java.util.*;

public class BJ_10828 {
//    ArrayList : List 인터페이스 상속받은 클래스
    static ArrayList<Integer> stack = new ArrayList<>();

    public static void push(int x) {
        stack.add(x);
    }

    public static int pop() {
        if (stack.size() == 0) {
            return -1;
        }
        else {
            int rtn = stack.get(stack.size()-1);
            stack.remove(stack.size()-1);
            return rtn;
        }
    }

    public static int size() {
        return stack.size();
    }

    public static int empty() {
        if (stack.isEmpty()) {
            return 1;
        }
        else {
            return 0;
        }
    }

    public static int top() {
        if (stack.size() > 0) {
            return stack.get(stack.size()-1);
        }
        else{
            return -1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //첫번째 라인 : 명령어 개수
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        //명령어 개수만큼 br.readLine()으로 한 줄씩 명령어 읽고
        //이를 StringTokenizer 활용해서 split
        for (int i=0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
                if (order.equals("push")) {
                    push(Integer.parseInt(st.nextToken()));
                }
                else if (order.equals("pop")) {
                    sb.append(pop() +"\n");
                }
                else if (order.equals("size")) {
                    sb.append(size() +"\n");
                }
                else if (order.equals("empty")) {
                    sb.append(empty() +"\n");
                }
                else if (order.equals("top")) {
                    sb.append(top() +"\n");
                }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

}
