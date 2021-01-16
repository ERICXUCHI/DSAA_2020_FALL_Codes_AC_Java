package A6;

import java.util.Scanner;

public class judge {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int result = 0;
        int number = in.nextInt();
        String[] strings = new String[number];
        for (int i = 0; i < number; i++) {
            strings[i] = in.next();
        }

        int questions_num = in.nextInt();
        for (int i = 0; i < questions_num; i++) {
            int first = in.nextInt();
            int second = in.nextInt();
            String judge = in.next();

            String temp1 = strings[first-1] + "&" + strings[second-1];
            String temp2 = strings[second-1] + "&" + strings[first-1];

            int firstRes = max(temp1);
            int secondRes = max(temp2);
            if (firstRes == secondRes && judge.equals("=")){
                result++;
            }
            else if (firstRes > secondRes && judge.equals(">")){
                result++;
            }
            else if (firstRes < secondRes && judge.equals("<")){
                result++;
            }

        }
        System.out.println(result);

    }

    static int max(String temp){

        int length = temp.length();
        int[] result = new int[length];
        result[0] = 0;
        int k = 0;
        int j = 1;
        while (j < length){
            if (temp.charAt(j) == temp.charAt(k)){
                k++;
                result[j] = k;
                j++;
            }
            else if (k == 0){
                result[j] = 0;
                j++;
            }
            else {
                k = result[k-1];
            }

        }

        return result[length-1];

    }
}

