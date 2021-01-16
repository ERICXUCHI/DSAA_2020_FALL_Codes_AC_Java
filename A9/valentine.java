package A9;

import java.io.*;
import java.util.*;

class NODE{
    int val = 0;
    ArrayList<Integer> arrayList = new ArrayList<>();
    ArrayList<Integer> weight = new ArrayList<>();
    long distance = Long.MAX_VALUE-1;
    NODE father = null;
    //boolean visited = false;
}



public class valentine {
    public static void main(String[] args) throws IOException {
        Reader input = new Reader();
        PrintWriter out = new PrintWriter(System.out);////////
        int city_number = input.nextInt();
        int road_number = input.nextInt();
        NODE[] nodes = new NODE[city_number+1];
        boolean[] booleans = new boolean[city_number+1];

        for (int i = 0; i <= city_number; i++) {
            nodes[i] = new NODE();
            nodes[i].val = i;
            booleans[i] = false;
        }
        for (int i = 0; i < road_number; i++) {
            int a = input.nextInt();
            int b = input.nextInt();
            int w = input.nextInt();
            nodes[a].arrayList.add(b);
            nodes[a].weight.add(w);

        }



        Comparator<NODE> sort = new Comparator<NODE>() {
            @Override
            public int compare(NODE o1, NODE o2) {
                int r =  Long.compare(o1.distance,o2.distance);
                return r;
            }

        };

        PriorityQueue<NODE> priorityQueue = new PriorityQueue<>(sort);
        nodes[1].distance = 0;

        priorityQueue.add(nodes[1]);

        while (!priorityQueue.isEmpty()){
            NODE tmp = priorityQueue.remove();

            if (booleans[tmp.val]){
                continue;
            }

            booleans[tmp.val] = true;

            int size = tmp.arrayList.size();
            for (int i = 0; i < size; i++) {
                int index = tmp.arrayList.get(i);
                if (!booleans[index] && tmp.distance + tmp.weight.get(i) < nodes[index].distance) {
                    priorityQueue.remove(nodes[index]);

                    nodes[index].distance = tmp.distance+ tmp.weight.get(i);

                    priorityQueue.add(nodes[index]);
                }
            }
        }

        if (nodes[city_number].distance == Long.MAX_VALUE-1){
            System.out.println(-1);
        }
        else {
            System.out.println(nodes[city_number].distance);
        }


        out.close();////////
    }

    ////////Override



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