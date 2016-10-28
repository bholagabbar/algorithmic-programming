#include <iostream>
#include <cstdlib>
using namespace std;

class LinkedList
{

private:
	struct node
	{
		int data;
		node *next;
	};

	node *head; //Head
	node *curr;//Current
	node *temp;//Temp

public:
	LinkedList()
	{
		head=curr=temp=NULL;
	}
	void AddLast(int val)
	{
		node *n=new node(); //Creating a new node and setting it's values
		n->data=val;
		n->next=NULL;

		if(head!=NULL)//A list is already present
		{
			curr=head;
			while(curr->next!=NULL)//Propogating to the end of the list
			{
				curr=curr->next;//Keeps pointing to the next address
			}
			curr->next=n;//making the previous last element point to this one just inserted
		}
		else //The current node is the first one
		{
			head=n;
		}
	}

	void AddFront(int val)
	{
		node *n=new node();
		n->data=val;
		n->next=head;
		head=n;
		return;
	}

	void DeleteEndNode()
	{
		curr=head;
		temp=head;
		while(curr->next!=NULL)//Traversing the list
		{
			temp=curr;
			curr=curr->next;
		}
		temp->next=NULL;//Setting the second last element as the end of the list
		delete curr;
	}

	void DeleteValue(int val)
	{
		curr=head;
		temp=head;
		while(curr!=NULL && curr->data!=val) //Traverse until the del value is found
		{
			curr=curr->next;
			temp=curr;//Trails behind curr
		}
		if(curr==NULL)//Not found
		{
			cout<<"Not found\n";
			return;
		}
		else
		{
			node* delPtr=curr;//This is the node to to deleted
			curr=curr->next;//going to the next node 
			temp->next=curr;//pointing the the next node instead of the deletion one
			if(head->data==val) //Special case for head node
			{
				head=head->next;//Setting the next node as head
				temp=NULL;
			}
			delete delPtr; //Free the memory
		}
	}


	void PrintList()
	{
		curr=head;
		while(curr!=NULL)
		{
			cout<<curr->data<<"->";
			curr=curr->next;
		}
		cout<<"NULL\n";
	}
};

int main()
{
	LinkedList l;
	int sum=0,x;
	for(int i=0;i<10;i++)
	{
		sum+=i;
		l.AddLast(sum);
	}
	l.PrintList();
	l.DeleteEndNode();
	l.AddLast(90);
	l.DeleteEndNode();
	l.PrintList();
	//l.AddFront(-1);
	l.PrintList();
}