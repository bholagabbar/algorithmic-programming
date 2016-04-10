import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

class BFS_IMP_2 {
	private static int v;//used in both methods
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		HashMap<Integer, List<Integer>> g1 = new HashMap<Integer, List<Integer>>();
		System.out.println("Enter no of Vertices and Edges");
		v = sc.nextInt();
		int e = sc.nextInt();
		System.out.println("Enter Edges <Source> <Destination>");
		for (int i = 0; i < e; i++) {
			int x = sc.nextInt();
			if (!g1.containsKey(x)) {
				List<Integer> tm = new ArrayList<Integer>();
				tm.add(sc.nextInt());
				g1.put(x, tm);
			} else {
				List<Integer> tm1 = g1.get(x);
				tm1.add(sc.nextInt());
			}
		}
		System.out.println("Enter source for BFS");
		int s = sc.nextInt();
		BFS(g1, s);
	}
	
	private static void BFS(HashMap<Integer, List<Integer>> g1, int src) {
		Set<Integer> visited = new HashSet<Integer>();
		Queue<Integer> q = new LinkedList<Integer>();
		visited.add(src);
		q.add(src);
		int cnt = 0;
		while (q.size() != 0) {
			int rv = q.poll();
			System.out.print((rv) + " ");
			if (g1.containsKey(rv)) {
				List<Integer> sg = g1.get(rv);
				for (int a : sg) {
					if (!visited.contains(a)) {
						q.add(a);
						visited.add(a);
					}
				}
				cnt++;
			}
			if (cnt == v)//Since all the vertices having edges has been checked, breakout
			{
				break;
			}
		}
	}
}