package INTERVIEW.QUES_TRY;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;

/**
 * Shreyans Sheth [bholagabbar | http://shreyans-sheth.me]
 * 10/9/2016
 */

class RepeatingFractions {

    public static String fractionToDecimal(int numerator , int denominator) {
        long num = numerator;
        long den = denominator;
        int sign = 1;
        if ((num < 0 && den > 0) || (num > 0 && den < 0)) {
            sign = -1;
        }
        num = Math.abs(num);
        den = Math.abs(den);
        if (num == 0) {
            return "0";
        }
        if (den == 1) {
            return Long.toString(num * sign);
        }
        HashSet<Long> primes = new HashSet<>();
        long den2 = den;
        for (int i = 2; i <= Math.sqrt(den2); i++) {
            if (den2 % i == 0) {
                primes.add((long)i);
                while (den2 % i == 0) {
                    den2 /= i;
                }
            }
        }
        if (den2 > 1) {
            primes.add(den2);
        }
        System.out.println(primes);
        String fans;
        if ((primes.size() == 1 && (primes.contains((long)2) || primes.contains((long)5))) || (primes.size() == (long)2 && primes.contains((long)2) && primes.contains((long)5))) { //non recurring
            BigDecimal bg1 = new BigDecimal(num);
            BigDecimal bg2 = new BigDecimal(den);
            BigDecimal bg = bg1.divide(bg2);
            bg = bg.multiply(new BigDecimal(sign));
            return bg.toPlainString();
        } else {
            HashMap<String, Integer> map = new HashMap<>();
            BigDecimal bg1 = new BigDecimal(num);
            BigDecimal bg2 = new BigDecimal(den);
            BigDecimal bg = bg1.divide(bg2, 100, RoundingMode.CEILING);
            String cons = bg.toString();
            for (int i = 0; i < cons.length(); i++) {
                for (int j = i + 1; j <= cons.length(); j++) {
                    String currSub = cons.substring(i, j);
                    if (!map.containsKey(currSub)) {
                        map.put(currSub, 1);
                    } else {
                        map.put(currSub, map.get(currSub) + 1);
                    }
                }
            }
            String max = "";
            for (String x : map.keySet()) {
                if (map.get(x) > 1 && x.length() > max.length()) {
                    max = x;
                }
            }
            HashSet<Integer> lultry = new HashSet<>();
            String loluadd = "";
            for (int i = 0;i < max.length(); i++) {
                int now =  max.charAt(i) - 48;
                if (!lultry.contains(now)) {
                    lultry.add(now);
                    loluadd += now;
                } else {
                    break;
                }
            }
            max = loluadd;
            int toPut = cons.indexOf(max);
            String ans = "";
            if (sign < 0) {
                ans = "-";
            }
            for (int i = 0; i < toPut; i++) {
                ans += cons.charAt(i);
            }
            fans = ans + "(" + max + ")";
        }
        return fans;
    }
    
    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("E:/Shreyans/Documents/Code/CODE/src/input.txt"));
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);
        String ans = fractionToDecimal(87, 22);
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