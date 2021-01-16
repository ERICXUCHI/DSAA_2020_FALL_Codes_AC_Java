package A4;

import java.io.*;

class lNode {
    long value;
    long index;
    boolean being;
    lNode pre;
    lNode next;

    public lNode(long x, long y) {
        value = x;
        index = y;
        being = true;
    }
}

public class descreasing {
    public static void main(String[] args) throws IOException {
        Reader x_input = new Reader();
        PrintWriter out = new PrintWriter(System.out);////////////////////////////////////////////////////////THERE STARTS!!!

        long max = 100010;
        int case_num = x_input.nextInt();
        for (int i = 0; i < case_num; i++) {
            boolean goon = false;
            int xn = x_input.nextInt();

            long[] headNodes = new long[xn + 2];
            headNodes[0] = xn+1;
            headNodes[xn + 1] = xn+1;
            lNode[] lNodes = new lNode[xn + 2];
            lNodes[0] = new lNode(0, 0);
            lNodes[xn + 1] = new lNode(max, xn + 1);
            for (int j = 1; j <= xn; j++) {
                headNodes[j] = xn+1;
                lNodes[j] = new lNode(x_input.nextLong(), j);
                lNodes[j].pre = lNodes[j - 1];
                lNodes[j-1].next = lNodes[j];
            }
            lNodes[xn].next = lNodes[xn+1];
            lNodes[xn + 1].pre = lNodes[xn];

            lNode cur = lNodes[1];
            lNode point1 = null;
            lNode point2 = null;
            int now_point = 0;

            while (cur.value != max) {
                if (cur.next.value < cur.value) {
                    goon = true;
                    point1 = cur;
                    cur.being = false;
                    cur = cur.next;
                    while (cur.next.value < cur.value) {
                        cur = cur.next;
                        cur.being = false;
                    }
                    point2 = cur;
                    point1.pre.next = point2.next;
                    point2.next.pre = point1.pre;
                    headNodes[now_point] = point1.pre.index;
                    now_point++;
                    cur = cur.next;
                } else {
                    cur = cur.next;
                }
            }

            if (!goon){
                for (int j = 1; j < xn; j++) {
                    System.out.print(lNodes[j].value + " ");
                }
                System.out.print(lNodes[xn].value);
                System.out.println();

            }


            if (goon && point1.index == 1 && point2.index == xn){
                System.out.println();
                goon = false;
            }

            while (goon){
                goon = false;
                now_point = 0;
                int new_point = 0;
                cur = lNodes[(int) headNodes[now_point]];

                while (cur.value != max) {

                    if (cur.next.value < cur.value) {
                        goon = true;
                        point1 = cur;
                        cur.being = false;
                        cur = cur.next;
                        cur.being = false;
                        while (cur.next.value < cur.value) {
                            cur = cur.next;
                            cur.being = false;
                        }
                        point2 = cur;
                        point1.pre.next = point2.next;
                        point2.next.pre = point1.pre;

                        now_point++;
                        while (headNodes[now_point]!= xn+1 && headNodes[now_point-1] == headNodes[now_point]){
                            headNodes[now_point-1] = xn+1;
                            now_point++;
                        }
                        headNodes[now_point-1] = xn+1;

                        while (!lNodes[(int) headNodes[now_point]].being){
                            headNodes[now_point] = xn+1;
                            now_point++;
                        }
                        headNodes[new_point] = point1.pre.index;
                        new_point++;
                        cur = lNodes[(int) headNodes[now_point]];


                    }
                    else {
                        now_point++;
                        cur = lNodes[(int) headNodes[now_point]];
                    }
                }

                if (!goon) {
                    cur = lNodes[0];
                    while (cur.next.value != max) {
                        cur = cur.next;
                        System.out.print(cur.value + " ");
                    }
                    System.out.println();
                }

                if (goon && point1.index == 1 && point2.index == xn){
                    System.out.println();
                    goon = false;
                }

            }


        }



        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////THERE END!!!
        out.close();
    }



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