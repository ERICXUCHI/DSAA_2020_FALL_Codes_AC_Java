package A3;

import java.io.*;
import java.util.*;

public class intersection {

    public static void main(String[] args) throws IOException {
        Reader x_input = new Reader();
        PrintWriter out = new PrintWriter(System.out);////////////////////////////////////////////////////////THERE STARTS!!!
        long xn = x_input.nextLong();
        long x1 = x_input.nextLong();
        long x2 = x_input.nextLong();
        long[][] parameter = new long[(int) xn][4];

        for (int i = 0; i < xn; i++) {
            parameter[i][0] = x_input.nextLong();
            parameter[i][1] = x_input.nextLong();
            parameter[i][2] = parameter[i][0] * x1 + parameter[i][1];
            parameter[i][3] = parameter[i][0] * x2 + parameter[i][1];
        }

        merge_sort(parameter, xn);
        for (int i = 0; i < xn-1; i++) {
            if (parameter[i][3] > parameter[i+1][3] && parameter[i][2] != parameter[i+1][2]) {
                System.out.println("YES");
                System.exit(0);
            }
        }
        System.out.println("NO");

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////THERE END!!!
        out.close();
    }
    static long[][] merge_sort(long[][] parameter, long xn){
        if (xn > 1){
            long p = xn/2;
            long[][] x_temp1 = new long[(int) p][4];
            long[][] x_temp2 = new long[(int) (xn-p)][4];
            for (int i = 0; i < p; i++) {
                x_temp1[i][0] = parameter[i][0];
                x_temp1[i][1] = parameter[i][1];
                x_temp1[i][2] = parameter[i][2];
                x_temp1[i][3] = parameter[i][3];

            }
            for (int i = (int) p; i < xn; i++) {
                x_temp2[(int) (i - p)][0] = parameter[i][0];
                x_temp2[(int) (i - p)][1] = parameter[i][1];
                x_temp2[(int) (i - p)][2] = parameter[i][2];
                x_temp2[(int) (i - p)][3] = parameter[i][3];
            }
            merge_sort(x_temp1, p);
            merge_sort(x_temp2, xn - p);
            long[][] temp= merge(x_temp1, p, x_temp2, xn - p);
            for (int i = 0; i < xn; i++) {
                parameter[i][0] = temp[i][0];
                parameter[i][1] = temp[i][1];
                parameter[i][2] = temp[i][2];
                parameter[i][3] = temp[i][3];
            }
        }
        return parameter;
    }

    static long[][] merge(long[][] x_temp1, long nl, long[][] x_temp2, long nr) {
        long n = nl + nr;
        long[][] a_array = new long[(int) n][4];
        int i = 0;
        int j = 0;
        for (int k = 0; k < n; k++) {
            if (i < nl && (j > nr - 1 || x_temp1[i][2] < x_temp2[j][2])) {
                a_array[k][0] = x_temp1[i][0];
                a_array[k][1] = x_temp1[i][1];
                a_array[k][2] = x_temp1[i][2];
                a_array[k][3] = x_temp1[i][3];
                i++;
            }
            else if (i < nl && (j > nr - 1 || x_temp1[i][2] == x_temp2[j][2])){
                if (x_temp1[i][3] < x_temp2[j][3]){
                    a_array[k][0] = x_temp1[i][0];
                    a_array[k][1] = x_temp1[i][1];
                    a_array[k][2] = x_temp1[i][2];
                    a_array[k][3] = x_temp1[i][3];
                    i++;
                }
                else {
                    a_array[k][0] = x_temp2[j][0];
                    a_array[k][1] = x_temp2[j][1];
                    a_array[k][2] = x_temp2[j][2];
                    a_array[k][3] = x_temp2[j][3];
                    j++;
                }
            }
            else {
                a_array[k][0] = x_temp2[j][0];
                a_array[k][1] = x_temp2[j][1];
                a_array[k][2] = x_temp2[j][2];
                a_array[k][3] = x_temp2[j][3];
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


