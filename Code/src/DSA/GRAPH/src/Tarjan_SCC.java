import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

class Tarjan_SCC
{

    //Data-Structures Used. Declaring global to avoid passing in parameter
    static int n=875715;
    static int tm=0;
    static ArrayList<ArrayList<Integer>>a=new ArrayList<ArrayList<Integer>>(); //Graph as adjacency list
    static int[] low=new int[n]; //Lowest node reachable from given node
    static int[] disc=new int[n]; //Stores order in which node was discovered
    static Stack<Integer>s=new Stack<Integer>(); //Stack to store the members of a SSC
    static boolean[] InStack=new boolean[n]; //To check if element is in the stack
    static ArrayList<Integer>SCCSize=new ArrayList<Integer>();

    private static void DFS(int x) //Modded DFS for Tarjan
    {
        low[x]=disc[x]=++tm; //Time discovered
        s.push(x); //Pushing element onto stack
        InStack[x]=true; //Current element is in the stack
        for(int i:a.get(x)) //Iterating through vertices of current node
        {
            if(disc[i]==-1)
            {
                DFS(i);//Recursively executing DFS on this node
                low[x]=Math.min(low[x], low[i]); //Lowest ancestor node reachable (Tree Edge)
            }
            else if(InStack[i]) //Checking if it is not a cross edge (should be Back Edge)
                low[x]=Math.min(low[x], disc[i]); //Lowest ancestor reachable
        }

        ArrayList<Integer>sz=new ArrayList<Integer>(); //Storing the SSCs nodes here
        if(low[x]==disc[x]) //Head of the SCC found
        {
            while(s.peek()!=x)
            {
                int y=s.pop(); //Getting the element
                InStack[y]=false; //Now not in stack
                sz.add(y); //Adding to data
            }
            //For last element
            int y=s.pop();
            InStack[y]=false;
            sz.add(y);
            SCCSize.add(sz.size());
        }
    }

    private static void Tarjan()
    {
        for(int i=1;i<n;i++) //Initializing values
        {
            low[i]=disc[i]=-1;
            InStack[i]=false;
        }
        for(int i=1;i<n;i++)
            if(disc[i]==-1) //Node not discovered as yet
                DFS(i); //Run DFS on this
    }

    public static void main(String[] args) throws IOException
    {
        System.setIn(new FileInputStream("E:/Shreyans/Coursera Algos 1/Week 4/SCC.txt"));
        double ts=System.currentTimeMillis()/1000d;
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<=n;i++)
            a.add(new ArrayList<Integer>());
        int tc=5105043;
        for(int i=1;i<=tc;i++)
        {
            int x=sc.nextInt(),y=sc.nextInt();
            a.get(x).add(y);
        }
        Tarjan();
        Collections.sort(SCCSize, Collections.reverseOrder());
        for(int i=0;i<5;i++) //Printing size of 5 largest SCCs along with data
        {
            System.out.print(SCCSize.get(i));
            if(i<4)
                System.out.print(",");
        }
        System.out.println();
        double te=System.currentTimeMillis()/1000d;
        System.out.println("["+(float)(te-ts)+" secs]");
    }
}