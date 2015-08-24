import java.io.*;
class TEST
{
    public static void main(String args[])throws IOException
    {
        int var;
        int i=0;
        int dat[]=new int[100];
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        var=Integer.parseInt(br.readLine());
        while((var!=42)&&(var<100))
        {
            dat[i]=var;
            i++;
            var=0;
            var=Integer.parseInt(br.readLine());
        }
        for(int j=0;j<i;j++)
        {
            System.out.println(dat[j]);
        }
    }
}
