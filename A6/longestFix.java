package A6;
import java.io.*;
import java.util.*;

public class longestFix {

        public static void main(String[] args) throws IOException {
            AReader input = new AReader();
            AWriter output = new AWriter();/////////
//        int n = input.nextInt();



            int cases = input.nextInt();
            String[] str_arr = new String[cases];
            for (int i = 0; i < cases; i++) {
                str_arr[i] = input.next();
            }
            int longestPrefix = 0;
            int longestSuffix = 0;

            longestPrefix = prefix(str_arr);

            longestSuffix = suffix(str_arr);

            System.out.println(longestPrefix*longestSuffix);

//        int x;
//        while (input.hasNext()) {
//            x = input.nextInt();
//            output.println(x);
//        }
            //////////
            output.close();
        }

        ////@override
        static int prefix(String[] str_arr){
            int prefix = 0;
            if (str_arr.length != 0){
                String tmp = str_arr[0];

                for (int i = 1; i < str_arr.length; i++) {
                    int j = 0;
                    int num = Math.min(tmp.length(),str_arr[i].length());
                    for (;j < num; j++) {
                        if (tmp.charAt(j) != str_arr[i].charAt(j)) {
                            break;
                        }
                    }
                    tmp = tmp.substring(0,j);

                    prefix = j;
                }

            }
            return prefix;

        }

        static int suffix(String[] str_arr){
            int suffix = 0;
            if (str_arr.length != 0){
                String tmp = str_arr[0];

                for (int i = 1; i < str_arr.length; i++) {
                    int num = Math.min(tmp.length(),str_arr[i].length());
                    int a = tmp.length()-1;
                    int b = str_arr[i].length()-1;
                    for (int j = 0; j < num; j++) {


                        if (tmp.charAt(a) != str_arr[i].charAt(b)) {
                            break;
                        }
                        else {
                            a--;
                            b--;
                        }
                    }
                    tmp = tmp.substring(a+1);

                    suffix = tmp.length();
                }

            }
            return suffix;

        }


        ////////
    }




    class AReader {
        private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        private StringTokenizer tokenizer = new StringTokenizer("");

        private String innerNextLine() {
            try {
                return reader.readLine();
            } catch (IOException ex) {
                return null;
            }
        }

        public boolean hasNext() {
            while (!tokenizer.hasMoreTokens()) {
                String nextLine = innerNextLine();
                if (nextLine == null) {
                    return false;
                }
                tokenizer = new StringTokenizer(nextLine);
            }
            return true;
        }

        public String nextLine() {
            tokenizer = new StringTokenizer("");
            return innerNextLine();
        }

        public String next() {
            hasNext();
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong(){
            return Long.parseLong(next());
        }
    }

    class AWriter implements Closeable {
        private BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        public void print(Object object) throws IOException {
            writer.write(object.toString());
        }

        public void println(Object object) throws IOException {
            writer.write(object.toString());
            writer.write("\n");
        }

        @Override
        public void close() throws IOException {
            writer.close();
        }
    }