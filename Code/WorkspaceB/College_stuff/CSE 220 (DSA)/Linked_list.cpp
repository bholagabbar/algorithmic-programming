/*input
6
3 6 1 8 2 3
*/
#include <iostream>
#include <cstdlib>
using namespace std;

struct LinkedList
{
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
				curr=curr->next;//Keeps pointing to the next address
			
			curr->next=n;//making the previous last element point to this one just inserted
		}
		else //The current node is the first one
			head=n;
	}

	int GetConsecutiveSum(int x)
	{
		curr=head;
		int cnt=1;
		while(curr->next!=NULL && cnt<x)
		{
			curr=curr->next;
			cnt++;
		}
		if(curr->next==NULL)//Last element
			return curr->data;
		return (curr->data+(curr->next)->data);//Consecutive Sum
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
	int n,x;
	cin>>n;
	for(int i=0;i<n;i++)
	{
		cin>>x;
		l.AddLast(x);
	}
	
	cout<<"Original List: ";
	l.PrintList();
	
	LinkedList ans;
	for(int i=1;i<=n;i++)
		ans.AddLast(l.GetConsecutiveSum(i));

	cout<<"Answer: ";
	ans.PrintList();
}