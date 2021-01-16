package A5;

import java.io.*;
import java.util.*;
import java.math.*;
class Node{
    int val;
    Node pre;
    Node next;
    Node(int x){
        val = x;
    }
}
public class candy {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
        solver.solve(in, out);//=========starts!!!

        int max = 300002;
        int maxNum = 1000001;

        int[][] count = new int[maxNum][2];
        Node[][] Nodes = new Node[max][2];
        for (int i = 0; i < max; i++) {
            Nodes[i][0] = new Node(0);
            Nodes[i][1] = new Node(maxNum);
            Nodes[i][0].next = Nodes[i][1];
            Nodes[i][1].pre = Nodes[i][0];
        }
        int MAX = 0;

        String now = in.next();
        while (!now.equals("nsdd")) {
            if (now.equals("put-in")) {
                int index = in.nextInt();
                count[index][1]++;
                int cnt = count[index][1];

                Node newNode = new Node(index);
                Nodes[cnt][1].pre.next = newNode;
                newNode.pre = Nodes[cnt][1].pre;
                Nodes[cnt][1].pre = newNode;
                newNode.next = Nodes[cnt][1];

                if (cnt > MAX) {
                    MAX = cnt;
                }

            } else {
                if (MAX == 0) {
                    System.out.println("pa");
                } else {
                    Node pop = Nodes[MAX][1].pre;
                    System.out.println(pop.val);
                    pop.next.pre = pop.pre;
                    pop.pre.next = pop.next;
                    pop.pre = null;
                    pop.next = null;

                    count[pop.val][1]--;

                    if (Nodes[MAX][1].pre == Nodes[MAX][0]) {
                        MAX--;
                    }


                }

            }

            now = in.next();
        }


        out.close();//========end!!!
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