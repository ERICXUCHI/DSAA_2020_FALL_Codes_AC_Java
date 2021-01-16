package A8;

import java.util.ArrayList;
import java.util.Scanner;

public class adoption {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        long total_number = input.nextLong();
        ArrayList<Long> pet = new ArrayList<>();
        ArrayList<Long> adopter = new ArrayList<>();
        ArrayList<Long> point1 = new ArrayList<>();
        ArrayList<Long> point2 = new ArrayList<>();

        long sum = 0;

        for (int i = 0; i < total_number; i++) {
            long sig = input.nextLong();
            long value = input.nextLong();

            if (sig == 0){
                if (adopter.size() != 0){
                    long cur = adopter.get(0);
                    long min = Math.abs(cur - value);
                    for (long j :adopter) {
                        if (Math.abs(j-value) < min){
                            cur = j;
                            min = Math.abs(cur - value);
                        }
                        else if (Math.abs(j-value) == min && j < cur){
                            cur = j;
                            min = Math.abs(cur - value);
                        }
                    }
                    sum += min;
                    long index = adopter.indexOf(cur);
                    adopter.remove(cur);
                }
                else {
                    pet.add(value);
                }
            }
            else {
                if (pet.size() != 0){
                    long cur = pet.get(0);
                    long min = Math.abs(cur - value);
                    for (long j :pet) {
                        if (Math.abs(j-value) < min){
                            cur = j;
                            min = Math.abs(cur - value);
                        }
                        else if (Math.abs(j-value) == min && j < cur){
                            cur = j;
                            min = Math.abs(cur - value);
                        }
                    }
                    sum += min;
                    long index = pet.indexOf(cur);
                    pet.remove(cur);
                }
                else {
                    adopter.add(value);
                }
            }

        }
        System.out.println(sum);


    }
}
