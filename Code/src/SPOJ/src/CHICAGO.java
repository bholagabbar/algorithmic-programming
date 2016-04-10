package SPOJ.src;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Shreyans on 4/21/2015 at 7:20 PM using IntelliJ IDEA (Fast IO Template)
 */

//ADD PUBLIC FOR CF,TC
class CHICAGO {
	public static void main(String[] args) throws Exception {
		class Node1 implements Comparator<Node1> {
			public int Node1;
			public int cost;
			
			public Node1() {
				
			}
			
			public Node1(int Node1, int cost) {
				this.Node1 = Node1;
				this.cost = cost;
			}
			
			@Override
			public int compare(Node1 Node11, Node1 Node12) {
				if (Node11.cost < Node12.cost) {
					return 1;
				}
				if (Node11.cost > Node12.cost) {
					return -1;
				}
				return 0;
			}
		}
		InputReader in = new InputReader(System.in);
		int v = in.readInt();
		while (v != 0) {
			List<ArrayList<Node1>> gr = new ArrayList<ArrayList<Node1>>();
			for (int i = 0; i <= v; i++) {
				gr.add(new ArrayList<Node1>());
			}
			int e = in.readInt(); //Entering Number of Edges
			int adjm[][] = new int[v + 1][v + 1];
			for (int i = 0; i < e; i++)//Entering <Vertex> <Adjacent Vertex> <Weight>
			{
				int a = in.readInt();
				int b = in.readInt();
				int c = in.readInt();
				gr.get(a).add(new Node1(b, c));
				gr.get(b).add(new Node1(a, c));//Undirected
				adjm[a][b] = adjm[b][a] = c;//Keeeping for track
			}//Built Graph
			int s = 1;
			int des = v;
			Queue<Node1> pq = new PriorityQueue<Node1>(new Node1());//Heap to extract value
			boolean[] checked = new boolean[v + 1];
			int[] d = new int[v + 1];//Keeping track of distances
			Arrays.fill(d, Integer.MIN_VALUE);
			int[] track = new int[v + 1];
			d[s] = 0;
			pq.clear();
			pq.add(new Node1(s, 0));
			while (!pq.isEmpty()) {
				Node1 x = pq.remove();
				int V = x.Node1;//Getting next Node1 from heap
				int W = x.cost;//Getting cost
				if (V == des) {
					break;
				}
				checked[V] = true;
				for (int i = 0; i < gr.get(V).size(); i++) {
					Node1 z = gr.get(V).get(i);
					if (!checked[z.Node1]) {
						int v1 = z.Node1;
						int w1 = z.cost;
						if (d[v1] < W + w1) {
							track[v1] = V;
							d[v1] = W + w1;
						}
						pq.add(new Node1(v1, d[v1]));
					}
				}
			}
			double ans = 100.0;
			while (des != s) {
				ans *= ((adjm[des][track[des]])) / 100.0;
				des = track[des];
			}
			System.out.printf("%.6f percent", ans);
			v = in.readInt(); //Entering Number of Vertices
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
		}
		
		public void printLine(Object... objects) {
			print(objects);
			writer.println();
		}
		
		public void close() {
			writer.close();
		}
		
		public void flush() {
			writer.flush();
		}
	}
}
