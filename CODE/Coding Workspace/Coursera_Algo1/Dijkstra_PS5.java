import java.io.FileInputStream;
import java.util.*;

/**
 * Created by Shreyans Sheth [bholagabbar]
 */

class Dijkstra_PS5
{
    static class Node
    {
        int v,w;
        Node(int v, int w)
        {
            this.v=v;this.w=w;
        }
    }

    private static int[] Dijkstra(ArrayList<ArrayList<Node>> gr, int s)
    {
        boolean []vis=new boolean[201];
        int []dist=new int[201];
        Arrays.fill(dist,1000000);
        Arrays.fill(vis,false);
        TreeSet<Node> ts=new TreeSet<Node>(new Comparator<Node>()
        {
            @Override
            public int compare(Node o1, Node o2)
            {
                if(o1.w!=o2.w)
                    return o1.w-o2.w;
                return o2.v-o1.v;//Does not remove entries with same weight but different vertices
            }
        });
        ts.add(new Node(s,0));
        while(!ts.isEmpty())
        {
            Node x=ts.pollFirst();
            int cv=x.v,cw=x.w;
            vis[cv]=true;
            for(Node y:gr.get(cv))
                if(!vis[y.v])
                    if(y.w+cw<dist[y.v])
                    {
                        dist[y.v]=y.w+cw;
                        ts.add(new Node(y.v,dist[y.v]));
                    }
        }
        return dist;
    }

    public static void main(String[] args) throws Exception
    {
        System.setIn(new FileInputStream("E:/Shreyans/Coursera Algos 1/Week 5/dijkstraData.txt"));
        Scanner sc=new Scanner(System.in);
        ArrayList<ArrayList<Node>> gr= new ArrayList<ArrayList<Node>>();
        String x;
        for(int i=0;i<=200;i++)//For parsing SHIT input format
        {
            gr.add(new ArrayList<Node>());
            x=sc.next();
            while(x.contains(","))
            {
                String[]xi=x.split(",");
                gr.get(i).add(new Node(Integer.parseInt(xi[0]), Integer.parseInt(xi[1])));
                x=sc.next();
            }
        }
        int[] dist=Dijkstra(gr,1);
        int[] iv={7,37,59,82,99,115,133,165,188,197};
        for(int i:iv)
        {
            System.out.print(dist[i]);
            if(i!=197)
                System.out.print(",");
        }
        System.out.println();
    }
}