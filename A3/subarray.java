
import java.io.*;
import java.util.*;

public class subarray {

    public static void main(String[] args) throws IOException {
        Reader x_input = new Reader();
        PrintWriter out = new PrintWriter(System.out);////////////////////////////////////////////////////////THERE STARTS!!!
        int xn = x_input.nextInt();
        int an = x_input.nextInt();
        long[] x_array = new long[xn];
        long[][] x_sum_array = new long[xn][2];
        long[] index = new long[xn-an];
        long maximum = 0;

        for (int i = 0; i < xn; i++) {
            x_array[i] = x_input.nextLong();
            maximum += x_array[i] * (i+1);
        }

        x_sum_array[0][0] = x_array[xn-1];
        x_sum_array[0][1] = xn-1;
        for (int i = 1; i < xn; i++) {
            x_sum_array[i][0] = x_sum_array[i-1][0] + x_array[xn-1-i];
            x_sum_array[i][1] = xn-1-i;
        }
        merge_sort(x_sum_array,xn);

        int x_count = 0;
        for (int i = 0; i < xn-an; i++) {
            if (x_sum_array[x_count][1] != 0) {
                maximum -= x_sum_array[x_count][0];
            }
            else {
                maximum -= x_sum_array[x_count+1][0];
                x_count++;
            }
            x_count++;
        }

        System.out.println(maximum);


        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////THERE END!!!
        out.close();
    }
    static long[][] merge_sort(long[][] x_array, long xn) {
        if (xn > 1) {
            long p = xn / 2;
            long[][]x_temp1 = new long[(int) p][2];
            long[][]x_temp2 = new long[(int) (xn-p)][2];
            for (int i = 0; i < p; i++) {
                x_temp1[i][0] = x_array[i][0];
                x_temp1[i][1] = x_array[i][1];

            }
            for (int i = (int) p; i < xn; i++) {
                x_temp2[(int) (i - p)][0] = x_array[i][0];
                x_temp2[(int) (i - p)][1] = x_array[i][1];

            }
            merge_sort(x_temp1, p);
            merge_sort(x_temp2, xn - p);
            long[][] temp= merge(x_temp1, p, x_temp2, xn - p);
            for (int i = 0; i < xn; i++) {
                x_array[i][0] = temp[i][0];
                x_array[i][1] = temp[i][1];
            }
        }
        return x_array;
    }

    static long[][] merge(long[][] x_temp1, long nl, long[][] x_temp2, long nr) {
        long n = nl + nr;
        long[][] a_array = new long[(int) n][3];
        int i = 0;
        int j = 0;
        for (int k = 0; k < n; k++) {
            if (i < nl && (j > nr - 1 || x_temp1[i][0] < x_temp2[j][0])) {
                a_array[k][0] = x_temp1[i][0];
                a_array[k][1] = x_temp1[i][1];
                i++;
            }
            else if (i < nl && (j > nr - 1 || x_temp1[i][0] == x_temp2[j][0])){
                if (x_temp1[i][1] < x_temp2[j][1]){
                    a_array[k][0] = x_temp1[i][0];
                    a_array[k][1] = x_temp1[i][1];
                    i++;
                }
                else {
                    a_array[k][0] = x_temp2[j][0];
                    a_array[k][1] = x_temp2[j][1];
                    j++;
                }
            }
            else {
                a_array[k][0] = x_temp2[j][0];
                a_array[k][1] = x_temp2[j][1];
                j++;
            }
        }
        return a_array;
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


