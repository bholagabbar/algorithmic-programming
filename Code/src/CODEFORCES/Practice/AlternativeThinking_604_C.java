import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.InputMismatchException;

/**
 * Created by Shreyans Sheth [bholagabbar] on 12/8/2015 at 3:01 PM using IntelliJ IDEA (Fast IO Template)
 */

public class AlternativeThinking_604_C {
//   Overkill solution i had thought of but couldn't implement:
//
//        #include <bits/stdc++.h>
//    using namespace std;
//    const int N = 1e5 + 5;
//    int n;
//    int arr[N];
//    string str;
//    int pre0[N];
//    int pre1[N];
//    int suf0[N];
//    int suf1[N];
//    int ans = 1;
//    int main(){
//        cin >> n;
//        cin >> str;
//        for(int i = 1 ; i <= n ; ++i){
//            arr[i] = str[i - 1] - '0';
//        }
//        pre0[0] = pre1[0] = 0;
//        for(int i = 1 ; i <= n ; ++i){
//            pre0[i] = pre0[i - 1];
//            pre1[i] = pre1[i - 1];
//            if(arr[i]){
//                pre1[i] = max(pre1[i] , pre0[i] + 1);
//            }
//            else{
//                pre0[i] = max(pre0[i] , pre1[i] + 1);
//            }
//        }
//        suf0[n + 1] = suf1[n + 1] = 0;
//        for(int i = n ; i >= 1 ; --i){
//            suf0[i] = suf0[i + 1];
//            suf1[i] = suf1[i + 1];
//            if(arr[i]){
//                suf1[i] = max(suf1[i] , suf0[i] + 1);
//            }
//            else{
//                suf0[i] = max(suf0[i] , suf1[i] + 1);
//            }
//        }
//        int len = 1;
//        int strt = 1;
//        arr[n + 1] = arr[n];
//        for(int i = 2 ; i <= n + 1 ; ++i){
//            if(arr[i] != arr[i - 1]){
//                ++len;
//            }
//            else{
//                if(arr[strt] == 0 && arr[i - 1] == 0){
//                    ans = max(ans , pre0[strt - 1] + suf0[i] + len);
//                }
//                else if(arr[strt] == 0 && arr[i - 1] == 1){
//                    ans = max(ans , pre0[strt - 1] + suf1[i] + len);
//                }
//                else if(arr[strt] == 1 && arr[i - 1] == 0){
//                    ans = max(ans , pre1[strt - 1] + suf0[i] + len);
//                }
//                else{
//                    ans = max(ans , pre1[strt - 1] + suf1[i] + len);
//                }
//                strt = i;
//                len = 1;
//            }
//        }
//        printf("%d\n" , ans);
//    }
	
	
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("E:/Shreyans/Documents/Code/CODE/SPOJ/Stdin_File_Read.txt"));
		InputReader in = new InputReader(System.in);
		OutputWriter out = new OutputWriter(System.out);
		int n = in.readInt();
		char[] a = in.readString().toCharArray();
		ArrayList<Integer> comp = new ArrayList<Integer>();
		int cnt = 1;
		for (int i = 1; i < a.length; i++) {
			if (a[i] == a[i - 1]) {
				cnt++;
			} else {
				comp.add(cnt);
				cnt = 1;
			}
		}
		comp.add(cnt);
		int max = 0;
		cnt = 0;
		for (int i : comp) {
			max = Math.max(max, i);
			if (i == 2) {
				cnt++;
			}
		}
		if (max >= 3 || cnt >= 2) //To prove the 1st, just flip the mid bit in the flip subs. For the second, start and the second bit of the 1st 00 and end at the 2nd last of 00. (Could be 1s also)
		{
			out.printLine(comp.size() + 2);
		} else if (cnt == 1) {
			out.printLine(comp.size() + 1);
		} else {
			out.printLine(comp.size());
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