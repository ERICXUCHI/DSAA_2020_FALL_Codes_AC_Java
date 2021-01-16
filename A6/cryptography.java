package A6;
import java.io.*;
import java.math.*;
import java.util.*;
public class cryptography {

        public static void main(String[] args) {
            String[] array = new String[26];
            InputStream inputStream = System.in;
            OutputStream outputStream = System.out;
            InputReader input = new InputReader(inputStream);
            PrintWriter out = new PrintWriter(outputStream);
            Task solver = new Task();
            solver.solve(input, out);///////////
            for (int i = 0; i < 26; i++) {
                array[i] = input.next();
            }

            String code = input.next();

            char[] code_array = new char[code.length()];
            char[] clone_array = new char[code.length()];

            for (int i = 0; i < code.length(); i++) {
                code_array[i] = code.charAt(i);
                clone_array[i] = code.charAt(i);
            }


            int half = (code.length()+1) / 2;

            for (int i = half; i < code.length(); i++) {

                char tmp = code_array[i];
                char replace = array[tmp-97].charAt(0);
                clone_array[i] = replace;

            }

            int[] signal = next(code_array,clone_array,half);
            System.out.println(code.length() - signal[code.length()-1]);


            out.close();////////////
        }

        //////// @Override
        static int[] next(char[] code, char[] clone, int point){
            int length = code.length;
            int[] result = new int[length];
            result[0] = 0;
            int k = 0;
            int j = point;
            while (j < length){
                if (code[k] == clone[j]){
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