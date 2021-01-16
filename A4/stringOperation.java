package A4;
import java.io.*;
import java.math.*;
import java.util.*;

class block{
    Character[] x_array;
    long size;
    block next;
    block(long n){
        x_array = new Character[(int) n];
    }
}


public class stringOperation{

    public static void main(String[] args) {
        InputStream inputStream = System.in;// new FileInputStream("C:\\Users\\wavator\\Downloads\\A5.test.in");
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
        solver.solve(in, out);


        long xt = in.nextLong();
        for (int i = 0; i < xt; i++) {
            String x_string = in.next();
            long x_stringSize = x_string.length();
            block[] blocks = new block[1000];

            blocks[0] = new block((long) (2 * Math.sqrt(x_stringSize)));
            for (int j = 1; j < 999; j++) {
                blocks[j] = new block((long) (2 * Math.sqrt(x_stringSize)));
                blocks[j-1].next = blocks[j];
            }
            blocks[999] = new block((long) (2 * Math.sqrt(x_stringSize)));
            blocks[998].next = blocks[999];

            block cur = blocks[0];
            long count = 0;


            for (int j = 0; j < x_stringSize; j++) {
                char temp = x_string.charAt(j);
                if (count >=  Math.sqrt(x_stringSize)-1) {
                    cur = cur.next;
                    count = 0;
                    j--;
                }
                else {
                    cur.x_array[(int) count] = temp;
                    cur.size++;
                    count++;
                }
            }

            cur = blocks[0];
            long xo = in.nextLong();
            for (int j = 0; j < xo; j++) {
                long sig = in.nextLong();
                if (sig == 1){
                    String ins_str = in.next();
                    char insert = ins_str.charAt(0);
                    long insert_pos = in.nextLong();
                    cur = blocks[0];
                    while (insert_pos > cur.size){
                        insert_pos -= cur.size;
                        cur = cur.next;
                    }
                    if (cur.size < (long) (2 * Math.sqrt(x_stringSize))){
                        for (int k = (int) cur.size; k > insert_pos-1; k--) {
                            cur.x_array[k] = cur.x_array[k-1];
                        }
                        cur.x_array[(int) (insert_pos-1)] = insert;
                        cur.size++;
                    }
                    else {
                        block newBlock = new block((long) (2 * Math.sqrt(x_stringSize)));
                        newBlock.next = cur.next;
                        cur.next = newBlock;

                        for (int k = (int) Math.sqrt(x_stringSize); k < cur.size; k++) {
                            newBlock.x_array[k - (int) Math.sqrt(x_stringSize)] = cur.x_array[k];
                            cur.x_array[k] = null;
                            newBlock.size++;
                        }
                        cur.size = (int) Math.sqrt(x_stringSize);

                        if (insert_pos < (int) Math.sqrt(x_stringSize)){
                            for (int k = (int) cur.size; k > insert_pos-1; k--) {
                                cur.x_array[k] = cur.x_array[k-1];
                            }
                            cur.x_array[(int) (insert_pos-1)] = insert;
                            cur.size++;
                        }
                        else{
                            insert_pos -= cur.size;
                            cur = cur.next;
                            for (int k = (int) cur.size; k > insert_pos-1; k--) {
                                cur.x_array[k] = cur.x_array[k-1];
                            }
                            cur.x_array[(int) (insert_pos-1)] = insert;
                            cur.size++;
                        }
                    }

                }
                else {
                    cur = blocks[0];
                    long find_pos = in.nextLong();
                    while (find_pos > cur.size){
                        find_pos -= cur.size;
                        cur = cur.next;
                    }

                    char res = cur.x_array[(int) (find_pos-1)];
                    System.out.println(res);
                }
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