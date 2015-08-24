import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class KragersMinCut
{
    static int n=200;//Number of Vertices
    static int[] u=new int[n];
    static int[]rank =new int[n];

    static class Edge //Edge which hols the source and destination
    {
        int s,d;//Source,Destination
        Edge(int s,int d)
        {
            this.s=s;
            this.d=d;
        }
    }

    private static void InitializeUnionFindData()
    {
        for(int i=0;i<n;i++)
        {
            u[i]=i;
            rank[i]=1;
        }
    }

    private static int FIND(int xx) //Finding Parent using Path-Compression Heuristics
    {
        if(u[xx]!=u[u[xx]])
        {
            u[xx]=FIND(u[xx]);
        }
        return u[xx];
    }

    private static boolean UNION(int x,int y) //Union by Order-by-Rank to create evenly balanced search trees
    {
    int px=FIND(x),py=FIND(y);
    if(rank[px]>rank[py])
    {
        int temp=px;
        px=py;
        py=temp;
    }
    else if(rank[px]==rank[py])
        rank[py]++;

    u[px]=py;
    return true;
    }


    public static void main(String[] args) throws IOException
    {
        System.setIn(new FileInputStream("E:/Shreyans/Coursera Algos 1/Week 3/Graphs and the Contraction Algorithm/KMinCut.txt"));
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Edge> EdgeList=new ArrayList<Edge>();
        for(int i=0;i<n;i++)
        {
            String x=br.readLine();
            ArrayList<Integer>al=new ArrayList<Integer>();
            for(int j=0;j<x.length();j++) //This loop is for parsing the SHIT input format
            {
                if(x.charAt(j)<48 || x.charAt(j)>57)
                    continue;

                int p=j;
                String input="";
                while(p!=x.length()&&(x.charAt(p)>=48 && x.charAt(p)<=57))
                {
                    input+=(x.charAt(p));
                    p++;
                }
                j=p;
                al.add(Integer.parseInt(input.trim())-1);
            }
            for(int j=1;j<al.size();j++)
            {
                EdgeList.add(new Edge(al.get(0),al.get(j)));//Source,Destination
            }
        }
        //Edge list ready
        int MinCut=Integer.MAX_VALUE;
        for(int q=0;q<(n*n)*Math.log(n);q++)//Running theta(n^2*ln(n)) times for a good estimate. Runs in about 20 secs
        {
            int vcnt=n;//Essentially n
            InitializeUnionFindData();
            while(vcnt>2)
            {
                Edge x=EdgeList.get((int)(Math.random()*(EdgeList.size())));//Obtaining random valued element at index from EdgeList
                int s=x.s,d=x.d;
                int ps=FIND(s),pd=FIND(d);
                if(ps!=pd)//Contracting. Essentially making their parents equal
                {
                    UNION(s,d);
                    vcnt--;
                }
            }
            int CurrMinCutValue=0;
            for(Edge i:EdgeList)
            {
                int px=FIND(i.s),py=FIND(i.d);
                if(px!=py)//Since they belong to different Vertices
                {
                    CurrMinCutValue++;
                }
            }
            //IMPORTANT OBSERVATION: Every edge occurs twice. Hence divide by 2
            MinCut=Math.min(MinCut,CurrMinCutValue/2);//Finding Minimum cut of all random runs
        }
        System.out.println(MinCut);
    }
}