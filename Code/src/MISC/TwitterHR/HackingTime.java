package MISC.TwitterHR;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.InputMismatchException;

/**
 * Shreyans Sheth [bholagabbar | http://shreyans-sheth.me]
 * 28/10/16
 */

//public class for CF, TC
class HackingTime {


    static String decrypt(String encrypted_message) {
        String x = "Atvt hrqgse, Cnikg";
        String y = "Your friend, Alice";
        String z = "";
        for (int i = x.length() - 1; i >= 0; i--) {
            int curr = x.charAt(i);
            int ori = y.charAt(i);
            if ((ori >= 97 && ori <= 122) || (ori >= 65 && ori <= 90)) {
                if (curr >= 97 && curr <= 122) {
                    curr -= 97;
                    ori -= 97;
                } else {
                    curr -= 65;
                    ori -= 65;
                }
                int shift;
                if (curr < ori) {
                    shift = curr + 26 - ori;
                } else {
                    shift = curr - ori;
                }
                z += shift;
                String p1 = z.substring(0, z.length() / 2);
                String p2 = z.substring(z.length() / 2, z.length());
                if (p1.equals(p2)) {
                    break;
                }
            }
        }
        z = "8251220";
        int ind = 0;
        StringBuilder fans= new StringBuilder();
        for (int i = 0; i < encrypted_message.length(); i++) {
            int currChar = encrypted_message.charAt(i);
            if ((currChar >= 97 && currChar <= 122) || (currChar >= 65 && currChar <= 90)) {
                boolean isUpper = false;
                if (currChar >=65 && currChar <= 90) {
                    isUpper = true;
                }
                currChar = Character.toString((char)currChar).toLowerCase().charAt(0);
                int toShift = z.charAt(ind) - 48;
                String ff;
                if (currChar - toShift >= 97) {
                    ff = Character.toString((char)((currChar - toShift)));
                } else {
                    while (toShift != 0) {
                        currChar--;
                        toShift--;
                        if (currChar == 96) {
                            currChar = 122;
                        }
                    }
                    if (currChar == 96) {
                        currChar = 122;
                    }
                    ff = Character.toString((char)currChar);
                }
                String toAppend = isUpper ? ff.toUpperCase() : ff;
                fans.append(toAppend);
                ind++;
                if (ind == z.length()) {
                    ind = 0;
                }
            } else {
                fans.append(encrypted_message.charAt(i));
            }
        }
        String ans = fans.toString();
        System.out.println(ans);
        return ans;
    }

    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("/media/bholagabbar/Local Disk/Shreyans/Documents/algorithmic-programming/Code/src/input.txt"));
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);
        decrypt("Otjfvknou kskgnl, K mbxg iurtsvcnb ksgq hoz atv. Vje xcxtyqrl vt ujg smewfv vrmcxvtg rwqr ju vhm ytsf elwepuqyez. -Atvt hrqgse, Cnikg");

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