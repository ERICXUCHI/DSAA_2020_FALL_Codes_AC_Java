package A9;

import java.util.*;

class Node{
    long degree;
    ArrayList<Integer> arrayList = new ArrayList<>();
}

public class paragraph {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int p_number = input.nextInt();
        int r_number = input.nextInt();
        Node[] nodes = new Node[p_number+1];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node();
        }
        nodes[0].degree = -1;

        for (int i = 0; i < r_number; i++) {
            int a = input.nextInt();
            int b = input.nextInt();
            nodes[b].degree++;
            nodes[a].arrayList.add(b);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        Node root = null;

        for (int i = 1; i <= p_number; i++) {
            if (nodes[i].degree == 0){
                queue.add(i);
            }
        }

        while (!queue.isEmpty()){
            int start = queue.remove();
            for (int i = 0; i < nodes[start].arrayList.size(); i++) {
                int index = nodes[start].arrayList.get(i);
                nodes[index].degree--;
                if (nodes[index].degree == 0){
                    queue.add(index);
                }
            }
            System.out.print(start + " ");
        }


    }
}
