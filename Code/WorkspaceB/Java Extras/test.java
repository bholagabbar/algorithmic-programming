/*input
1 2 3 4 5
*/
import java.io.*;
import java.util.*;
import java.math.*;

class test {
	public static void main(String[] args) {
		int n = 5;
		int[] array = new int[n];
		ArrayList<Integer> myArrayList = new ArrayList<Integer>();
		myArrayList.add(1);
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < n; i++) {
			array[i] = sc.nextInt();
		}
		TestTwo newObject = new TestTwo();
		newObject.printHello();
	}
}

class TestTwo {
	public void printHello() {
		System.out.println("Piyush is a 10 pointer");
	}
}