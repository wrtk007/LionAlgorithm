import java.util.*;

//막대기
public class no_1094 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int myStick = sc.nextInt();
        int stick = 64;
        int count = 0;

        //막대기 쪼갤 때 0보다 클 때까지
        while (myStick > 0) {
            if (stick > myStick) {
                stick /= 2;
            } else {
                myStick -= stick;
                count++;
            }
        }

        System.out.println(count);
    }

}

//비트카운터로 해결
