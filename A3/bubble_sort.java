package A3;

import java.io.*;
import java.util.*;

public class bubble_sort {

    public static void main(String[] args) throws IOException {
        Reader x_input =new Reader();
        PrintWriter out=new PrintWriter(System.out);//////////////////THERE STARTS!!!
        int xt = x_input.nextInt();
        long[] result = new long[xt];
        for (int i = 0; i < xt; i++) {
            int xn = x_input.nextInt();
            int[] x_array = new int[xn];
            for (int j = 0; j < xn; j++) {
                x_array[j] = x_input.nextInt();
            }

            int[] x_temp = new int[xn];
            if (xn < 2){
                result[i] = 0;
            }else {
                result[i] = (number_of_reverse(x_array, 0, x_array.length - 1, x_temp));
            }
        }

        for (int i = 0; i < xt; i++) {
            System.out.println(result[i]);
        }

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////THERE END!!!
        out.close();
    }

    static long number_of_reverse(int[] x_array, int left, int right, int[] x_temp){
        if (left == right){
            return 0;
        }
        int mid = (right - left)/2 + left;
        long left_part = number_of_reverse(x_array, left, mid, x_temp);
        long right_part = number_of_reverse(x_array, mid+1, right, x_temp);

        if (x_array[mid] <= x_array[mid + 1]){
            return left_part + right_part;
        }

        long two_section = mergeSection(x_array, left, mid, right, x_temp);
        return left_part + two_section + right_part;
    }

    static long mergeSection(int[] x_array, int left, int mid, int right, int[] x_temp) {
        for (int i = left; i <= right ; i++) {
            x_temp[i] = x_array[i];
        }

        int i = left;
        int j = mid+1;

        long x_count = 0;
        for (int k = left; k <= right ; k++) {
            if (i == mid + 1){
                x_array[k] = x_temp[j];
                j++;
            }
            else if (j == right + 1){
                x_array[k] = x_temp[i];
                i++;
            }

            else if (x_temp[i] <= x_temp[j]){
                x_array[k] = x_temp[i];
                i++;
            }
            else {
                x_array[k] = x_temp[j];
                j++;
                x_count += (mid - i + 1);
            }
        }
        return x_count;
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
 