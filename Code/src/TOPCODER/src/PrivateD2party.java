/**
 * PROBLEM STATEMENT
 * Hero is inviting his friends to the party.
 * He has n friends, numbered 0 through n-1.
 * For each of his friends there is at most one other person the friend dislikes.
 * You are given this information as a int[] a with n elements.
 * For each i, a[i] is either the number of the person disliked by friend i, we have a[i]=i if friend
 * i likes everybody else.
 * <p>
 * Hero is inviting his friends one at a time.
 * Whenever he invites friend i, they will accept if and only if the friend a[i] didn't accept an
 * earlier invitation.
 * (That includes two cases: either Hero didn't invite friend a[i] yet, or he did but the friend
 * rejected the invitation.)
 * <p>
 * Hero noticed that the order in which he invites his friends matters: different orders may produce
 * different numbers of accepted invitations.
 * <p>
 * Find an order that will produce the most accepted invitations, and return their number.
 * <p>
 * <p>
 * DEFINITION
 * Class:PrivateD2party
 * Method:getsz
 * Parameters:int[]
 * Returns:int
 * Method signature:int getsz(int[] a)
 * <p>
 * <p>
 * CONSTRAINTS
 * -a will contain exactly n elements.
 * -n will be between 1 and 50, inclusive.
 * -Each element of a will be between 0 and n - 1, inclusive.
 * <p>
 * <p>
 * EXAMPLES
 * <p>
 * 0)
 * {0,1}
 * <p>
 * Returns: 2
 * <p>
 * Each of the friends likes the other. Regardless of the order in which Hero asks them, they will
 * both accept the invitation.
 * <p>
 * 1)
 * {1,0}
 * <p>
 * Returns: 1
 * <p>
 * Friend 0 dislikes friend 1 and vice versa. The first friend Hero asks will accept the invitation
 * but then the other friend will certainly reject it.
 * <p>
 * 2)
 * {1,0,3,2}
 * <p>
 * Returns: 2
 * <p>
 * <p>
 * <p>
 * 3)
 * {5,2,2,4,5,0}
 * <p>
 * Returns: 5
 * <p>
 * Here is what would happen if Hero invited the friends in the order (0,1,2,3,4,5):
 * <p>
 * Friend 5 didn't accept yet, so friend 0 would accept.
 * Friend 2 didn't accept yet, so friend 1 would accept.
 * Friend 2 likes everybody and therefore they would accept.
 * Friend 4 didn't accept yet, so friend 3 would accept.
 * Friend 5 didn't accept yet, so friend 4 would accept.
 * Friend 0 did already accept, therefore friend 5 would reject.
 * <p>
 * It turns out that this solution happens to be optimal: there is no order such that all six friends
 * would accept the invitations.
 * <p>
 * 4)
 * {3,2,1,0,5,4}
 * <p>
 * Returns: 3
 **/

import java.util.ArrayList;
import java.util.List;

/**
 Created by Shreyans using IntelliJ IDEA and FileEdit Plugin [TOPCODER]
 **/

public class PrivateD2party {
	static boolean[] vis;
	static boolean onStack[];
	static List<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>();
	
	static boolean DFS(int s) {
		
		if (onStack[s]) {
			return false;
		}
		boolean flag = true;
		onStack[s] = true;
		for (int i : al.get(s)) {
			if (!vis[i]) {
				flag = flag & DFS(i);
			}
		}
		vis[s] = true;
		onStack[s] = false;
		return flag;
	}
	
	
	public static int getsz(int[] a) {
		int n = a.length;
		vis = new boolean[n];
		onStack = new boolean[n];
		for (int i = 0; i <= n; i++) {
			al.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < n; i++) {
			if (a[i] != i) {
				al.get(i).add(a[i]);
			}
		}
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			if (!vis[i]) {
				if (!DFS(i)) {
					cnt++;
				}
			}
		}
		System.out.println(n - cnt);
		return n - cnt;
	}
	
	public static void main(String args[]) {
		int[] a = {5, 2, 2, 4, 5, 0};
		getsz(a);
	}
}
