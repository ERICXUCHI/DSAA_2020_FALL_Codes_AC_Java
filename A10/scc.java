package A10;

import java.io.*;
import java.util.*;

class point{
    int val;
    int isVisited1 = 0;//1jinqu, 2chulai
    int isVisited2 = 0;
    ArrayList<point> sons = new ArrayList<>();
    ArrayList<point> sons1 = new ArrayList<>();
    point(int a){
        val = a;
    }
}

public class scc {

    static Stack<point> stack = new Stack<>();
    static ArrayList<Integer> arrayList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Reader input = new Reader();
        PrintWriter out = new PrintWriter(System.out);////////

        int n = input.nextInt();
        int m = input.nextInt();
        point[] points = new point[n + 1];

        for (int i = 0; i < n + 1; i++) {
            points[i] = new point(i);
        }
        for (int i = 0; i < m; i++) {
            int u = input.nextInt();
            int v = input.nextInt();
            points[v].sons.add(points[u]);
            points[u].sons1.add(points[v]);
        }

        DFS(points[1]);

        for (int i = 1; i <= n; i++) {
            if (points[i].isVisited1 != 2){
                System.out.println("wawawa");
                System.exit(0);
            }
        }

        stack.clear();


        ArrayList<Integer> arrayList1 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arrayList1.add(arrayList.get(n-1-i));
        }

        point starter = points[arrayList1.get(0)];

        DFS1(starter);

        for (int i = 1; i <= n; i++) {
            if (points[i].isVisited2 != 2){
                System.out.println("wawawa");
                System.exit(0);
            }
        }

        System.out.println("Bravo");

        out.close();////////
    }

    ////////Override methods

    static void DFS(point a) {
        stack.push(a);
        a.isVisited1 = 1;
        if (a.sons.size() == 0){
            point temp = stack.pop();
            temp.isVisited1 = 2;
            arrayList.add(temp.val);

        }
        else{
            for (int i = 0; i < a.sons.size(); i++) {
                if (a.sons.get(i).isVisited1 == 0) {
                    DFS(a.sons.get(i));
                }
            }
            point temp = stack.pop();
            temp.isVisited1 = 2;
            arrayList.add(temp.val);
        }
    }

    static void DFS1(point a) {
        stack.push(a);
        a.isVisited2 = 1;
        if (a.sons1.size() == 0){
            point temp = stack.pop();
            temp.isVisited2 = 2;
            arrayList.add(temp.val);
        }
        else{
            for (int i = 0; i < a.sons1.size(); i++) {
                if (a.sons1.get(i).isVisited2 == 0) {
                    DFS1(a.sons1.get(i));
                }
            }
            point temp = stack.pop();
            temp.isVisited2 = 2;
            arrayList.add(temp.val);
        }

    }
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