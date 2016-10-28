package CODEFORCES.DIV2_377;

import java.io.*;
import java.util.InputMismatchException;

/**
 * Shreyans Sheth [bholagabbar | http://shreyans-sheth.me]
 * 10/17/2016
 */

class C {
    
    static long beforeMorningOrAfterDinner(long x, long y, long z) {
        long ans;
        if (x == y || y == z || x == z) {
            if (x == y) {
                if (x > z) {
                    ans = x - z - 1;
                } else {
                    ans = z - x;
                }
            } else if (x == z) {
                ans = Math.abs(x - y);
            } else {
                if (x > y) {
                    ans = y - 1;
                } else {
                    ans = Math.abs(y - x);
                }
            }
        } else {
            ans = Math.max(x, Math.max(y, z));
            if (z == 0 && x > y) {
                ans--;
            }
        }
        return ans;
    }
    
    static long afterBreakfast(long x, long y, long z) {
        long ans;
        if (x == y || y == z || x == z) {
            if (x == y) {
                if (z > x) {
                    ans = Math.abs(z - x);
                } else {
                    ans = Math.abs(z - x) - 1;
                }
            } else if (x == z) {
                ans = Math.abs(y - x);
            } else {
                if (x > y) {
                    ans = y - 1;
                } else {
                    ans = Math.abs(y - x);
                }
            }
        } else {
            ans = Math.max(x, Math.max(y, z));
            if (x == 0) {
                ans--;
            }
        }
        return ans;
    }
    
    static long afterSupper(long x, long y, long z) {
        long ans = Math.max(x, Math.max(y, z));
        if (z == 0) {
            ans++;
        } else if (y == 0) {
            ans--;  
        }
        return ans;
    }
    
    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("E:/Shreyans/Documents/algorithmic-programming/CODE/src/input.txt"));
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);
        long x = in.readLong();
        long y = in.readLong();
        long z = in.readLong();
        long min = Math.min(x, Math.min(y, z));
        x -= min;
        y -= min;
        z -= min;
        if (x == y && y == z) {
            out.printLine(0);
        } else {
            long f1 = beforeMorningOrAfterDinner(x, y, z);
            long f2 = afterBreakfast(x, y, z);
            long f3 = afterSupper(x, y, z);
            long ans = Math.min(f1, Math.min(f2, f3));
            out.printLine(ans);
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