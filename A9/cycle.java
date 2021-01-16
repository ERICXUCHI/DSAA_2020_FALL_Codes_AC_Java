package A9;

import java.util.*;

class node{
    int val;
    long degree;
    ArrayList<Integer> arrayList = new ArrayList<>();
}
public class cycle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();
        int nodes = input.nextInt();
        int edges = input.nextInt();
        node[] array = new node[nodes+1];
        for (int i = 0; i < array.length; i++) {
            array[i] = new node();
        }
        for (int i = 0; i < edges; i++) {
            int a = input.nextInt();
            int b = input.nextInt();
            array[a].degree++;
            array[a].arrayList.add(b);
            array[b].degree++;
            array[b].arrayList.add(a);
        }
        for (int i = 1; i <= nodes; i++) {
            if (array[i].degree <= 1){
                queue.add(i);
            }
        }
        int cnt = 0;
        while (!queue.isEmpty()){
            cnt++;
            int tmp = queue.remove();
            for (int i = 0; i < array[tmp].arrayList.size(); i++) {
                int index = array[tmp].arrayList.get(i);
                array[index].degree--;
                if (array[index].degree == 1) {
                    queue.add(index);
                }
            }
            }

        if (cnt == nodes){
            System.out.println("Good");
        }
        else {
            System.out.println("Bad");
        }
    }
}
