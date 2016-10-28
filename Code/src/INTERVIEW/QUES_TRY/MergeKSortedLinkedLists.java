package INTERVIEW.QUES_TRY;

import java.io.*;
import java.util.InputMismatchException;
import java.util.PriorityQueue;

/**
 * Shreyans Sheth [bholagabbar | http://shreyans-sheth.me]
 * 10/25/2016
 */

class MergeKSortedLinkedLists {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    static class Node implements Comparable<Node>{
        int val;
        ListNode ref;
        Node(int val, ListNode ref) {
            this.val = val;
            this.ref = ref;
        }

        @Override
        public int compareTo(Node O) {
            return Integer.compare(this.val, O.val);
        }
    }

    public static void printList(ListNode l) {
        ListNode curr = l;
        while (curr != null) {
            System.out.print(curr.val+" ");
            curr = curr.next;
        }
    }
    

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null)
                pq.add(new Node(lists[i].val, lists[i]));
        }
        ListNode curr = null, head = null;
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (curr == null) {
                curr = new ListNode(now.val);
                head = curr;
            } else {
                curr.next = new ListNode(now.val);
                curr = curr.next;
            }
            ListNode toInsert = now.ref.next;
            if (toInsert != null) {
                pq.add(new Node(toInsert.val, toInsert));
            }
        }
        return head;
    }
    
    
    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("E:/Shreyans/Documents/algorithmic-programming/CODE/src/input.txt"));
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);
        ListNode[] a = new ListNode[1];
        a[0] = new ListNode(0);
        a[0].next = new ListNode(2);
        a[0].next.next = new ListNode(5);
        printList(mergeKLists(a));

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