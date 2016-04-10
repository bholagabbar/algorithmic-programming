#include <iostream>
#include <cstdlib>
using namespace std;

template <typename T>
class Stack
{
 public:

 	T *a;
 	size_t ptr;
 	size_t size;
 	
 	Stack(size_t s)
 	{
 		this-> a=new T[size];
 		this-> size=s;
 		this-> ptr=-1;
 	}

 	void resize(size_t x)
 	{
 		size_t ns=x;
 		T*na=new T [ns];
 		memcpy(na,a, size*sizeof(a));
 		size=ns;
 		delete[] a;
 		a=na;
 		cout<<"New array created with previous contents of size: "<<size<<endl;
 	}

	void pop()
	{
		if(ptr==-1)
		{
			cout<<"Failed. Stack Underflow\n";
		}
		else
		{
			cout<<"Element "<<a[ptr]<<" removed from position "<<(ptr+1)<<endl;
			ptr--;
		}
	}

	void push(T x)
	{
		if(ptr+1==size)
		{
			cout<<"Failed. Stack Overflow\n";
		}
		else
		{
			a[++ptr]=x;
			cout<<"New Element "<<x<<" inserted at position "<<(ptr+1)<<endl;
		}
	}

	void peek()
	{
		cout<<"Element at "<<(ptr+1)<<" is "<<a[ptr]<<endl;
	}
};

int main()
{
	cout<<"Enter size of integer stack to create"<<endl;
	int s;
	cin>>s;
	Stack<int> stk(s);//created stack
	cout<<"1. POP\n2. PUSH\n3. PEEK\n4. LIST ALL\n5. RESIZE\n0. QUIT\n"<<endl;
	int choice;
	cin>>choice;
	while(choice!=0)
	{
		switch(choice)
		{
			case 1:
			stk.pop();
			break;

			case 2:
			cout<<"Start Entering Values. Enter -1 to STOP pushing element\n";
			int nv;
			cin>>nv;
			while(nv!=-1)
			{
				stk.push(nv);
				cin>>nv;
			}
			break;

			case 3:
			stk.peek();
			break;

			case 5:
			cout<<"Enter new size for Stack\n";
			int ns;
			cin>>ns;
			if(ns<=stk.size)
			{
				cout<<"Sorry! New Stack size must be larger!\n";
			}
			else
			{
				stk.resize(ns);
			}
			break;

			case 4:
			if(stk.ptr==-1)
			{
				cout<<"No elements to list!"<<endl;
			}
			else
			{
				for(int i=0;i<stk.size;i++)
				{
					cout<<(i+1)<<". "<<stk.a[i]<<endl;
				}
			}
			break;

			default:
			cout<<"Sorry Enter valid choice\n";
		}
		cout<<"Enter choice"<<endl;
		cin>>choice;
	}
	cout<<"EXITED\n";
	return 0;

}