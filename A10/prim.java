package A10;

import java.io.*;
import java.util.*;

class edge{
    int w;
    int first;
    int second;

    edge(int w, int first, int second){
        this.w = w;
        this.first = first;
        this.second = second;

    }
}

class node{
    int value;
    boolean isVisited = false;
    ArrayList<edge> sons = new ArrayList<>();
}




public class prim{
    public static void main(String[] args) {
        Scanner input =  new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        node[] nodes = new node[n+1];
        for (int i = 0; i < n+1; i++) {
            nodes[i] = new node();
            nodes[i].value = i;
        }
        edge initial = new edge(10000001,0,0);

        for (int i = 0; i < m; i++) {
            int a = input.nextInt();
            int b = input.nextInt();
            int w = input.nextInt();
            edge temp = new edge(w,a,b);
            if (initial.w > temp.w){
                initial = temp;
            }
            nodes[a].sons.add(temp);
            nodes[b].sons.add(temp);
        }

        long sum = 0;

        nodes[initial.first].isVisited = true;
        nodes[initial.second].isVisited = true;
        sum += initial.w;

        Comparator<edge> sort = new Comparator<edge>() {
            @Override
            public int compare(edge o1, edge o2) {
                return o1.w - o2.w;
            }

        };

        PriorityQueue<edge> priorityQueue = new PriorityQueue<edge>(sort);



        for (int i = 0; i < nodes[initial.first].sons.size(); i++) {
            priorityQueue.add(nodes[initial.first].sons.get(i));
        }
        priorityQueue.addAll(nodes[initial.second].sons);
        edge search = priorityQueue.remove();

        int count = 1;

        while (count < n-1) {
            if (nodes[search.first].isVisited != nodes[search.second].isVisited) {
                sum += search.w;
                count++;
                if (!nodes[search.first].isVisited){
                    priorityQueue.addAll(nodes[search.first].sons);
                    nodes[search.first].isVisited = true;
                }
                else {
                    priorityQueue.addAll(nodes[search.second].sons);
                    nodes[search.second].isVisited = true;
                }
                search = priorityQueue.remove();
            }
            else {
                search = priorityQueue.remove();
            }
        }
        System.out.println(sum);



    }
}