package INTERVIEW.QUES_TRY;

import java.io.*;
import java.util.*;

/**
 * Shreyans Sheth [bholagabbar | http://shreyans-sheth.me]
 * 10/6/2016
 */

class PhoneNum {


    static HashMap<Integer, ArrayList<String>> initMap() {
        HashMap<Integer, ArrayList<String>> map = new HashMap<>();
        map.put(0, new ArrayList<>(Arrays.asList("0")));
        map.put(1, new ArrayList<>(Arrays.asList("1")));
        map.put(2, new ArrayList<>(Arrays.asList("a", "b", "c")));
        map.put(3, new ArrayList<>(Arrays.asList("d", "e", "f")));
        map.put(4, new ArrayList<>(Arrays.asList("g", "h", "i")));
        map.put(5, new ArrayList<>(Arrays.asList("j", "k", "l")));
        map.put(6, new ArrayList<>(Arrays.asList("m", "n", "o")));
        map.put(7, new ArrayList<>(Arrays.asList("p", "q", "r", "s")));
        map.put(8, new ArrayList<>(Arrays.asList("t", "u", "v")));
        map.put(9, new ArrayList<>(Arrays.asList("w", "x", "y", "z")));
        return map;
    }

    static void AppendChar(String str, int currNum, ArrayList<String> arr, HashMap<Integer, ArrayList<String>> map, TreeSet<String> ans) {
        if (currNum == str.length()) {
            return;
        }
        for (String i : map.get(str.charAt(currNum) - 48)) {
            arr.add(i);
            AppendChar(str, currNum + 1, arr, map, ans);
            if (arr.size() == str.length()) {
                StringBuilder sb = new StringBuilder();
                for (String x : arr) {
                    sb.append(x);
                }
                ans.add(sb.toString());
            }
            if (arr.size() > 0) {
                arr.remove(arr.size() - 1);
            }
        }
    }

    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> a) {
        Collections.sort(a);
        int n = a.size();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < (1 << n); i++) {
            ArrayList<Integer> curr = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (((1 << j) & i) > 0) {
                    curr.add(a.get(j));
                }
            }
            ans.add(curr);
        }
        Collections.sort(ans, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                for (int i = 0; i < Math.min(o1.size(), o2.size()); i++) {
                    if (!o1.get(i).equals(o2.get(i))) {
                        return Integer.compare(o1.get(i), o2.get(i));
                    }
                }
                return Integer.compare(o1.size(), o2.size());
            }
        });
        System.out.println(ans);
        return ans;
    }
    
    static public ArrayList<String> letterCombinations(String a) {
        HashMap<Integer, ArrayList<String>> map = initMap();
        TreeSet<String> ans = new TreeSet<>();
        ArrayList<String> arr = new ArrayList<>();
        AppendChar("120", 0, arr, map, ans);
        ans.remove("");
        System.out.println(ans);
        return new ArrayList<>(ans);
    }

    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("E:/Shreyans/Documents/Code/CODE/src/input.txt"));
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);
//        letterCombinations("23");
        subsets(new ArrayList<>(Arrays.asList( 15, 20, 12, 19, 4 )));
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