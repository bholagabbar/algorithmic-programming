#include <iostream>
using namespace std;

struct queue
{
	int *a;
    int pnt,size,fptr;
	queue()
	{
		a=new int[100];//Instantiating wiht large size
		pnt =-1;
		fptr=0;
	}
	void enqueue(int x)
	{
		if(pnt<100)
		{
		a[++pnt]=x;
		}
		else 
		{
			cout<<"Sorry size exceeded\n";
		}
	}
	void dequeue()
	{
		if(fptr>pnt)
		{
			cout<<"Sorry not possible\n";
			return;
		}
		cout<<"Customer Dequeued is: "<<a[fptr]<<endl;
		fptr++;
	}
};

int main()
{
	int n,n1,x;
	queue q();
	int cnt=1;
	while(q.fptr<=q.pnt)
	{
        cout<<"Enter no of users to populate the queue in minute"<< cnt<<endl;
     	cin>>n1;
	    for(int i=0;i<n1;i++)
	    {
    		cin>>x;
    		q.enqueue(x);
	    } 
		cout<<"Queue in minute" <<cnt<<" is\n";
		q.list();
		q.dequeue();
		cout<<"Select choice of no. of users to add\n";
		int nx;
		cin>>nx;
		int w;
		switch(nx)
		{
			case 0:
			break;
			case 1:
			cout<<"Enter customer no of 1"<<endl;
			cin>>w;
			q.enqueue(w);
			break;
			case 2:
			cout<<"Enter customer no's of 1 and 2\n";
			cin>>w;
			q.enqueue(w);
			cin>>w;
			q.enqueue(w);
			break;
			default:
			cout<<"Sorry not possible\n";
		}
	}
    cout<<"Ended\n";
    getchar();
    getchar();
	return 0;
}