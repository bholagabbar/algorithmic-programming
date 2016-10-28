package INTERVIEW.QUES_TRY;

import java.io.*;
import java.util.*;

import static javafx.scene.input.KeyCode.T;

/**
 * Shreyans Sheth [bholagabbar | http://shreyans-sheth.me]
 * 10/9/2016
 */

class APlusBequalsCplusD {

    static class Node {
        public Integer w, x, y, z;
        Node() {
            w = x = y = z = null;
        }
    }
    
    public static ArrayList<Integer> equal(ArrayList<Integer> a) {
        HashMap<Integer, Node> tups = new HashMap<>();
        for (int i = 0; i < a.size(); i++) {
            for (int j = i + 1; j < a.size(); j++) {
                int currSum = a.get(i) + a.get(j);
                if (!tups.containsKey(currSum)) {
                    Node currNode = new Node();
                    currNode.w = i;
                    currNode.x = j;
                    tups.put(currSum, currNode);
                } else if (tups.containsKey(currSum) && tups.get(currSum).y == null && i !=  tups.get(currSum).w && j != tups.get(currSum).x && j !=  tups.get(currSum).w && i != tups.get(currSum).x) {
                    tups.get(currSum).y = i;
                    tups.get(currSum).z = j;
                }
            }
        }
        ArrayList<Node> ts = new ArrayList<>();
        for (int x : tups.keySet()) {
            Node xx = tups.get(x);
            if (xx.y != null) {
                ts.add(xx);
            }
        }
        
        Collections.sort(ts, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (!o1.w.equals(o2.w)) {
                    return Integer.compare(o1.w, o2.w);
                }
                if (!o1.x.equals(o2.x)) {
                    return Integer.compare(o1.x, o2.x);
                }
                if (!o1.y.equals(o2.y)) {
                    return Integer.compare(o1.y, o2.y);
                }
                return Integer.compare(o1.z, o2.z);
            }
        });
        ArrayList<Integer> ans = new ArrayList<>();
        Node f = ts.get(0);
        ans.add(f.w);
        ans.add(f.x);
        ans.add(f.y);
        ans.add(f.z);
        return ans;
    }
    
    
    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("E:/Shreyans/Documents/Code/CODE/src/input.txt"));
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);
        System.out.println(equal(new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1))));
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