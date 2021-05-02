//문제
//        괄호 문자열(Parenthesis String, PS)은 두 개의 괄호 기호인 ‘(’ 와 ‘)’ 만으로 구성되어 있는 문자열이다.
//        그 중에서 괄호의 모양이 바르게 구성된 문자열을 올바른 괄호 문자열(Valid PS, VPS)이라고 부른다.
//        한 쌍의 괄호 기호로 된 “( )” 문자열은 기본 VPS 이라고 부른다.
//        만일 x 가 VPS 라면 이것을 하나의 괄호에 넣은 새로운 문자열 “(x)”도 VPS 가 된다.
//        그리고 두 VPS x 와 y를 접합(concatenation)시킨 새로운 문자열 xy도 VPS 가 된다.
//        예를 들어 “(())()”와 “((()))” 는 VPS 이지만 “(()(”, “(())()))” ,
//        그리고 “(()” 는 모두 VPS 가 아닌 문자열이다.
//
//        여러분은 입력으로 주어진 괄호 문자열이 VPS 인지 아닌지를 판단해서 그 결과를 YES 와 NO 로 나타내어야 한다.
//
//입력
//        입력 데이터는 표준 입력을 사용한다. 입력은 T개의 테스트 데이터로 주어진다.
//        입력의 첫 번째 줄에는 입력 데이터의 수를 나타내는 정수 T가 주어진다.
//        각 테스트 데이터의 첫째 줄에는 괄호 문자열이 한 줄에 주어진다.
//        하나의 괄호 문자열의 길이는 2 이상 50 이하이다.


import java.util.*;
import java.io.*;

public class BJ_9012 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
//            입력받은 괄호를 char로 쪼개서 vps 배열에 넣음
            char[] vps = st.nextToken().toCharArray();
//            vps 배열의 마지막 원소인지 확인하는 boolean 변수
            boolean end = false;

            Stack<Character> stack = new Stack<>();

            for (int j = 0; j < vps.length; j++) {
//                마지막 원소일 경우 end를 true로 바꿈
                if (j == vps.length-1) {
                    end = true;
                }

//               case 1~4) 마지막 vps 원소인 경우
                if (end == true) {
//              case 1) '('일 때 [( > )]
                    if ( vps[j] == '(') {
                        stack.push('(');
                        sb.append("NO\n");
                        break;
                    }
//                    case 2~4) ')'인 경우
                    else {
//                        case 2) 스택이 비어서 pop할 것이 없음 [( < )]
                        if (stack.isEmpty()) {
                            sb.append("NO\n");
                            break;
                        }
                        else {
//                            case 3&4) 스택이 비지 않아서 pop 가능
                            stack.pop();
//                            case 3) pop한 이후 스택이 비어서 vps 인 경우
                            if (stack.isEmpty()) {
                                sb.append("YES\n");
                            }
//                            case 4) pop한 이후에도 스택이 비지 않음 [( > )]
                            else {
                                sb.append("NO\n");
                                break;
                            }
                        }
                    }
                }
//                case 5~7) 마지막 vps 원소 아닌 경우
                else {
//                    case 5) '(' push
                    if (vps[j] == '(') {
                        stack.push('(');
                    }
//                    case 6&7) ')' pop
                    else {
//                        case 6) 스택이 비어서 pop 불가 [( < )]
                        if (stack.isEmpty()) {
                            sb.append("NO\n");
                            break;
                        }
                        else {
//                          case 7) 스택 비지 않아서 pop 가능
                            stack.pop();
                        }
                    }
                }
            }
        }
        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
