package CODECHEF.PRACTICE.EASY.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Shreyans on 12/30/2014 using IntelliJ IDEA
 */

class ANUUND {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//Scanner sc=new Scanner(System.in);
		int t = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			String[] a = br.readLine().split(" ");
			for (int j = 0; j < n - 1; j++) {
				if (j == 0 || j % 2 == 0) {
					if (Integer.parseInt((a[j + 1])) < Integer.parseInt((a[j]))) {
						int temp = Integer.parseInt((a[j]));
						a[j] = a[j + 1];
						a[j + 1] = Integer.toString(temp);
					}
				} else {
					if (Integer.parseInt((a[j + 1])) > Integer.parseInt((a[j]))) {
						int temp = Integer.parseInt((a[j]));
						a[j] = a[j + 1];
						a[j + 1] = Integer.toString(temp);
					}
				}
			}
			for (String j : a) {
				sb.append(j + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}

/* 1.54 in C and 30 in JAVA with Scanner. LAWL


#include<stdio.h>
int main()
{
	int t,i;
	scanf("%d",&t);
	for(i=0;i<t;i++)
	{
		int k,j;
		scanf("%d",&k);
		int n[k];
		for(j=0;j<k;j++)
		{
			scanf("%d",&n[j]);
		}
		for(j=0;j<k-1;j++)
            {
                if(j==0||j%2==0)
                {
                    if(n[j+1]<n[j])
                    {
                        int temp=n[j];
                        n[j]=n[j+1];
                        n[j+1]=temp;
                    }
                }
                else
                {
                    if(n[j+1]>n[j])
                    {
                        int temp=n[j];
                        n[j]=n[j+1];
                        n[j+1]=temp;
                    }
                }
			}
		for(j=0;j<k;j++)
		{
			printf("%d ",n[j]);
		}
		printf("\n");
	}
	return(0);
}

 */