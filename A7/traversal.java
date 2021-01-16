package A7;

import java.io.*;
import java.util.*;

class treenode{
    ArrayList<Long> treeNodes = new ArrayList<>();
}

public class traversal {
    static int max = 100005;

    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);

        int case_number = input.nextInt();


        for (int i = 0; i < case_number; i++) {
            treenode[] treenodes = new treenode[max];
            int n = input.nextInt();
            treenodes[1] = new treenode();


            for (int j = 0; j < max; j++) {
                treenodes[j] = new treenode();
            }

            for (int j = 1; j < n; j++) {
                int cur = input.nextInt();
                int new_key = j + 1;
                treenodes[cur].treeNodes.add((long) new_key);
            }


            System.out.print(1 + " ");

            ArrayList<Long> arrayList = treenodes[1].treeNodes;

            Collections.sort(arrayList);

            Queue<Long> queue = new LinkedList<>(arrayList);

            while (!queue.isEmpty()) {

                long tmp = queue.remove();

                if (queue.isEmpty() && treenodes[(int) tmp].treeNodes == null) {
                    System.out.print(tmp);
                } else {
                    System.out.print(tmp + " ");
                }

                if (treenodes[(int) tmp] != null) {
                    arrayList = treenodes[(int) tmp].treeNodes;
                    Collections.sort(arrayList);
                    queue.addAll(arrayList);
                }
            }
            System.out.println();


        }

        System.out.close();
    }

}