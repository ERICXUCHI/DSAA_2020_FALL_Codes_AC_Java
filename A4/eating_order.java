package A4;

import java.io.*;
import java.util.*;

class listNode {
    long value;
    listNode next;

    listNode(long x) {
        value = x;
    }
}

public class eating_order {

    public static void main(String[] args) throws IOException {
        Reader x_input = new Reader();
        PrintWriter out = new PrintWriter(System.out);////////////////////////////////////////////////////////THERE STARTS!!!
        long xt = x_input.nextLong();

        long[][] result= new long[(int) xt][];

        for (long i = 0; i < xt; i++) {
            long xn = x_input.nextLong();
            long xk = x_input.nextLong();
            result[(int) i] = new long[(int) xn];
            listNode head = new listNode(1);
            listNode temp = head;
            for (long j = 2; j <= xn; j++) {
                temp.next = new listNode(j);
                temp = temp.next;
            }
            temp.next = head;
            temp = temp.next;
            listNode current = temp;

            if (xk == 1) {
                for (int j = 0; j < xn; j++) {
                    result[(int) i][j] = j + 1;
                }
            } else {
                for (long j = 0; j < xn; j++) {
//                System.out.println(current.value);
                    for (int k = 0; k < xk - 2; k++) {
                        temp = temp.next;
                    }
                    //current = temp.next;
                    //System.out.print(temp.next.value+" ");
                    result[(int) i][(int) j] = temp.next.value;
                    temp.next = temp.next.next;
                    temp = temp.next;
                }

            }
        }
        for (long i = 0; i < xt; i++) {
            for (long j = 0; j < result[(int) i].length; j++) {
                System.out.print(result[(int) i][(int) j] + " ");
            }
            System.out.println();
        }

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////THERE END!!!
        out.close();
    }


    static class Reader
    {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1)
            {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do
            {
                ret = ret * 10 + c - '0';
            }  while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException
        {
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

        public double nextDouble() throws IOException
        {
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

            if (c == '.')
            {
                while ((c = read()) >= '0' && c <= '9')
                {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }

}