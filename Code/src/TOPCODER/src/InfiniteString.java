/**
 * Created by Shreyans on 5/5/2015 at 9:08 PM using IntelliJ IDEA (Fast IO Template)
 */

//ADD PUBLIC FOR CF,TC
public class InfiniteString {
	public static void main(String[] args) throws Exception {
		
	}
	
	public static String equal(String a, String b) {
		String x = "", y = "";
		for (int i = 0; i < b.length(); i++) {
			x += a;
		}
		for (int i = 0; i < a.length(); i++) {
			y += b;
		}
		System.out.println(x + "\n" + y);
		if (x.equals(y)) {
			return "Equal";
		} else {
			return "Not equal";
		}
	}
}