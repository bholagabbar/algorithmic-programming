/*input
4
1
6
3
7
1
2
0
*/

//Sort a doubly linked list and simulate memory allocation in the CPU

#include <iostream>
#include <cstdio>
#include <string>
using namespace std;

class DoublyLinkedList
{
	struct node
	{
		int data;//size
		int add;
		string status;
		node *next;
		node *prev;
	};

	node *head;
	node *tail;
	node *n;
	int size;

public:
	DoublyLinkedList()
	{
		head=tail=NULL;
		size=0;
	}

	void InsertNode(int a)
	{
		size++;
		n=new node();
		n->data=a;//size
		n->status="Free";
		n->add=rand()%100; //Allocating random addess
		if(head==NULL && tail==NULL)//Head Node
		{
			n->next=NULL;
			n->prev=NULL;
			head=n;
			tail=n;
		}
		else
		{
			n->prev=tail;
			tail->next=n;
			n->next=NULL;
			tail=n;
		}
	}

	void PrintListForward()
	{
		cout<<"\nPrinting List:\n\n";
		node *temp=head;
		while(temp!=NULL)
		{
			cout<<"Address:"<<temp->add<<" ; Size:"<<temp->data<<" ; Status:"<<temp->status<<endl;
			temp=temp->next;
		}
		cout<<endl;
		return;
	}

	node* GetNode(int x)
	{
		node *temp=head;
		for(int i=1;i<x;i++)
			temp=temp->next;
		return temp;

	}

	void SortList()
	{
		for(int i=1;i<=size;i++)
			for(int j=i+1;j<=size;j++)
			{
				node *temp1=GetNode(i);
				node *temp2=GetNode(j);
				if(temp1!=NULL && temp2!=NULL && temp1->add>temp2->add)
				{
					int t=temp1->add;
					temp1->add=temp2->add;
					temp2->add=t;
					int t1=temp1->data;
					temp1->data=temp2->data;
					temp2->data=t1;
				}
			}
	}

	void Allocate(int asize)
	{
		node* temp=head;
		while(temp!=NULL)
		{
			if(temp->data>=asize && temp->status.compare("Free")==0)//Allocating
			{
				temp->status="Allocated";
				cout<<"\n\nDetails of Memory Block Allocated:\n";
				cout<<"Address:"<<temp->add<<" ; Size:"<<temp->data<<" ; Status:"<<temp->status<<endl;
				return;
			}
			temp=temp->next;
		}
		cout<<"Sorry! Unable to Allocate\n";
		return;
	}

	void Free()
	{
		node* temp=head;
		while(temp!=NULL)
		{
			if(temp->status.compare("Allocated")==0)//Merging if only allocated before
			{
				node *temp2=temp->prev;
				if(temp2!=NULL && temp2->status.compare("Free")==0)//If Previuos Block is Free
				{
					int ad=temp->add;
					int ss=temp->data;
					temp2->next=temp->next;
					if(temp->next!=NULL)//Setting previous and new size
					{
						(temp->next)->prev=temp2;
						(temp->next)->data+=ss;
					}
					cout<<"\nNode of address "<<ad<<" was merged with Address "<<temp2->add;
				}
				temp->status="Free";
			}
			temp=temp->next;
		}
	}

};

int main()
{
	DoublyLinkedList l;
	cout<<"Enter no. of Memory blocks followed by their size\n";
	int n,x;
	cin>>n;
	for(int i=0;i<n;i++)
	{
		cin>>x;
		l.InsertNode(x);
	}
	l.PrintListForward();//Initial List
	l.SortList();
	cout<<"Sorted Memory Blocks: \n";
	l.PrintListForward();
	cout<<"Enter size you want to Allocate. Enter 0 to Exit\n";
	cin>>x;
	while(x!=0)
	{
		l.Allocate(x);
		cin>>x;
	}
	l.Free(); //Merging node with previous node if it is free
	cout<<"\nFinal List: \n";
	l.PrintListForward(); //Printing Final List
}