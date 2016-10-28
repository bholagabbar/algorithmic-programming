import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.TreeSet;

/**
 * Created by Shreyans Sheth [bholagabbar] on 5/22/2015 at 7:52 AM using IntelliJ IDEA (Fast IO Template)
 */

//ADD PUBLIC FOR CF,TC
class KRUSKAL {
	static int u[], rank[];
	
	static class Node {
		int v1, v2, w;
		
		Node(int x, int y, int z) {
			this.v1 = x;
			this.v2 = y;
			this.w = z;
		}
	}
	
	public static int FIND(int x)//Finding the parent of the current TreeNode. Path compression documentation below
	{
		if (u[x] != u[u[x]]) {
		    /*
            Finding the parent of each node. In the process, setting the parent
            of the current element and all the elements encountered in the
            recursive tree (essentially, all nodes below the parent) where the parent
            is the first element in the branch of the tree/ladder
            */
			u[x] = FIND(u[x]);
		}
		return u[x];
	}
	
	public static boolean UNION(int x, int y) // Setting the two parents of these nodes equal. Essentially, 'merging' the two sets :)
	{
		int px = FIND(x), py = FIND(y);//Parents of these nodes

        /*Without Union by rank. It's much easier to understand:

        int px=FIND(x),py=FIND(y);//Parents of these nodes
        if(px==py) return false;//Parents are equal. Don't merge

        u[px]=py;//Without Union by rank. Setting parents equals and merging sets as mentioned before
        return true;
        */
		
		//Union by rank
		if (px == py) {
			return false;//Parents are equal. Don't merge
		}
		
		if (rank[px] > rank[py]) {
			int temp = px;
			px = py;
			py = temp;
		}//Making sure rank of x is smaller. swap(a,b) is a std f'n in c++14
		
		else if (rank[px] == rank[py]) {
			rank[py]++; // if both are equal, the combined tree becomes 1 deeper
		}
		
		u[px] = py;//Setting parents equals and merging sets as mentioned before
		return true;
	}
	
	static void u_init(int l)//Initialising union array to elements itself first
	{
		for (int i = 1; i <= l; i++) {
			u[i] = i;
			rank[i] = 1;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s1 = br.readLine().split(" ");
		int n = Integer.parseInt(s1[0]);
		int m = Integer.parseInt(s1[1]);
		u = new int[n + 1];
		rank = new int[n + 1];
		u_init(n);
		TreeSet<Node> edges = new TreeSet<Node>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2)//Custom comparator
			{
				if (o1.w != o2.w) {
					return o1.w - o2.w;
				}
				return 1;//avoiding duplicate weights
			}
		});
		for (int i = 0; i < m; i++)//Building up Edge List
		{
			String[] s2 = br.readLine().split(" ");
			int x1 = Integer.parseInt(s2[0]);
			int y1 = Integer.parseInt(s2[1]);
			int w1 = Integer.parseInt(s2[2]);
			edges.add(new Node(x1, y1, w1));
		}
		long spt_sum = 0;//Spanning Tree Sum
		int ecnt = 0;
		while (ecnt != n - 1)//Edges in MST equals n-1. Duh
		{
			Node cur = edges.pollFirst();//Removing TreeNode from the list
			if (UNION(cur.v1, cur.v2))//If they don't belong to the same set
			{
				spt_sum += cur.w;
				ecnt++;
			}
		}
		System.out.println(spt_sum);
	}
}