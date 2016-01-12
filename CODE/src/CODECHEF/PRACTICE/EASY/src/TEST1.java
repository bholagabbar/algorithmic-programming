import java.io.*;
import java.util.*;

/**
 * Created by Shreyans Sheth [bholagabbar] on 1/10/2016 at 4:42 PM using IntelliJ IDEA (Fast IO Template)
 */

class TEST1 {

    static long[] fact = new long[100001];
    static long MOD = (long)(1e9+7);
    static boolean[][] keepPair = new boolean[(1<<7)+5][7];
    static int[][] badEdges = new int[7][2];
    static int[] vertexHash = new int[100005];

    static class DisjointSetUnion {
        static int[] u;
        static int[] rank;

        DisjointSetUnion(int n) {
            u = new int[n+1];
            rank = new int[n+1];
            for (int i = 1; i <= n; i++) {
                u[i] = i;
            }
        }

        public int Find(int x) {
            if(u[x]!=u[u[x]]) {
                u[x]=Find(u[x]);
            }
            return u[x];
        }

        public  boolean Union (int x, int y)
        {
            int px=Find(x);
            int py=Find(y);
            if(px==py) {
                return false;
            }
            if(rank[px]>rank[py]) {
                int temp=px;
                px=py;
                py=temp;
            } else if(rank[px]==rank[py]){
                rank[py]++;
            }
            u[px]=py;
            return true;
        }
    }

    private static void computeFactorial() {
        fact[1] = 1;
        for (int i = 2; i <= 1e5; i++) {
            fact[i] = (i * fact[i-1] % MOD) % MOD;
        }
    }

    static void brutePairs() {
        for (int i = 1; i < (1 << 7); i++) {
            for (int j = 0; j < 7; j++) {
                if ((i & ( 1 << j)) > 0) {
                    keepPair[i][j] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("E:/Shreyans/Documents/Code/CODE/src/Stdin_File_Read.txt"));
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);
        computeFactorial();
        brutePairs();
        int tc = in.readInt();
        while (tc-- > 0) {
            int n = in.readInt();
            int m = in.readInt();
            int vertexHashCnt = 1;
            HashSet<Integer> badVertices = new HashSet<Integer>();
            for (int i = 0; i < m; i++) {
                badEdges[i][0] = in.readInt();
                badEdges[i][1] = in.readInt();
                vertexHash[badEdges[i][0]] = vertexHashCnt++;
                vertexHash[badEdges[i][1]] = vertexHashCnt++;
                badVertices.add(vertexHash[badEdges[i][0]]);
                badVertices.add(vertexHash[badEdges[i][1]]);
            }
            long fAns = fact[n];
            for (int i = 1; i < (1 << m); i++) {
                DisjointSetUnion dsu = new DisjointSetUnion(badVertices.size());
                HashMap<Integer, Integer> keepDegreeCount = new HashMap<Integer, Integer>();
                HashSet<Integer> coveredVertices = new HashSet<Integer>();
                int numberOfEdges = 0;
                boolean flag = false;
                for (int j = 0; j < m; j++) {
                    if (keepPair[i][j]) {
                        boolean allowed = dsu.Union(vertexHash[badEdges[j][0]], vertexHash[badEdges[j][1]]);
                        if((keepDegreeCount. containsKey(vertexHash[badEdges[j][0]]) && keepDegreeCount.get(vertexHash[badEdges[j][0]])>= 2) || (keepDegreeCount.containsKey(vertexHash[badEdges[j][1]]) && keepDegreeCount.get(vertexHash[badEdges[j][1]])>= 2) || !allowed) {
                            flag = true;
                            break;
                        }
                        numberOfEdges++;
                        if (!keepDegreeCount.containsKey(vertexHash[badEdges[j][0]])) {
                            keepDegreeCount.put(vertexHash[badEdges[j][0]], 1);
                        } else {
                            keepDegreeCount.put(vertexHash[badEdges[j][0]], keepDegreeCount.get(vertexHash[badEdges[j][0]]) + 1);
                        }
                        if (!keepDegreeCount.containsKey(vertexHash[badEdges[j][1]])) {
                            keepDegreeCount.put(vertexHash[badEdges[j][1]], 1);
                        } else {
                            keepDegreeCount.put(vertexHash[badEdges[j][1]], keepDegreeCount.get(vertexHash[badEdges[j][1]]) + 1);
                        }
                        coveredVertices.add(badEdges[j][0]);
                        coveredVertices.add(badEdges[j][1]);
                    }
                }
                if (flag) continue;
                HashSet<Integer> parents = new HashSet<Integer>();
                for (int v : coveredVertices) {
                    parents.add(dsu.Find(vertexHash[v]));
                }
                long currAns = (fact[n  - coveredVertices.size() + parents.size()] % MOD * (1L << parents.size()) % MOD)% MOD;
                fAns = (fAns % MOD + (numberOfEdges % 2 == 0 ? currAns : -currAns) % MOD) % MOD;
            }
            out.printLine(fAns);
        }
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