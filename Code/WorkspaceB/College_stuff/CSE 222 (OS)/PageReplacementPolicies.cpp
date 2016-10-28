#include<stdio.h>
int n,pg[30],fr[10];
void fifo();
void optimal();
void lru();
int main()
{
	int i,ch;
	printf("\nEnter total number of pages:");
	scanf("%d",&n);
	printf("\nEnter sequence:");
	for(i=0;i<n;i++)			//accepting sequence
		scanf("%d",&pg[i]);
	do
	{
		printf("\n\tMENU\n");
		printf("\n1)FIFO");
		printf("\n2)OPTIMAL");
		printf("\n3)LRU");
		printf("\n4)Exit");
		printf("\nEnter your choice:");
		scanf("%d",&ch);
		switch(ch)
		{
			case 1: fifo();
				break;

			case 2: optimal();
				break;

			case 3: lru();
				break;

		}
	}while(ch!=4);
	getchar();
}

void fifo()
{
	int i,f,r,s,count,flag,num,psize;
	f=0;
	r=0;
	s=0;
	flag=0;
	count=0;
	printf("\nEnter size of page frame:");
	scanf("%d",&psize);
	for(i=0;i<psize;i++)	
	{
		fr[i]=-1;
	}
	while(s<n)	
	{
		flag=0;
		num=pg[s];
		for(i=0;i<psize;i++)
		{
			if(num==fr[i])
			{
				s++;
				flag=1;
				break;
			}
		}
		if(flag==0)
		{
			if(r<psize)
			{	
				fr[r]=pg[s];
				r++;
				s++;
				count++;
			}
			else
			{
				if(f<psize)
				{
					fr[f]=pg[s];
					s++;
					f++;
					count++;
				}
				else 
					f=0;
			}
		}
		printf("\n");			
		for(i=0;i<psize;i++)
		{
			printf("%d\t",fr[i]);
		}
	}
printf("\nPage Faults=%d",count);
getchar();
}
void optimal()
{
	int count[10],i,j,k,fault,f,flag,temp,current,c,dist,max,m,cnt,p,x;
	fault=0;
	dist=0;
	k=0;
	printf("\nEnter frame size:");
	scanf("%d",&f);
	//initilizing distance and frame array	
	for(i=0;i<f;i++)
	{
		count[i]=0;
		fr[i]=-1;
	}
	for(i=0;i<n;i++)
	{
		flag=0;
		temp=pg[i];
		for(j=0;j<f;j++)			
		{
			if(temp==fr[j])
			{
				flag=1;
				break;
			}
		}
		if((flag==0)&&(k<f))
		{
			fault++;
			fr[k]=temp;
			k++;
		}
		else if((flag==0)&&(k==f))
		{
			fault++;			
			for(cnt=0;cnt<f;cnt++)			
			{		
				current=fr[cnt];
				for(c=i;c<n;c++)
				{
					if(current!=pg[c])
						count[cnt]++;
					else
						break;
				}
			}
			max=0;
			for(m=0;m<f;m++)
			{
				if(count[m]>max)
				{
					max=count[m];
					p=m;
				}
			}
			fr[p]=temp;
		}
		printf("\n");			
		for(x=0;x<f;x++)
		{
			printf("%d\t",fr[x]);
		}
	}
	printf("\nTotal number of faults=%d",fault);
	getchar();
}

void lru()
{
	int count[10],i,j,k,fault,f,flag,temp,current,c,dist,max,m,cnt,p,x;
	fault=0;
	dist=0;
	k=0;
	printf("\nEnter frame size:");
	scanf("%d",&f);
	//initilizing distance and frame array	
	for(i=0;i<f;i++)
	{
		count[i]=0;
		fr[i]=-1;
	}
	for(i=0;i<n;i++)
	{
		flag=0;
		temp=pg[i];
		for(j=0;j<f;j++)			
		{
			if(temp==fr[j])
			{
				flag=1;
				break;
			}
		}
		if((flag==0)&&(k<f))
		{
			fault++;
			fr[k]=temp;
			k++;
		}
		else if((flag==0)&&(k==f))
		{
			fault++;			
			for(cnt=0;cnt<f;cnt++)			
			{		
				current=fr[cnt];
				for(c=i;c>0;c--)
				{
					if(current!=pg[c])
						count[cnt]++;
					else
						break;
				}
			}
			max=0;
			for(m=0;m<f;m++)
			{
				if(count[m]>max)
				{
					max=count[m];
					p=m;
				}
			}
			fr[p]=temp;
		}
		printf("\n");			
		for(x=0;x<f;x++)
		{
			printf("%d\t",fr[x]);
		}
	}
	printf("\nTotal number of faults=%d",fault);
	getchar();
}