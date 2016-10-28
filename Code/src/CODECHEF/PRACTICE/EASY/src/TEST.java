package CODECHEF.PRACTICE.EASY.src;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.*;

import static CODECHEF.PRACTICE.EASY.src.MSTICK.arr;

/**
 * Created by Shreyans Sheth [bholagabbar] on 11/14/2015 at 2:15 AM using IntelliJ IDEA (Fast IO Template)
 */

class TEST {
	
	
	private static class ListNode {
		public int val;
		public ListNode next;
		ListNode(int x) { 
			val = x;
			next = null; 
		}
	}

	public static ListNode mid = null;

	private static ListNode reverse(ListNode head) {
		ListNode curr = head;
		ListNode prev = null;
		ListNode next = null;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		head = prev;
		return head;
	}

	private static int lengthOfList(ListNode head) {
		ListNode curr = head;
		int cnt = 0;
		while (curr != null) {
			cnt++;
			curr = curr.next;
		}
		return cnt;
	}

	private static ListNode deleteOddList(ListNode head, int cnt) {
		ListNode prevHead = new ListNode(head.val);
		prevHead.next = head.next;
		ListNode prev = null;
		int xcnt = cnt/2;
		int currCount = 0;
		while (head != null) {
			if (currCount == xcnt) {
				ListNode temp = head;
				//store the mid val incase removed
				mid  = new ListNode(temp.val);
				mid.next = temp.next;
				prev.next = temp.next;
				head = prev;
			}
			currCount++;
			prev = head;
			head = head.next;
		}
		head = prevHead;
		return head;
	}

	private static void printList(ListNode head) {
		ListNode curr = head;
		while (curr != null) {
			System.out.print(curr.val+" ");
			curr = curr.next;
		}
		System.out.println();
	}

	public static int lPalin(ListNode A) {
		int length = lengthOfList(A);
		if (length == 1) {
			return 1;
		}
		if (length % 2 == 1) {
			A = deleteOddList(A, length);
		}
		ListNode fHead = new ListNode(A.val);
		fHead.next = A.next;
		ListNode f = A, s = null;
		int cnt = 0;
		if (length > 3) {
			while (cnt < (length / 2) - 1) {
				f = f.next;
				cnt++;
			}
			s = new ListNode(f.next.val);
			s.next = f.next.next;
			f.next = null;
			f = fHead;
			s = reverse(s);
		} else if (length == 3){
			s = f.next.next;
			f.next = null;
			s = reverse(s);
		} else if (length == 2) {
			s = new ListNode(f.next.val);
			f.next = null;
		}
		while (f != null) {
			if (f.val != s.val) {
				return 0;
			}
			f = f.next;
			s = s.next;
		}
		return 1;
	}


	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("E:/Shreyans/Documents/Code/CODE/SPOJ/Stdin_File_Read.txt"));
		InputReader in = new InputReader(System.in);
		OutputWriter out = new OutputWriter(System.out);
		
		ListNode a = new ListNode(2);
		ListNode b = new ListNode(3);
		ListNode c = new ListNode(2);
		ListNode d = new ListNode(5);
		ListNode e = new ListNode(1);
		
		a.next = b;
		b.next = c;
//		c.next = d;
//		d.next = e;
		c.next = null;
		printList(a);
		
		System.out.println(lPalin(a));
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