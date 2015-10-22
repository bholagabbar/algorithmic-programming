#include <iostream>
#include <stdlib.h>
using namespace std;

template <typename t>
class BST
{
private:
	struct node
	{
		t data;//Data
		node* left;//Left child
		node* right;//Right Child
		node()
		{
			left=right=NULL;
		}
	};
	node* head;
	node* curr;
public:
	void Insert(t x)
	{
		node* n=new node();
		n->data=x;
		if(head==NULL)//This is the head itself
			head=n;
		else
		{
			curr=head;
			while(curr!=NULL)
			{
				if(x<head->data)//If the entry is less than the curr one, got to hte left child
					curr=curr->left;
				else//else the right child
					curr=curr->right;
			}
			curr=n;
		}
	}
	bool Find(t x)
	{
		
	}
}