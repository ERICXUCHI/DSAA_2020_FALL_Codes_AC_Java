package A9;

import java.util.*;

class dot{
    int val;
    boolean visited1 = false;
    boolean visited2 = false;
    boolean a = false;
    boolean b = false;
    ArrayList<Integer> sons = new ArrayList<>();
}

public class tower {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int a = input.nextInt();
        int b = input.nextInt();
        dot[] dots = new dot[n+1];
        for (int i = 0; i < n+1; i++) {
            dots[i] = new dot();
            dots[i].val = i;
        }
        for (int i = 0; i < m; i++) {
            int u = input.nextInt();
            int v = input.nextInt();
            dots[u].sons.add(v);
            dots[v].sons.add(u);
        }
        dots[a].visited1 = true;
        Queue<dot> queue1 = new LinkedList();
        queue1.add(dots[b]);
        while (!queue1.isEmpty()){

            dot temp = queue1.remove();
            temp.visited1 = true;
            temp.a = true;
            for (int i = 0; i < temp.sons.size(); i++) {
                if (!dots[temp.sons.get(i)].visited1){
                    queue1.add(dots[temp.sons.get(i)]);
                }
            }
        }

        dots[b].visited2 = true;
        Queue<dot> queue2 = new LinkedList<>();
        queue2.add(dots[a]);
        while (!queue2.isEmpty()){
            dot temp = queue2.remove();
            temp.visited2 = true;
            temp.b = true;
            for (int i = 0; i < temp.sons.size(); i++) {
                if (!dots[temp.sons.get(i)].visited2){
                    queue2.add(dots[temp.sons.get(i)]);
                }
            }
        }

        int cnt1 = 0,cnt2 = 0;
        for (int i = 0; i < dots.length; i++) {
            if (i != a && i != b && dots[i].a && !dots[i].b){
                cnt1++;
            }
            if (i != a && i != b && dots[i].b && !dots[i].a){
                cnt2++;
            }
        }
        System.out.println(cnt1*cnt2);

    }
}
