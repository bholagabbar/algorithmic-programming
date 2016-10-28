package INTERVIEW.QUES_TRY;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;

/**
 * Shreyans Sheth [bholagabbar | http://shreyans-sheth.me]
 * 10/14/2016
 */

class TrieShortestUniquePrefix {

    private static class TrieNode {
        int cnt;
        char val;
        TrieNode[] next;
        TrieNode() {
            cnt = 0;
            next = new TrieNode[26];
        }
        TrieNode(char val) {
            cnt = 1;
            this.val = val;
            next = new TrieNode[26];
        }
    }

    private static TrieNode trieHead;

    private static void insertIntoTrie(String toInsert) {
        TrieNode currNode = trieHead;
        for (int i = 0; i < toInsert.length(); i++) {
            char currChar = toInsert.charAt(i);
            int valToInsert = currChar - 97;
            if (currNode.next[valToInsert] == null) {
                currNode.next[valToInsert] = new TrieNode(currChar);
            } else {
                currNode.next[valToInsert].cnt++;
            }
            currNode = currNode.next[valToInsert];
        }
    }
    
    private static String queryTrie(String toFind) {
        StringBuilder prefix = new StringBuilder();
        TrieNode currNode = trieHead;
        int i = 0;
        while (i < toFind.length() && currNode.next[toFind.charAt(i) - 97].cnt > 1) {
            prefix.append(Character.toString(toFind.charAt(i)));
            currNode = currNode.next[toFind.charAt(i) - 97];
            i++;
        }
        prefix.append(Character.toString(toFind.charAt(i)));
        return prefix.toString();
    }

    public static ArrayList<String> prefix(ArrayList<String> a) {
        trieHead = new TrieNode();
        for (String curr : a) {
            insertIntoTrie(curr);
        }
        ArrayList<String> ans = new ArrayList<>();
        for (String curr : a) {
            ans.add(queryTrie(curr));
        }
        return ans;
    }
    
    
    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("E:/Shreyans/Documents/Code/CODE/src/input.txt"));
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);
        ArrayList<String> ans = prefix(new ArrayList<>(Arrays.asList("zebra", "dog", "duck", "dove")));
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