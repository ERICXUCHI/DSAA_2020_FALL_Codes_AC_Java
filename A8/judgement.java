package A8;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class node{
    int val;
    node father;
    ArrayList<node> sons = new ArrayList<>();
    node(int i){
        val = i;
    }
}

public class judgement {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int case_number = input.nextInt();
        for (int i = 0; i < case_number; i++) {
            boolean binary = true;
            boolean result = true;
            int node_number = input.nextInt();
            node[] nodes = new node[node_number+1];
            for (int j = 1; j <= node_number; j++) {
                int value = input.nextInt();
                nodes[j] = new node(value);
            }
            for (int j = 0; j < node_number-1; j++) {
                int dad = input.nextInt();
                int sonny = input.nextInt();
                nodes[dad].sons.add(nodes[sonny]);
                nodes[sonny].father = nodes[dad];
            }

            node root = nodes[1];
            while (root.father != null){
                root = root.father;
            }

            Queue<node> queue = new LinkedList<>();
            int count = 0;
            queue.add(root);
            boolean larger = true;
            if (root.sons.size() != 0){
                int next = root.sons.get(0).val;
                if (next < root.val){
                    larger = false;
                }
            }

            boolean cur = true;
            while (!queue.isEmpty()){
                node tmp = queue.remove();

                if (count > 1){
                    binary = false;
                    result = false;
                    break;
                }
                if (tmp.sons.size() == 1){
                    count++;
                    if (tmp.sons.get(0).val < tmp.val){
                        cur = false;
                    }
                    if (cur != larger){
                        result = false;
                        break;
                    }
                    queue.addAll(tmp.sons);
                }
                else if (tmp.sons.size() > 2){
                    binary = false;
                    result = false;
                    break;
                }
                else {
                    if (tmp.sons.size() ==2 && count == 1) {
                        result = false;
                        break;
                    }
                    for (node j: tmp.sons) {
                        if (j.val < tmp.val){
                            cur = false;
                        }
                    }
                    if (cur != larger){
                        result = false;
                        break;
                    }

                    queue.addAll(tmp.sons);
                }
            }

            if (!result){
                System.out.println("Case #" + (i+1) + ": NO" );
            }
            else {
                System.out.println("Case #" + (i+1) + ": YES");
            }


        }
    }
}

