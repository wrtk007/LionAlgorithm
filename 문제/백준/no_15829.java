//1)문제
// 영문자 입력 -> 수열로 변환 가능. 정수로 치환. 적당히 큰 수 M. H = 시그마(ai*r^i) mod M
//2) 주어진 것들
// 입력 : 첫줄. 문자열의 길이 L. 둘째 줄, 영문 소문자로만 이루어진 문자열
// r=31, M=1234567891

//정수로 치환 : index + 1로 변경. -> 시그마값 만들기 -> mod M해서 리턴

import java.util.Scanner;

public class no_15829 {
    static int r = 31;
    static int M = 1234567891;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("문자열의 길이를 입력하시오. 최소 한 글자, 최대 다섯 글자 가능");
        int lenNum = sc.nextInt();
        System.out.print("문자열을 입력하시오. 앞서 입력한 문자열의 길이만큼 입력 가능");
        String lenStr = sc.next();

        char[] charStr = new char[lenNum];
        charStr = lenStr.toCharArray();

        hashing(intoNum(charStr));
    }

    //intoNum : 알파벳 문자열을 수열로 변환.
    public static int[] intoNum(char[] inputStr) {
        int[] charStr = new int [inputStr.length];
        for (int i=0; i<inputStr.length; i++) {
            switch (inputStr[i]) {
                case 'a' :
                    charStr[i] = 1;
                    break;
                case 'b' :
                    charStr[i] = 2;
                    break;
                case 'c' :
                    charStr[i] = 3;
                    break;
                case 'd' :
                    charStr[i] = 4;
                    break;
                case 'e' :
                    charStr[i] = 5;
                    break;
                case 'f' :
                    charStr[i] = 6;
                    break;
                case 'g' :
                    charStr[i] = 7;
                    break;
                case 'h' :
                    charStr[i] = 8;
                    break;
                case 'i' :
                    charStr[i]= 9;
                    break;
                case 'j' :
                    charStr[i] =10;
                    break;
                case 'k' :
                    charStr[i] =11;
                    break;
                case 'l' :
                    charStr[i]= 12;
                    break;
                case 'm' :
                    charStr[i] =13;
                    break;
                case 'n' :
                    charStr[i] =14;
                    break;
                case 'o' :
                    charStr[i] =15;
                    break;
                case 'p' :
                    charStr[i] =16;
                    break;
                case 'q' :
                    charStr[i]= 17;
                    break;
                case 'r' :
                    charStr[i] =18;
                    break;
                case 's' :
                    charStr[i] =19;
                    break;
                case 't' :
                    charStr[i] =20;
                    break;
                case 'u' :
                    charStr[i] =21;
                    break;
                case 'v' :
                    charStr[i] =22;
                    break;
                case 'w' :
                    charStr[i] = 23;
                    break;
                case 'x' :
                    charStr[i] = 24;
                    break;
                case 'y' :
                    charStr[i] = 25;
                    break;
                case 'z' :
                    charStr[i] = 26;
                    break;
                default:
                    break;
            }
        }
        return charStr;
    }

    //hashing : 문제에 따라 해싱함수 실행
    public static void hashing(int[] charStr) {
        int sum = 0;
        for (int i = 0; i < charStr.length; i++) {
            double multi = Math.pow(r,i);
            double now = (charStr[i]*multi)%M;
            sum += now;
        }
        System.out.println(sum);
    }

}
