package A10;

import java.io.*;
import java.util.*;

class node0{
    int value;
    boolean isVisited = false;
    ArrayList<edge0> sons = new ArrayList<>();
    node0(int a){
        value = a;
    }
}

class edge0{
    int w;
    node0 first;
    node0 second;

    edge0(int w, node0 first, node0 second){
        this.w = w;
        this.first = first;
        this.second = second;

    }
}

public class game {


    public static void main(String[] args) throws IOException {
        Reader input = new Reader();
        PrintWriter out = new PrintWriter(System.out);////////
        int n = input.nextInt();
        int m = input.nextInt();
        node0[][] matrix = new node0[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = new node0(input.nextInt());
            }
        }

        edge0 initial = new edge0(-Integer.MAX_VALUE,matrix[0][0],matrix[0][0]);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m-1; j++) {
                edge0 temp = new edge0(matrix[i][j].value*matrix[i][j+1].value,matrix[i][j],matrix[i][j+1]);
                if (initial.w < temp.w){
                    initial = temp;
                }
                matrix[i][j].sons.add(temp);
                matrix[i][j+1].sons.add(temp);
            }
        }

        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n-1; i++) {
                edge0 temp = new edge0(matrix[i][j].value*matrix[i+1][j].value,matrix[i][j],matrix[i+1][j]);
                if (initial.w < temp.w){
                    initial = temp;
                }
                matrix[i][j].sons.add(temp);
                matrix[i+1][j].sons.add(temp);
            }
        }
        long sum = 0;

        initial.first.isVisited = true;
        initial.second.isVisited = true;
        sum += initial.w;

        Comparator<edge0> sort = new Comparator<edge0>() {
            @Override
            public int compare(edge0 o1, edge0 o2) {
                return o2.w - o1.w;
            }

        };

        PriorityQueue<edge0> priorityQueue = new PriorityQueue<edge0>(sort);


        priorityQueue.addAll(initial.first.sons);
        priorityQueue.addAll(initial.second.sons);
        edge0 search = priorityQueue.remove();

        int count = 1;

        while (search.w > 0) {
            if (search.first.isVisited != search.second.isVisited) {
                sum += search.w;
                count++;
                if (!search.first.isVisited){
                    priorityQueue.addAll(search.first.sons);
                    search.first.isVisited = true;
                }
                else {
                    priorityQueue.addAll(search.second.sons);
                    search.second.isVisited = true;
                }
                search = priorityQueue.remove();
            }
            else {
                if (!priorityQueue.isEmpty()) {
                    search = priorityQueue.remove();
                }
                else {
                    break;
                }
            }
        }
        System.out.println(sum);


        out.close();////////
    }

    ////////Override methods


    ////////

    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }
    }

}