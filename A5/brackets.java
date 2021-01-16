package A5;

import java.io.*;
import java.math.*;
import java.util.*;



public class brackets {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
        solver.solve(in, out);
        int xn = in.nextInt();

        for (int i = 0; i < xn; i++) {
            int xt = in.nextInt();
            if (xt % 2 == 0) {
                String str = in.next();
                char[] chars = new char[xt];
                int[] x_array = new int[xt];
                int top = -1;

                for (int j = 0; j < xt; j++) {
                    chars[j] = str.charAt(j);
                    if (top < x_array.length-1 && chars[j] == '(') {
                        top++;
                        x_array[top] = 1;
                    } else if (top < x_array.length-1 && chars[j] == '[') {
                        top++;
                        x_array[top] = 2;
                    } else if (top < x_array.length-1 && chars[j] == '{') {
                        top++;
                        x_array[top] = 3;
                    } else if (chars[j] == ')' && top >= 0 && x_array[top] == 1) {
                        x_array[top] = 0;
                        top--;
                    } else if (chars[j] == ']' && top >= 0 && x_array[top] == 2) {
                        x_array[top] = 0;
                        top--;
                    } else if (chars[j] == '}' && top >= 0 && x_array[top] == 3) {
                        x_array[top] = 0;
                        top--;
                    } else {
                        top = 0;
                        break;

                    }

                }

                if (top == -1) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
            else {
                String str = in.next();
                System.out.println("NO");
            }


        }





        out.close();
    }

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