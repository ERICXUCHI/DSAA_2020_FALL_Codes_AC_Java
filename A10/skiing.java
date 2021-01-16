package A10;

import java.util.*;

class NODE{
    int height = 0;
    double velocity = 1;
    int x = 0;
    int y = 0;
    ArrayList<NODE> arrayList = new ArrayList<>();
    ArrayList<Double> weight = new ArrayList<>();
    boolean isVisited = false;
    double time = Double.MAX_VALUE;
    NODE(int a, int i, int j){
        height = a;
        x = i;
        y = j;
    }
}

public class skiing {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        NODE[][] matrix = new NODE[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = new NODE(input.nextInt(), i, j);
                double v = (double) 1/Math.pow(2,matrix[0][0].height-matrix[i][j].height);
                for (int k = 0; k < 4; k++) {
                    matrix[i][j].weight.add(v);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m-1; j++) {
                matrix[i][j].arrayList.add(matrix[i][j+1]);
                matrix[i][j+1].arrayList.add(matrix[i][j]);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n-1; j++) {
                matrix[j][i].arrayList.add(matrix[j+1][i]);
                matrix[j+1][i].arrayList.add(matrix[j][i]);
            }
        }



        Comparator<NODE> sort = new Comparator<NODE>() {
            @Override
            public int compare(NODE o1, NODE o2) {
                return Double.compare(o1.time, o2.time);
            }
        };

        matrix[0][0].time = 0;


        PriorityQueue<NODE> priorityQueue = new PriorityQueue<>(sort);
        priorityQueue.add(matrix[0][0]);



        while (!priorityQueue.isEmpty()) {
            NODE temp = priorityQueue.remove();
            if (temp.isVisited) {
                continue;
            }
            temp.isVisited = true;

            for (int i = 0; i < temp.arrayList.size(); i++) {
                NODE index = temp.arrayList.get(i);
                if (!index.isVisited && temp.time + temp.weight.get(i) < index.time) {
                    priorityQueue.remove(index);
                    index.time = temp.time + temp.weight.get(i);
                    priorityQueue.add(index);
                }
            }
        }

        System.out.printf("%.2f",matrix[n-1][m-1].time);
    }
}
