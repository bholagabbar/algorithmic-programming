package INTERVIEW.QUES_TRY;

import java.io.*;
import java.util.*;

/**
 * Shreyans Sheth [bholagabbar | http://shreyans-sheth.me]
 * 10/15/2016
 */

class ThreeSumAllPairs {

    public static class Node implements Comparable<Node> {
        int x, y, z;
        Node(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public int compareTo(Node o1) {
            if (o1.x != x) {
                return Integer.compare(x, o1.x);
            }
            if (o1.y != y) {
                return Integer.compare(y, o1.y);
            }
            return Integer.compare(z, o1.z);
        }

        @Override
        public boolean equals(Object o) {
            Node node = (Node) o;
            return x == node.x &&
                    y == node.y &&
                    z == node.z;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, z);
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new HashSet<>());
            }
            map.get(nums[i]).add(i);
        }
        TreeSet<Node> ts = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (map.containsKey(-nums[i] - nums[j])) {
                    int target = -nums[i] - nums[j];
                    HashSet<Integer> idx = map.get(target);
                    boolean f = false, s = false;
                    if (idx.contains(i)) {
                        f = true;
                        idx.remove(i);
                    }
                    if (idx.contains(j)) {
                        s = true;
                        idx.remove(j);
                    }
                    int[] toAdd = {nums[i], nums[j], target};
                    Arrays.sort(toAdd);
                    if (idx.size() > 0) {
                        ts.add(new Node(toAdd[0], toAdd[1], toAdd[2]));
                    }
                    if (f) {
                        idx.add(i);
                    }
                    if (s) {
                        idx.add(j);
                    }
                }
            }
            if (map.get(nums[i]).size() > 1) {
                map.get(nums[i]).remove(i);
            } else {
                map.remove(nums[i]);
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (Node curr : ts) {
            List<Integer> cc = new ArrayList<>();
            cc.add(curr.x);
            cc.add(curr.y);
            cc.add(curr.z);
            ans.add(cc);
        }
        return ans;
    }    
    
    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("E:/Shreyans/Documents/Code/CODE/src/input.txt"));
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));

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