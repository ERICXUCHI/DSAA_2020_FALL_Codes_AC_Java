package A7;

import java.util.*;

public class stickCutting {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int case_number = input.nextInt();
        for (int i = 0; i < case_number; i++) {
            int number = input.nextInt();
            ArrayList<Integer> arrayList = new ArrayList<>(number);
            for (int j = 0; j < number; j++) {
                arrayList.add(input.nextInt());
            }
            int sum = 0;


            while (arrayList.size() != 1){
                Collections.sort(arrayList);
                int a = arrayList.remove(0);
                sum += a;
                int b = arrayList.remove(0);
                sum += b;
                int c = a + b;
                arrayList.add(c);
            }

            System.out.println(sum);



        }
    }
}
