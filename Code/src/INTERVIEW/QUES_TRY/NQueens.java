package INTERVIEW.QUES_TRY;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;

/**
 * Shreyans Sheth [bholagabbar | http://shreyans-sheth.me]
 * 10/8/2016
 */

class NQueens {

    
    private static ArrayList<ArrayList<String>> ans;
    static char[][] board;
    private static int N;
    
    
    public static boolean check(int row, int col) {
        int i, j;
        
        for (i = 0; i < col; i++) {
            if (board[row][i] == 'Q') {
                return false;
            }
        }
        
        for (i=row, j=col; i>=0 && j>=0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        
        for (i=row, j=col; j>=0 && i<N; i++, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }
    
    public static void Rec(int col) {
        if (col == N) {
            ArrayList<String> curr = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                String nowStr = "";
                for (int j = 0; j < N; j++) {
                    nowStr += Character.toString(board[i][j]);
                }
                curr.add(nowStr);
            }
            ans.add(curr);
        }
        
        for (int p = 0; p < N; p++) {
            if (check(p, col)) {
                board[p][col] = 'Q';
                Rec(col + 1);
                board[p][col] = '.';
            }
        }
        
    }
    
    public static ArrayList<ArrayList<String>> solveNQueens(int a) {
        ans = new ArrayList<>();
        board = new char[a][a];
        for (int i = 0;i < a; i++) {
            for (int j = 0; j < a; j++) {
                board[i][j] = '.';
            }
        }
        N = a;
        Rec(0);
        return ans;
    }
    
    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("E:/Shreyans/Documents/Code/CODE/src/input.txt"));
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);
//        ArrayList<ArrayList<String>> ans = solveNQueens(5);
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