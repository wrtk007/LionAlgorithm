import java.util.*;

public class no_9012 {
    //분류함수
    static String sort(String s) {
        char[] toChar = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();

        for (int j=0; j<toChar.length; j++) {
            if (toChar[j] == '('){
                stack.push('(');
            }
            else {
                if (stack.empty()){
                    stack.push(')');
                    return "NO";
                }
                else {
                    stack.pop();
                }
            }
        }

        if(stack.empty()) return "YES";
        else if (stack.peek() == ')') return "";
        else return "NO";
    }

    public static void main(String[] args) {
        int T; //String의 개수

        Scanner sc = new Scanner(System.in);
        System.out.println("개수 입력");
        T = sc.nextInt();

        String[] IN = new String[T];
        String[] OUT = new String[T];

        for (int i=0; i<T; i++) {
            String input = sc.next();
            IN[i] = input;
            OUT[i] = sort(IN[i]);
        }

        for (int i=0; i<T; i++) {
            System.out.println(OUT[i]);
        }

    }
}
