package A2;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class triple {
    public static void main(String[] args) {
        Scanner x_input = new Scanner(System.in);
        int xl = x_input.nextInt();
        long x_goal = x_input.nextLong();
        long[] x_array = new long[xl];
        long counter = 0;
        for (int i = 0; i < xl; i++) {
            x_array[i] = x_input.nextLong();
        }
        Map<Long, Long> x_map = new HashMap<Long, Long>();
        for (int i = 0; i < xl; i++) {
            if (x_map.containsKey(x_array[i])){
                long x_temp = x_map.get(x_array[i]);
                x_map.put(x_array[i], x_temp+1);
            }
            else {
                x_map.put(x_array[i], (long)1);
            }
        }


        for (int i = 0; i < xl; i++) {
            long a = x_goal - x_array[i];
            for (int j = i+1; j < xl; j++) {
                long b = x_array[j];
                long c = a - b;
                if (x_map.containsKey(c)){
                    if (x_array[i] == b && b == c){
                        counter = counter + x_map.get(c) - 2;
                    }
                    else if (c == b && x_map.get(c) == 1) {
                        ;
                    }
                    else if (c == x_array[i] && x_map.get(c) == 1){
                        ;
                    }
                    else if(c == b && x_map.get(c) != 1) {
                        counter = counter + x_map.get(c) - 1;
                    }
                    else if (c == x_array[i] && x_map.get(c) != 1){
                        counter = counter + x_map.get(c) - 1;
                    }
                    else {
                        counter = counter + x_map.get(c);
                    }
                }

            }
        }
        System.out.println(counter / 3);
    }
}
