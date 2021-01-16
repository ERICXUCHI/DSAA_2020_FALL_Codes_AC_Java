package A6;

import java.io.*;
import java.math.*;
import java.util.*;

public class commonSubstring {

        static long d = 139;
        static long q = (long) Math.pow(2,52)-1;

        public static void main(String[] args) {
            InputStream inputStream = System.in;
            OutputStream outputStream = System.out;
            InputReader input = new InputReader(inputStream);
            PrintWriter out = new PrintWriter(outputStream);
            Task solver = new Task();
            solver.solve(input, out);///////////

            String string1 = input.next();
            String string2 = input.next();

//        long[] string1_array = new long[string1.length()];
//        long[] string2_array = new long[string2.length()];

            long length = string1.length();
            long l = 0;
            long r = length;
            long mid = 0;



            boolean flag = true;
            long ans = 0;
            while (l <= r) {

                mid = l + (r-l)/2;

                if (mid > string2.length()){
                    mid = string2.length();
                    r = string2.length();
                }

                long[][] a = hash(string1,mid);
                merge_sort(a,a.length);

                long[][] b = hash(string2,mid);
                boolean find = false;

                for (int i = 0; i < b.length; i++) {

                    int res = binarySearch(a, b[i][0]);
                    if (res != -1) {
                        long index = a[res][1];
                        for (int j = 0; j < mid; j++) {
                            if (string1.charAt((int) (index + j)) != string2.charAt(i + j)) {
                                flag = false;
                                break;
                            }
                        }

                        if (flag){
                            find = true;
                            break;
                        }

                    }
                }

                if (find){
                    ans = mid;
                    l = mid+1;
                }
                else {
                    r = mid-1;
                }

            }

            out.println(ans);


            out.close();////////////
        }

        //////// @Override

        static long[][] hash(String str,long length){
            long n = str.length();
            long m = length;
            long[][] t = new long[(int) (n-m+1)][2];
            long h = 1;
            long t0 = 0;

            for (int i = 0; i < m-1 ; i++) {
                h *= d;
                h = (h );
            }

            for (int i = 0; i < m; i++) {
                t0 = (d*t0 + str.charAt(i)) ;
            }
            t[0][0] = t0;

            for (int i = 0; i < n-m; i++) {
                t[i+1][0] = (d*(t[i][0] - (str.charAt(i))*h)+str.charAt((int) (i+m))) ;
                t[i+1][1] = i+1;
            }

            return t;
        }



        static long[][] merge_sort(long[][] parameter, long xn){
            if (xn > 1){
                long p = xn/2;
                long[][] x_temp1 = new long[(int) p][2];
                long[][] x_temp2 = new long[(int) (xn-p)][2];
                for (int i = 0; i < p; i++) {
                    x_temp1[i][0] = parameter[i][0];
                    x_temp1[i][1] = parameter[i][1];
                }
                for (int i = (int) p; i < xn; i++) {
                    x_temp2[(int) (i - p)][0] = parameter[i][0];
                    x_temp2[(int) (i - p)][1] = parameter[i][1];
                }
                merge_sort(x_temp1, p);
                merge_sort(x_temp2, xn - p);
                long[][] temp= merge(x_temp1, p, x_temp2, xn - p);
                for (int i = 0; i < xn; i++) {
                    parameter[i][0] = temp[i][0];
                    parameter[i][1] = temp[i][1];
                }
            }
            return parameter;
        }

        static long[][] merge(long[][] x_temp1, long nl, long[][] x_temp2, long nr) {
            long n = nl + nr;
            long[][] a_array = new long[(int) n][2];
            int i = 0;
            int j = 0;
            for (int k = 0; k < n; k++) {
                if (i < nl && (j > nr - 1 || x_temp1[i][0] <= x_temp2[j][0])) {
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
            return a_array;
        }

        static int binarySearch(long[][] nums, long val)
        {
            int low = 0, high = nums.length - 1, mid;
            while (low <= high)
            {
                mid = low + (high-low) / 2;
                if (nums[mid][0] == val)
                {
                    return mid;
                }
                else if (nums[mid][0] > val)
                {
                    high = mid - 1;
                }
                else
                    low = mid + 1;
            }
            return -1;
        }

        ////////
        static class Task {
            public void solve(InputReader in, PrintWriter out) {
            }
        }


        static class InputReader {
            public BufferedReader reader;
            public StringTokenizer tokenizer;

            public InputReader(InputStream stream) {
                reader = new BufferedReader(new InputStreamReader(stream), 32768);
                tokenizer = null;
            }

            public String next() {
                while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                    try {
                        tokenizer = new StringTokenizer(reader.readLine());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                return tokenizer.nextToken();
            }

            public int nextInt() {
                return Integer.parseInt(next());
            }

            public long nextLong() {
                return Long.parseLong(next());
            }

            public double nextDouble() {
                return Double.parseDouble(next());
            }

            public char[] nextCharArray() {
                return next().toCharArray();
            }

            //         public boolean hasNext() {
//             try {
//                 return reader.ready();
//             } catch(IOException e) {
//                 throw new RuntimeException(e);
//             }
//         }
            public boolean hasNext() {
                try {
                    String string = reader.readLine();
                    if (string == null) {
                        return false;
                    }
                    tokenizer = new StringTokenizer(string);
                    return tokenizer.hasMoreTokens();
                } catch (IOException e) {
                    return false;
                }
            }

            public BigInteger nextBigInteger() {
                return new BigInteger(next());
            }

            public BigDecimal nextBigDecimal() {
                return new BigDecimal(next());
            }
        }
    }