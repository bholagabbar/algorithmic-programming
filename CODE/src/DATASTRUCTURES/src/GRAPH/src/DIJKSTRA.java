import java.util.*;

/**
 * Created by Shreyans on 4/21/2015 at 6:32 PM using IntelliJ IDEA (Fast IO Template)
 */

class DIJKSTRA
{
    static class Node implements Comparator<Node>
    {
        public int node;
        public int cost;

        public Node(){}

        public Node(int node, int cost)
        {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compare(Node node1, Node node2)
        {
            if (node1.cost < node2.cost)
                return -1;
            if (node1.cost > node2.cost)
                return 1;
            return 0;
        }
    }
    public static void main(String[] args) throws Exception
    {
        Scanner sc=new Scanner(System.in);
        List<ArrayList<Node>> gr=new ArrayList<ArrayList<Node>>();//Initialising Adj list to store graph
        System.out.println("Enter Number of Vertices");
        int v=sc.nextInt();
        for(int i=0;i<=v;i++)
        {
            gr.add(new ArrayList<Node>());
        }
        System.out.println("Enter Number of Edges");
        int e=sc.nextInt();
        System.out.println("Enter <Vertex> <Adjacent Vertex> <Weight>");
        for(int i=0;i<e;i++)
        {
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=sc.nextInt();
            gr.get(a).add(new Node(b,c));
        }//Built Graph
        System.out.println("Enter Source");
        int s=sc.nextInt();
        //int des=sc.nextInt();//Entering Destination
        Queue<Node> pq=new PriorityQueue<Node>(new Node());//Heap to extract value
        boolean[]checked=new boolean[v+1];//Keeping track of checked values
        int[]d=new int[v+1];//Keeping track of distances
        Arrays.fill(d,Integer.MAX_VALUE);
        d[s]=0;
        pq.clear();
        pq.add(new Node(s,0));
        while(!pq.isEmpty())
        {
            Node x=pq.poll();
            int V=x.node;//Getting next node from heap
            int W=x.cost;//Getting cost
            checked[V]=true;
            for(int i=0;i<gr.get(V).size();i++)
            {
                Node z=gr.get(V).get(i);//Getting all adjacent Vertices
                if(!checked[(z.node)])//Not checking visited Vertices
                {
                    int v1=z.node;
                    int w1=z.cost;
                    if(d[v1]>W+w1)//Checking for min weight
                    {
                        d[v1]=W+w1;
                    }
                    pq.offer(new Node(v1,d[v1]));//Adding element to PriorityQueue
                }
            }
        }
        for(int i=1;i<=v;i++)//Printing Shortest Distances. Ignore ones with Integer.MAX_VALUE
        {
            if(d[i]==Integer.MAX_VALUE)
            {
                System.out.println("No Path connecting Source Vertex "+s+" to Vertex "+i);
            }
            else
            {
                System.out.println("Shortest distance from  Source Vertex "+s+" to Vertex "+i+" is: "+d[i]);
            }
        }
    }
}
