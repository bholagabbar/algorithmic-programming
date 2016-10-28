package CODEFORCES.DIV2_365;

import java.io.*;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Set;

/**
 * Shreyans Sheth [bholagabbar | http://shreyans-sheth.me]
 * 8/4/2016
 */

public class B {
    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("E:/Shreyans/Documents/Code/CODE/src/input.txt"));
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);
        int n = in.readInt();
        int k = in.readInt();
        int [] cityCost = new int[n + 1];
        boolean[] isCapital = new boolean[n + 1];
        Set<Integer> captials = new HashSet<Integer>();
        for (int i = 1; i <= n; i++) {
            cityCost[i] = in.readInt();
        }
        for (int i = 1; i <= k; i++) {
            int c = in.readInt();
            isCapital[c] = true;
            captials.add(c);
        }
        long normalSum = 0;
        long capitalSum = 0;
        for (int i = 1; i <= n; i ++) {
            if (!isCapital[i]) {
                normalSum += cityCost[i];
            } else {
                capitalSum += cityCost[i];
            }
        }
        
        //calculate total from all capital cities to only normal cities
        long capNormal = 0;
        for (Integer i : captials) {
            capNormal+= (long)cityCost[i] * normalSum; 
        }
        
        //calculate inter capital costs W/O over counting
        long capCap = 0;
        for (Integer i : captials) {
            capCap += cityCost[i] * (capitalSum - cityCost[i]);
        }
        capCap /= 2;
        
        //calculate normal to normal only
        long normalNormal = 0;
        for (int i = 1; i < n; i++) {
            if (!isCapital[i] && !isCapital[i+1]) {
                normalNormal += cityCost[i] * cityCost[i + 1];
            }
        }
        if (!isCapital[n] && !isCapital[1]) {
            normalNormal += cityCost[1] * cityCost[n];
        }
        
        long finalCost = capNormal + capCap + normalNormal;
        System.out.println(finalCost);
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