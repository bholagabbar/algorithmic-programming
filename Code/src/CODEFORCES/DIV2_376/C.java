package CODEFORCES.DIV2_376;

import java.io.*;
import java.util.*;

/**
 * Shreyans Sheth [bholagabbar | http://shreyans-sheth.me]
 * 10/16/2016
 */

public class C {
    
    static class Node implements Comparable<Node>{
        int x, y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        @Override
        public int compareTo (Node o) {
            if (o.x != this.x) {
                return Integer.compare(this.x, o.x);
            }
            return Integer.compare(this.y, o.y);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return x == node.x &&
                    y == node.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
    
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    static HashMap<Integer, ArrayList<Integer>> comp = new HashMap<>();
    static boolean[] vis = new boolean[200001];
    static int[] colors = new int[200001];
    
    static void connectedComponents(int s, int currComp) {
        Queue<Integer> q = new LinkedList<>();
        comp.put(currComp, new ArrayList<>());
        q.add(s);
        vis[s] = true;
        while (!q.isEmpty()) {
            int curr = q.poll();
            comp.get(currComp).add(curr);
            for (int v : adj.get(curr)) {
                if (!vis[v]) {
                    vis[v] = true;
                    q.add(v);
                }
            }
        }
    }
    
    static int assignColors() {
        int minToPaint = 0;
        for (int ccNum : comp.keySet()) {
            ArrayList<Integer> ccKeys = comp.get(ccNum);
            HashMap<Integer, Integer> keepColorCnt = new HashMap<>();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < ccKeys.size(); i++) {
                int currColor = colors[ccKeys.get(i)];
                if (!keepColorCnt.containsKey(currColor)) {
                    keepColorCnt.put(currColor, 1);
                } else {
                    keepColorCnt.put(currColor, keepColorCnt.get(currColor) + 1);
                }
                max = Math.max(max, keepColorCnt.get(currColor));
            }
            minToPaint += ccKeys.size() - max;
        }
        return minToPaint;
    }
    
    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("E:/Shreyans/Documents/algorithmic-programming/CODE/src/input.txt"));
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);
        HashSet<Node> points = new HashSet<>();
        int n = in.readInt(), m = in.readInt(), k = in.readInt();
        adj.add(new ArrayList<>());
        for (int i = 1; i <= n; i++) {
            colors[i] = in.readInt();
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points.add(new Node(Math.min(x, y), Math.max(x, y)));
        }
        for (Node point : points) {
            adj.get(point.x).add(point.y);
            adj.get(point.y).add(point.x);
        }
        int cnt = 1;
        for (int i = 1; i <= n; i++) {
            if (!vis[i]) {
                connectedComponents(i, cnt);
                cnt++;
            }
        }
        int fans = assignColors();
        out.printLine(fans);
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