package INTERVIEW.QUES_TRY;

import java.io.*;
import java.util.Arrays;
import java.util.InputMismatchException;

/**
 * Shreyans Sheth [bholagabbar | http://shreyans-sheth.me]
 * 10/27/2016
 */

class MinNumOfCoveringIntervals {

    static class Interval implements Comparable<Interval> {
        int start;
        int end;
        Interval(int s,  int e)  {
            start  =  s;
            end  =  e;
        }
        public String toString()  {
            return String.format("%d %d" ,start, end);
        }
        @Override
        public int compareTo(Interval o) {
            if(start!= o.start)
            return start  -  o.start;
			else
            return end  -  o.end;
        }
    }

    static int minNumberOfIntervals(Interval[] list, Interval interval) {
        Arrays.sort(list);
        System.out.println(Arrays.toString(list));
        int i = 0;
        int start = interval.start;
        int max = -1;
        int num = 0;
        while (i < list.length && max < interval.end) {
            if (list[i].end <= start)
                i++;
            else {
                if (list[i].start > start) {
                    break;
                }
                while (i < list.length && max < interval.end && list[i].start <= start) {
                    if (list[i].end > max) {
                        max = list[i].end;
                    }
                    i++;
                }
                if (start != max) {
                    start = max;
                    num++;
                }
            }
        }
        if (max < interval.end)
            return 0;
        return num;
    }
    
    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("E:/Shreyans/Documents/algorithmic-programming/CODE/src/input.txt"));
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);
        Interval[] x = {new Interval(0, 5),new Interval(4, 20),new Interval(5, 15),new Interval(5, 22),new Interval(6, 21), new Interval(7, 12), new Interval(9, 23), new Interval(13, 25)};
        minNumberOfIntervals(x, new Interval(6, 24));

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