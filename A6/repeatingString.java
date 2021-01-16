package A6;
import java.io.*;
import java.math.*;
import java.util.*;


public class repeatingString {

        public static void main(String[] args) {
//            InputStream inputStream = System.in;
//            OutputStream outputStream = System.out;
//            InputReader in = new InputReader(inputStream);
//            PrintWriter out = new PrintWriter(outputStream);
//            Task solver = new Task();
//            solver.solve(in, out);///////////
//
            Scanner input = new Scanner(System.in);
            int number = input.nextInt();
            for (int i = 0; i < number; i++) {
                String temp = input.next();
                int[] array = next(temp);
                int a = temp.length();

                while (a < array[a-1] * 2){
                    a = array[a-1];
                }
                System.out.println(a - 2 * array[a-1]);

            }

//            out.close();////////////
        }

        //////// @Override
        static int[] next(String temp){
            int length = temp.length();
            int[] result = new int[length];
            result[0] = 0;
            int k = 0;
            int j = 1;
            while (j < length){
                if (temp.charAt(j) == temp.charAt(k)){
                    k++;
                    result[j] = k;
                    j++;
                }
                else if (k == 0){
                    result[j] = 0;
                    j++;
                }
                else {
                    k = result[k-1];
                }

            }
            return result;

        }
        ////////
//        static class Task {
//            public void solve(InputReader in, PrintWriter out) {
//            }
//        }
//
//
//        static class InputReader {
//            public BufferedReader reader;
//            public StringTokenizer tokenizer;
//
//            public InputReader(InputStream stream) {
//                reader = new BufferedReader(new InputStreamReader(stream), 32768);
//                tokenizer = null;
//            }
//
//            public String next() {
//                while (tokenizer == null || !tokenizer.hasMoreTokens()) {
//                    try {
//                        tokenizer = new StringTokenizer(reader.readLine());
//                    } catch (IOException e) {
//                        throw new RuntimeException(e);
//                    }
//                }
//                return tokenizer.nextToken();
//            }
//
//            public int nextInt() {
//                return Integer.parseInt(next());
//            }
//
//            public long nextLong() {
//                return Long.parseLong(next());
//            }
//
//            public double nextDouble() {
//                return Double.parseDouble(next());
//            }
//
//            public char[] nextCharArray() {
//                return next().toCharArray();
//            }
//
//            //         public boolean hasNext() {
////             try {
////                 return reader.ready();
////             } catch(IOException e) {
////                 throw new RuntimeException(e);
////             }
////         }
//            public boolean hasNext() {
//                try {
//                    String string = reader.readLine();
//                    if (string == null) {
//                        return false;
//                    }
//                    tokenizer = new StringTokenizer(string);
//                    return tokenizer.hasMoreTokens();
//                } catch (IOException e) {
//                    return false;
//                }
//            }
//
//            public BigInteger nextBigInteger() {
//                return new BigInteger(next());
//            }
//
//            public BigDecimal nextBigDecimal() {
//                return new BigDecimal(next());
//            }
//        }
    }
