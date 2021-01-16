package A8;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class stream {

    static long leftChild(long i)
    {
        return 2*i;
    }
    static long rightChild(long i)
    {
        return 2 * i + 1;
    }

    static void heap(long[] array,long n,long index)
    {

        long min = index;
        long left = leftChild(index);
        long right = rightChild(index);
        if(left <= n && array[(int) left] < array[(int) min])
        {
            min = left;
        }
        if(right <= n && array[(int) right] < array[(int) min])
        {
            min = right;
        }
        if(min != index)
        {
            long tmp = array[(int) index];
            array[(int) index] = array[(int) min];
            array[(int) min] = tmp;
            heap(array,n,min);
        }
    }

    public static void main(String[] args) throws IOException {
        Reader input = new Reader();
        PrintWriter out = new PrintWriter(System.out);////////


        long time = input.nextLong();
        int k = input.nextInt();
        long s = input.nextLong();
        long[] values = new long[k + 1];
        long counter = 0;
        for (int i = 1; i <= time; i++) {
            long tmp = i + s;
            long a = tmp;
            while (tmp > 0) {
                a = a + tmp % 10;
                tmp = tmp / 10;
            }
            counter++;
            long count = counter;
            if (count <= k) {
                values[(int) count] = a;
                for (int j = 2; j <= count; j++) {
                    if (a < values[(int) (count / 2)]) {
                        while (a < values[(int) (count / 2)]) {
                            values[(int) count] = values[(int) (count / 2)];
                            values[(int) (count / 2)] = a;
                            count = count / 2;
                            if (count == 1) {
                                break;
                            }
                        }
                    }
                    else {
                        break;
                    }
                }
            }

            else {
                if (a > values[1]) {
                    values[1] = a;
                    int j = 1;
                    while (2 * j <= k) {
                        if ((2 * j + 1) > k) {
                            if (values[j] > values[2 * j]) {
                                long temp = values[j];
                                values[j] = values[2 * j];
                                values[2 * j] = temp;
                                j = j * 2;
                            } else {
                                break;
                            }
                        } else {
                            if (values[j] > values[2 * j] && values[2 * j] < values[2 * j + 1]) {
                                long temp = values[j];
                                values[j] = values[2 * j];
                                values[2 * j] = temp;
                                j = j * 2;
                            } else if (values[j] > values[2 * j + 1]) {
                                long temp = values[j];
                                values[j] = values[2 * j + 1];
                                values[2 * j + 1] = temp;
                                j = j * 2 + 1;
                            } else {
                                break;
                            }
                        }
                    }

                }
//                if (a > values[1]){
//                    values[1] = a;
//                    heap(values,k,1);
//                }
//                int j = 1;
//                while (2*j <= k){
//                    if ((2*j+1) > k){
//                        if (values[j] > values[2 * j]){
//                            int temp = values[j];
//                            values[j] = values[2*j];
//                            values[2*j] = temp;
//                            j = j*2;
//                        }
//                        else {
//                            break;
//                        }
//                    }
//                    else {
//                        if (values[j] > values[2 * j] && values[2 * j] < values[2 * j + 1]){
//                            int temp = values[j];
//                            values[j] = values[2 * j];
//                            values[2 * j] = temp;
//                            j = j * 2;
//                        }
//                        else if (values[j] > values[2 * j + 1]) {
//                            int temp = values[j];
//                            values[j] = values[2 * j + 1];
//                            values[2 * j + 1] = temp;
//                            j = j * 2 + 1;
//                        }
//                        else {
//                            break;
//                        }
//                    }
//                }
            }

            if (i % 100 == 0){
                System.out.print(values[1] + " ");
                s = values[1];
            }
        }


        out.close();////////
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
