import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Shreyans on 12/6/2014 in IntelliJ
 */
class CANDLE
    {
    public static void main(String[] args) throws IOException
        {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++)
            {
            int ans = 0;
            String[] y1 = br.readLine().split(" ");
            int min=Integer.parseInt(y1[0]);
            int in=0;
            String an="";
            for(int j=1;j<y1.length;j++)
                {
                if(Integer.parseInt(y1[j])<min)
                    {
                    in=j;
                    min=Integer.parseInt(y1[j]);
                    }
                }
            if(min==0)
                {
                if(in==0)
                    {
                    int flag = 0;
                    for (int j = 1; j < 10; j++)
                        {
                        if (Integer.parseInt(y1[j]) == 0)
                            {
                            System.out.println(j);
                            flag = 1;
                            break;
                            }
                        }
                    if(flag==0)
                        {
                        int min2 = Integer.parseInt(y1[1]);
                        int in2 = 1;
                        an = "";
                        for (int j = 2; j < 10; j++)
                            {
                            if (Integer.parseInt(y1[j]) < min2)
                                {
                                in2 = j;
                                min2 = Integer.parseInt(y1[j]);
                                }
                            }
                        for (int j = 0; j < min2; j++)
                            {
                            an += Integer.toString(in2);
                            }
                        an += "0";
                        System.out.println(an);
                        }
                    }
                else
                    {
                    System.out.println(in);
                    }
                }
            else if(min>0&&in==0)
                {
                int in2 = 1;
                int min2 = Integer.parseInt(y1[1]);
                int flag = 0;
                int flag2=0;
                for (int j = 1; j < 10; j++)
                    {
                    if(Integer.parseInt(y1[j])==min)
                        {
                        in2 = j;
                        min2 = Integer.parseInt(y1[j]);
                        flag=1;
                        break;
                        }
                    if ((Integer.parseInt(y1[j])>0)&&flag2==0)
                        {
                        in2 = j;
                        flag=0;
                        flag2=1;
                        }
                    }
                if (flag == 0)
                    {
                    an = "";
                    an += in2;
                    for (int j = 0; j < min+1; j++)
                        {
                        an += "0";
                        }
                    }
                if(flag==1)
                    {
                    an="";
                    for(int j=0;j<min2+1;j++)
                        {
                        an+=Integer.toString(in2);
                        }
                    }
                System.out.println(an);
                }
            else if(min>0&&in>0)
                {
                an="";
                for(int j=0;j<min+1;j++)
                    {
                    an+=Integer.toString(in);
                    }
                an=an.trim();
                System.out.println(an);
                }

            }
        }
    }
