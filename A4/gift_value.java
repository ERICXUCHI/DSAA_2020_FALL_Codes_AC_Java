package A4;
import java.io.*;
import java.util.*;

class Node {
    long val;
    long index;
    long new_order;
    Node pre;
    Node next;
    Node(long x, long y) {
        val = x;
        index = y;
        new_order = 0;
    }
    Node(long x, long y, long z) {
        val = x;
        index = y;
        new_order = z;
    }
}

public class gift_value {
    static long[][] x_array;

    public static void main(String[] args) throws IOException {
        Reader x_input = new Reader();
        PrintWriter out = new PrintWriter(
                System.out); ////////////////////////////////////////////////////////THERE STARTS!!!

        long xt = x_input.nextLong();

        for (int i = 0; i < xt; i++) {
            long xn = x_input.nextLong();
            long readNumber = ((xn - 1) / 2) * 2 + 1;
            Node[] nodes = new Node[(int) readNumber + 2];
            x_array = new long[(int) readNumber + 2][3];

            nodes[0] = new Node(-1, 0);
            nodes[nodes.length - 1] = new Node(Long.MAX_VALUE, nodes.length - 1);

            for (int j = 1; j <= readNumber; j++) {
                nodes[j] = new Node(x_input.nextLong(), j);
            }

            merge_sort(nodes, nodes.length);

//            for (int j = 0; j < readNumber + 2; j++) {
//                x_array[j][0] = nodes[j].val;
//                x_array[j][1] = nodes[j].index;
//            }

            //            merge_sort1(x_array, x_array.length);

            nodes[0].next = nodes[1];
            for (int j = 1; j < nodes.length - 1; j++) {
                nodes[j].next = nodes[j + 1];
                nodes[j].pre = nodes[j - 1];
            }
            nodes[nodes.length - 1].pre = nodes[nodes.length - 2];

            long[] result = new long[(int) ((readNumber + 1) / 2)];

            Node pointer = nodes[0].next;

            for (int k = 0; k < readNumber / 2; k++) {
                pointer = pointer.next;
            }
            result[0] = pointer.val;

            for (int j = 1; j < (xn + 1) / 2; j++) {
                int pos = 0;
                nodes[(int) x_array[(int) readNumber][2]].pre.next =
                        nodes[(int) x_array[(int) readNumber][2]].next;
                nodes[(int) x_array[(int) readNumber][2]].next.pre =
                        nodes[(int) x_array[(int) readNumber][2]].pre;
                if (nodes[(int) x_array[(int) readNumber][2]].val > pointer.val) {
                    pos++;
                } else if (nodes[(int) x_array[(int) readNumber][2]].val < pointer.val) {
                    pos--;
                }
                readNumber--;

                nodes[(int) x_array[(int) readNumber][2]].pre.next =
                        nodes[(int) x_array[(int) readNumber][2]].next;
                nodes[(int) x_array[(int) readNumber][2]].next.pre =
                        nodes[(int) x_array[(int) readNumber][2]].pre;
                if (nodes[(int) x_array[(int) readNumber][2]].val > pointer.val) {
                    pos++;
                } else if (nodes[(int) x_array[(int) readNumber][2]].val < pointer.val) {
                    pos--;
                }
                readNumber--;

                if (pos == 0) {
                    result[j] = pointer.val;
                } else if (pos == 1 || pos == 2) {
                    pointer = pointer.pre;
                    result[j] = pointer.val;
                } else if (pos == -1 || pos == -2) {
                    pointer = pointer.next;
                    result[j] = pointer.val;
                }
            }

            for (int j = 1; j < result.length; j++) {
                System.out.print(result[result.length - j] + " ");
            }
            System.out.print(result[0]);
            System.out.println();
        }

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////THERE
        ///END!!!
        out.close();
    }

    static Node[] merge_sort(Node[] parameter, long xn) {
        if (xn > 1) {
            long p = xn / 2;
            Node[] x_temp1 = new Node[(int) p];
            Node[] x_temp2 = new Node[(int) (xn - p)];
            for (int i = 0; i < p; i++) {
                x_temp1[i] = new Node(parameter[i].val, parameter[i].index);
            }
            for (int i = (int) p; i < xn; i++) {
                x_temp2[(int) (i - p)] = new Node(parameter[i].val, parameter[i].index);
            }
            merge_sort(x_temp1, p);
            merge_sort(x_temp2, xn - p);
            Node[] temp = merge(x_temp1, p, x_temp2, xn - p);
            for (int i = 0; i < xn; i++) {
                parameter[i] = new Node(temp[i].val, temp[i].index, i);
                x_array[(int) temp[i].index][2] = i;
            }
        }
        return parameter;
    }

    static Node[] merge(Node[] x_temp1, long nl, Node[] x_temp2, long nr) {
        long n = nl + nr;
        Node[] a_array = new Node[(int) n];
        int i = 0;
        int j = 0;
        for (int k = 0; k < n; k++) {
            if (i < nl && (j > nr - 1 || x_temp1[i].val <= x_temp2[j].val)) {
                a_array[k] = new Node(x_temp1[i].val, x_temp1[i].index);
                i++;
            }

            else {
                a_array[k] = new Node(x_temp2[j].val, x_temp2[j].index);

                j++;
            }
        }
        return a_array;
    }

    //    static long[][] merge_sort1(long[][] parameter, long xn) {
    //        if (xn > 1) {
    //            long p = xn / 2;
    //            long[][] x_temp1 = new long[(int) p][3];
    //            long[][] x_temp2 = new long[(int) (xn - p)][3];
    //            for (int i = 0; i < p; i++) {
    //                x_temp1[i][0] = parameter[i][0];
    //                x_temp1[i][1] = parameter[i][1];
    //                x_temp1[i][2] = parameter[i][2];
    //            }
    //            for (int i = (int) p; i < xn; i++) {
    //                x_temp2[(int) (i - p)][0] = parameter[i][0];
    //                x_temp2[(int) (i - p)][1] = parameter[i][1];
    //                x_temp2[(int) (i - p)][2] = parameter[i][2];
    //            }
    //            merge_sort1(x_temp1, p);
    //            merge_sort1(x_temp2, xn - p);
    //            long[][] temp = merge1(x_temp1, p, x_temp2, xn - p);
    //            for (int i = 0; i < xn; i++) {
    //                parameter[i][0] = temp[i][0];
    //                parameter[i][1] = temp[i][1];
    //                parameter[i][2] = temp[i][2];
    //            }
    //        }
    //        return parameter;
    //    }
    //
    //    static long[][] merge1(long[][] x_temp1, long nl, long[][] x_temp2, long nr) {
    //        long n = nl + nr;
    //        long[][] a_array = new long[(int) n][3];
    //        int i = 0;
    //        int j = 0;
    //        for (int k = 0; k < n; k++) {
    //            if (i < nl && (j > nr - 1 || x_temp1[i][1] <= x_temp2[j][1])) {
    //                a_array[k][0] = x_temp1[i][0];
    //                a_array[k][1] = x_temp1[i][1];
    //                a_array[k][2] = x_temp1[i][2];
    //                i++;
    //            }
    //
    //            else {
    //                a_array[k][0] = x_temp2[j][0];
    //                a_array[k][1] = x_temp2[j][1];
    //                a_array[k][2] = x_temp2[j][2];
    //                j++;
    //            }
    //        }
    //        return a_array;
    //    }
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
            while (c <= ' ') c = read();
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
            while (c <= ' ') c = read();
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

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

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
