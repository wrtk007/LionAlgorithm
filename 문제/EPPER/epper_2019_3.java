import java.util.*;

public class epper_2019_3 {

    public static void main (String args[]){

        Scanner sc = new Scanner(System.in);

        String a = "What";
        String b = "Ewha";

        a = a.toLowerCase();
        b = b.toLowerCase();

        char[] chara = a.toCharArray();
        char[] charb = b.toCharArray();

        Arrays.sort(chara);
        Arrays.sort(charb);

        if (Arrays.equals(chara, charb)) {
            System.out.println("T");
        }
        else {
            System.out.println("F");
        }
    }

}

