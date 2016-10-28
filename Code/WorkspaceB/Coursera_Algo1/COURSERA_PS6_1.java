import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

class COURSERA_PS6_1
{
    public static void main(String[] args) throws IOException
    {
        //System.setIn(new FileInputStream("E:\\Shreyans\\Coursera Algos 1\\Week 6\\prob1.txt"));
        System.setIn(new FileInputStream("E:/Shreyans/Documents/Code/CODE/SPOJ/Stdin_File_Read.txt"));
        Scanner in=new Scanner(System.in);
        TreeSet<Long>ts=new TreeSet<Long>();//For computing distinct entries in sorted order
        TreeMap<Long,Integer> tm=new TreeMap<Long,Integer>();//Stores element , index
        ArrayList<Long>al=new ArrayList<Long>();//Stores the numbers in sorted order
        HashSet<Long>hs=new HashSet<Long>();//For storing all answer between -10000 and 10000
        int cnt=0;
        for(int i=0;i<20;i++)//Sorted in increasing order with indices
            ts.add(in.nextLong());
        //System.out.println(ts);
        for(long i:ts)
        {
            tm.put(i,cnt++);
            al.add(i);
        }
        //System.out.println(ts);
        for(long i:tm.keySet())
        {
            Long x1=tm.floorKey(10000 - i);
            Long x2=tm.ceilingKey(-10000 - i);
            if(x1!=null && x2!=null)
            {
                Integer ind1=tm.get(x1),ind2=tm.get(x2);
                //System.out.println(i+" "+x1+" "+ind1+" "+x2+" "+ind2);
                for(int j=Math.min(ind1,ind2);j<=Math.max(ind1,ind2);j++)
                    if(al.get(j)!=i)
                        hs.add(i+al.get(j));
            }
        }
        System.out.print(hs.size());
    }
}