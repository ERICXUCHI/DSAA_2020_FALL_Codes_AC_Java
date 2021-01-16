package A7;

import java.util.*;

class node {
    int index;
    ArrayList<Integer> arrayList = new ArrayList<>();
    boolean friend = false;
    boolean traversed = false;

    node(int i){
        index = i;
    }
}

public class k_travel {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int case_number = input.nextInt();
        for (int i = 0; i < case_number; i++) {
            int signal = 0;
            int city_number = input.nextInt();
            int friend_number = input.nextInt();
            node[] nodes = new node[city_number+1];
            for (int j = 0; j < city_number+1; j++) {
                nodes[j] = new node(j);
            }
            for (int j = 0; j < city_number - 1; j++) {
                int a = input.nextInt();
                int b = input.nextInt();
                nodes[a].arrayList.add(b);
                nodes[b].arrayList.add(a);
            }
            //HashMap<Integer, Integer> hashMap = new HashMap<>();
            for (int j = 0; j < friend_number; j++) {
                int a = input.nextInt();
                //hashMap.put(a, j);
                nodes[a].friend = true;
                signal = a;
            }

            node root = nodes[signal];
            root.traversed = true;
            Queue<Integer> queue = new LinkedList<>(root.arrayList);

            node now = null;
            node temp = null;
            int a = 0;
            int b = 0;

            while (!queue.isEmpty()) {
                int tmp = queue.remove();
                nodes[tmp].traversed = true;
                if (nodes[tmp].arrayList.size() == 1 && (!nodes[tmp].friend) && nodes[nodes[tmp].arrayList.get(0)].traversed) {

                    b = nodes[tmp].arrayList.get(0);
                    temp = nodes[nodes[tmp].arrayList.get(0)];
                    a = temp.arrayList.indexOf(tmp);
                    temp.arrayList.remove(a);
                    nodes[tmp] = null;

                    while (temp.arrayList.size() == 1 && (!temp.friend) && nodes[temp.arrayList.get(0)].traversed){

                        now = nodes[temp.arrayList.get(0)];
                        a = now.arrayList.indexOf(b);
                        now.arrayList.remove(a);
                        temp = now;
                        nodes[b] = null;
                        b = temp.index;

                    }



                } else {
                    for (int j = 0; j < nodes[tmp].arrayList.size(); j++) {
                        if (!nodes[nodes[tmp].arrayList.get(j)].traversed) {
                            queue.add(nodes[tmp].arrayList.get(j));
                        }
                    }
                }
            }
////////////////////////////////////////////////
            int cnt1 = 0;
            int cnt2 = 0;

            if (root.arrayList.size() == 0) {
                cnt1 = 0;
            } else {
                queue.addAll(root.arrayList);
                queue.add(-1);
                root.traversed = false;
                while (!queue.isEmpty()) {
                    int tmp = queue.remove();
                    if (tmp == -1) {
                        queue.add(-1);
                        cnt1++;
                        tmp = queue.remove();
                        if (tmp == -1) {
                            break;
                        } else {
                            nodes[tmp].traversed = false;
                        }
                    } else {
                        nodes[tmp].traversed = false;
                    }


                    root = nodes[tmp];

                    if (nodes[tmp].arrayList != null) {
                        for (int i1 : nodes[tmp].arrayList) {
                            if (nodes[i1].traversed) {
                                queue.add(i1);
                            }
                        }

                    }

                }
            }

////////////////////////////////////
            if (root.arrayList.size() == 0) {
                cnt2 = 0;
            } else {
                queue.addAll(root.arrayList);
                queue.add(-1);
                root.traversed = true;
                while (!queue.isEmpty()) {
                    int tmp = queue.remove();
                    if (tmp == -1) {
                        queue.add(-1);
                        cnt2++;
                        tmp = queue.remove();
                        if (tmp == -1) {
                            break;
                        } else {
                            nodes[tmp].traversed = true;
                        }
                    } else {
                        nodes[tmp].traversed = true;
                    }

                    if (nodes[tmp].arrayList != null) {
                        for (int i1 : nodes[tmp].arrayList) {
                            if (!nodes[i1].traversed) {
                                queue.add(i1);
                            }
                        }

                    }

                }
            }
            if (cnt1 >= cnt2) {
                System.out.println((cnt1 + 1) / 2);
            } else {
                System.out.println((cnt2 + 1) / 2);
            }
        }
    }
}
