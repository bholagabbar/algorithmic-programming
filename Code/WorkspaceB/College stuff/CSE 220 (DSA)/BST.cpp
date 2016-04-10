#include <iostream>
#include <stdlib.h>
using namespace std;

class BST
{
private:
	struct node
	{
		int key;
		node* left;
		node* right;
	};
	node* root;

	void AddNodePri(int key, node* ptr)
	{
		if(root==NULL)
			root=CreateNode(key);
		else if(key<ptr->key)
		{
			if(ptr->left!=NULL)
				AddNodePri(key,ptr->left);
			else
				ptr->left=CreateNode(key);
		}
		else if(key>ptr->key)
		{
			if(ptr->right!=NULL)
				AddNodePri(key,ptr->right);
			else
				ptr->right=CreateNode(key);
		}

	}

	void PrintInOrderPri(node* curr)
	{
		if(root!=NULL)
		{
			if(curr->left!=NULL)
				PrintInOrderPri(curr->left);
			cout<<curr->key<<" ";
			if(curr->right!=NULL)
				PrintInOrderPri(curr->right);
		}
	}

	bool ContainsPri(int key, node* temp)
	{
		if(temp->key==key)
			return true;
		else
		{
			if(temp->key<key)
				ContainsPri(key,temp->left);
			else if(temp->key>key)
				ContainsPri(key,temp->right);
		}
		return false;
	}

public:
	BST()
	{
		root=NULL;
	}

	node* CreateNode(int val)
	{
		node* n=new node;
		n->key=val;
		n->left=NULL;
		n->right=NULL;
		return n;
	}

	void AddNode(int key)
	{
		AddNodePri(key, root);
	}

	void PrintInOrder()
	{
		PrintInOrderPri(root);
	}

	void Contains(int key)
	{
		if(ContainsPri(key, root))
			cout<<"Yes\n";
		else
			cout<<"No\n";
	}

};

int main()
{
	BST b;
	b.AddNode(10);
	b.AddNode(2);
	for(int i=0;i<10;i++)
	{
		int x=i;
		cout<<x<<endl;
		b.AddNode(x);
	}
	b.Contains(1);
	b.Contains(3);
	b.PrintInOrder();
	return 0;
}