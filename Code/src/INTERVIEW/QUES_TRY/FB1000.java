package INTERVIEW.QUES_TRY;

import java.io.*;
import java.util.*;

/**
 * Shreyans Sheth [bholagabbar | http://shreyans-sheth.me]
 * 10/10/2016
 */

class FB1000 {

    /**
     * WONT WORK COZ YOU DON"T KNOW WHEN TO STOP IN FRONT OR BACK. GREEDY WON'T WORK
     **/
    
//    public static ArrayList<Integer> ZAlgoIndices(String actual, String pattern) {
//        char[] s = (pattern + "$" + actual).toCharArray();
//        int[] z = new int[s.length + 1];
//        int n = s.length;
//        int patLen = pattern.length();
//        ArrayList<Integer> val = new ArrayList<>();
//        for (int i = 1, l = 0, r = 0; i < n; i++) {
//            z[i] = 0;
//            if (i < r) {
//                z[i] = Math.min(r - i + 1, z[i - l]);
//            }
//            while (i + z[i] < n && s[z[i]] == s[i + z[i]]) {
//                z[i]++;
//            }
//            if (i + z[i] - 1 > r) {
//                r = i + z[i] - 1;
//                l = i;
//            }
//            if (i > patLen && z[i] == patLen) {
//                val.add(i - patLen - 1);
//            }
//        }
//        return val;
//    }
//
//    public static ArrayList<Integer> findSubstring(String a, final List<String> b) {
//        a = a.trim();
//        String firstToFind = b.get(0);
//        int len =firstToFind.length();
//        ArrayList<Integer> firstPatIndices = ZAlgoIndices(a, firstToFind);
//        HashMap<String, Integer> map = new HashMap<>();
//        for (String x : b) {
//            if (!map.containsKey(x)) {
//                map.put(x, 1);
//            } else {
//                map.put(x, map.get(x) + 1);
//            }
//        }
//        ArrayList<Integer> ans = new ArrayList<>();
//        for (int i : firstPatIndices) {
//            System.out.println("START " + i);
//            int l = i;
//            int r = i + len;
//            HashMap<String, Integer> tempMap = new HashMap<>(map);
//            while (r <= a.length() && !tempMap.isEmpty()) {
//                String curr = a.substring(l, r);
//                System.out.println("ONE" + curr);
//                if (tempMap.containsKey(curr)) {
//                    if (tempMap.get(curr) == 1) {
//                        tempMap.remove(curr);
//                    } else {
//                        tempMap.put(curr, tempMap.get(curr) - 1);
//                    }
//                    l += len;
//                    r += len;
//                } else {
//                    break;
//                }
//            }
//            if (tempMap.isEmpty()) {
//                System.out.println("YA");
//                l = i;
//                System.out.println(l);
//                System.out.println();
//                ans.add(l);
//            }
//            l = i - len;
//            r = i;
//            while (l >= 0 && !tempMap.isEmpty()) {
//                String curr = a.substring(l, r);
//                System.out.println("TWO" + curr);
//                if (tempMap.containsKey(curr)) {
//                    if (tempMap.get(curr) == 1) {
//                        tempMap.remove(curr);
//                    } else {
//                        tempMap.put(curr, tempMap.get(curr) - 1);
//                    }
//                    l -= len;
//                    r -= len;
//                } else {
//                    break;
//                }
//            }
//            if (tempMap.isEmpty()) {
//                System.out.println("YA");
//                l += len;
//                System.out.println(l);
//                System.out.println();
//                ans.add(l);
//            } else {
//                System.out.println("NO");
//                System.out.println(l);
//                System.out.println(tempMap);
//                System.out.println();
//            }
//        }
//        return new ArrayList<>(new TreeSet<>(ans));
//    }
//        


    
    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("E:/Shreyans/Documents/Code/CODE/src/input.txt"));
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);
    }

    //FAST IO
    private static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public int readInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public String readString() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public double readDouble() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            double res = 0;
            while (!isSpaceChar(c) && c != '.') {
                if (c == 'e' || c == 'E') {
                    return res * Math.pow(10, readInt());
                }
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            }
            if (c == '.') {
                c = read();
                double m = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E') {
                        return res * Math.pow(10, readInt());
                    }
                    if (c < '0' || c > '9') {
                        throw new InputMismatchException();
                    }
                    m /= 10;
                    res += (c - '0') * m;
                    c = read();
                }
            }
            return res * sgn;
        }

        public long readLong() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() {
            return readString();
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }

    private static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(objects[i]);
            }
            writer.flush();
        }

        public void printLine(Object... objects) {
            print(objects);
            writer.println();
            writer.flush();
        }

        public void close() {
            writer.close();
        }

        public void flush() {
            writer.flush();
        }
    }
}