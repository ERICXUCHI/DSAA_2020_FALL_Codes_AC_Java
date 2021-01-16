package A4;

import java.io.*;
import java.util.*;

class polynomial_node {
    long coefficient;
    long exponent;
    polynomial_node next;

    public polynomial_node(long x, long y) {
        coefficient = x;
        exponent = y;
    }
}

public class attacks {

    public static void main(String[] args) throws IOException {
        Reader x_input = new Reader();
        PrintWriter out = new PrintWriter(System.out);////////////////////////////////////////////////////////THERE STARTS!!!
        long xt = x_input.nextLong();
        //String[] result = new String[(int) xt];
        String res = null;
        polynomial_node head1 = new polynomial_node(0, 0);
        polynomial_node head2 = new polynomial_node(0, 0);
        for (int i = 0; i < xt; i++) {
            long xn1 = x_input.nextLong();

            if (xn1 != 0) {
                polynomial_node head11 = new polynomial_node(x_input.nextLong(), x_input.nextLong());
                head1 = head11;
                for (int j = 1; j < xn1; j++) {

                    head11.next = new polynomial_node(x_input.nextLong(), x_input.nextLong());
                    head11 = head11.next;

                }
            }


            long xn2 = x_input.nextLong();
            if (xn2 != 0) {
                polynomial_node head22 = new polynomial_node(x_input.nextLong(), x_input.nextLong());
                head2 = head22;
                for (int j = 1; j < xn2; j++) {

                    head22.next = new polynomial_node(x_input.nextLong(), x_input.nextLong());
                    head22 = head22.next;

                }
            }

            polynomial_node temp1 = head1;
            polynomial_node temp2 = head2;
            polynomial_node sum1 = new polynomial_node(0, 0);
            polynomial_node sum = sum1;


            while (temp1 != null || temp2 != null) {
                while (temp1 != null && temp1.coefficient == 0) {
                    temp1 = temp1.next;
                }
                while (temp2 != null && temp2.coefficient == 0) {
                    temp2 = temp2.next;
                }

                if (temp1 != null || temp2 != null) {
                    if (temp1 == null) {
                        sum.next = new polynomial_node(temp2.coefficient, temp2.exponent);
                        sum = sum.next;
                        temp2 = temp2.next;
                    } else if (temp2 == null) {
                        sum.next = new polynomial_node(temp1.coefficient, temp1.exponent);
                        sum = sum.next;
                        temp1 = temp1.next;
                    } else if (temp1.exponent < temp2.exponent) {
                        sum.next = new polynomial_node(temp1.coefficient, temp1.exponent);
                        sum = sum.next;
                        temp1 = temp1.next;
                    } else if (temp1.exponent > temp2.exponent) {
                        sum.next = new polynomial_node(temp2.coefficient, temp2.exponent);
                        sum = sum.next;
                        temp2 = temp2.next;
                    } else {
                        if (temp1.coefficient + temp2.coefficient != 0) {
                            sum.next = new polynomial_node(temp1.coefficient + temp2.coefficient, temp1.exponent);
                            sum = sum.next;
                        }
                        temp1 = temp1.next;
                        temp2 = temp2.next;
                    }
                }
            }

            if (sum1.next != null) {
                String co = null;

                if (sum1.next.exponent == 0) {
                    co = String.valueOf(sum1.next.coefficient);
                    res = co;
                    sum1 = sum1.next;
                } else {
                    if (sum1.next.coefficient == 1) {
                        co = "";
                    } else if (sum1.next.coefficient == -1) {
                        co = "-";
                    } else {
                        co = String.valueOf(sum1.next.coefficient);
                    }

                    if (sum1.next.exponent != 1) {
                        res = co + "x^" + sum1.next.exponent;
                    } else {
                        res = co + "x";
                    }
                    sum1 = sum1.next;

                }



                while (sum1.next != null) {

                    if (sum1.next.coefficient == 1) {
                        co = "+";
                    } else if (sum1.next.coefficient == -1) {
                        co = "-";
                    } else if (sum1.next.coefficient > 0) {
                        co = "+" + sum1.next.coefficient;
                    } else {
                        co = String.valueOf(sum1.next.coefficient);
                    }

                    if (sum1.next.exponent != 1) {
                        res += co + "x^" + sum1.next.exponent;
                        sum1 = sum1.next;
                    } else {
                        res += co + "x";
                        sum1 = sum1.next;
                    }
                }
            } else {
                res = "0";
            }
            System.out.println(res);
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