package INTERVIEW.QUES_TRY;

import java.io.*;
import java.util.InputMismatchException;

/**
 * Shreyans Sheth [bholagabbar | http://shreyans-sheth.me]
 * 10/21/2016
 */

class WildcardMatcher {

    public static boolean isMatch(String s, String p) {
        int pi = 0, si = 0, match = 0, ast = -1, which = -1;
        while (si < s.length()) {
            if (pi < p.length() && si < s.length()) {
                System.out.println(which+" "+pi+" "+p.charAt(pi)+" "+si+" "+s.charAt(si));
            } else {
                System.out.println(which+" pi="+pi+" si="+si+" ast="+ast+" match="+match);
            }
            if (pi < p.length() && (p.charAt(pi) == s.charAt(si) || p.charAt(pi) == '?')) {
                pi++;
                si++;
                which = 1;
            } else if (pi < p.length() && p.charAt(pi) == '*') {
                ast = pi;
                match = si;
                pi++;
                which = 2;
            } else if (ast != -1) {
                pi = ast + 1;
                match++;
                si = match;
                which = 3;
            } else {
                System.out.println("nOPE");
                return false;
            }
        }
        System.out.println(which+" pi="+pi+" si="+si+" ast="+ast+" match="+match);
        while (pi < p.length() && p.charAt(pi) == '*') {
            System.out.println("YOLO" + which+" pi="+pi+" si="+si+" ast="+ast+" match="+match);
            pi++;
        }
        return pi == p.length();
    }
    
    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("E:/Shreyans/Documents/algorithmic-programming/CODE/src/input.txt"));
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);
        boolean ans = isMatch("abcffe", "a?c*de");
        System.out.println(ans);

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