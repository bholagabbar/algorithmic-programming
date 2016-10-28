#include <iostream>
#include <stdlib.h>
using namespace std;

class BST_HEAP
{
private:
    struct node
    {
        int key;
        node* left;
        node * right;
        node* parent;
        
    };
    node* root;
    int flag;
    
    node* CreateNode(int key, node* par)
    {
        node* n=new node();
        n->key=key;
        n->left=NULL;
        n->right=NULL;
        n->parent=par;
        return n;
    }
    
    void AddNodePrivate(int key, node* ptr)
    {
        if(root==NULL)
            root=CreateNode(key,NULL);
        else
        {
            if(key<ptr->key)
            {
                if(ptr->left!=NULL)
                    AddNodePrivate(key,ptr->left);
                else
                    ptr->left=CreateNode(key, ptr);
            }
            else if(key>ptr->key)
            {
                if(ptr->right!=NULL)
                    AddNodePrivate(key,ptr->right);
                else
                    ptr->right=CreateNode(key, ptr);
            }
        }
    }

    //Delete and Helper Fucnctions

    node* Delete(node* parent, int key)
    {
        if(root!=NULL)
        {
            if(root->key==key)
                RemoveRootMatch();
            else
            {
                if(key<parent->key && parent->left!=NULL)
                    (parent->left)->key==key? RemoveMatch(parent,parent->left,true):Delete(parent,key);
                else if(key>parent->key && parent->right!=NULL)
                    (parent->right)->key==key? RemoveMatch(parent,parent->right,false):Delete(parent,key);
            }
        }
    }

    void RemoveRootMatch()
    {
        if(root!=NULL)
        {
            node* delPtr=root;
            int rootKey=root->key;
            int smallestInRightSubtree;
            //Case 0: 0 Children
            if(root->left==NULL && root->right==NULL)
                root=NULL;
            //Case 2: 1 Child
            else if(root->left==NULL && root->right==NULL)
            {
                root=root->right;
                delPtr->right=NULL;
            }
            else if(root->right==NULL && root->left!=NULL)
            {
                root=root->left;
                delPtr->left=NULL;
            }
            else
            {
                smallestInRightSubtree=FindSmallestPri(root->right);
                Delete(root,smallestInRightSubtree);
                root->key=smallestInRightSubtree;

            }
            delete delPtr;
        }
    }

    void RemoveMatch(node* parent, node* match, bool left)
    {
        if(root!=NULL)
        {
            node* Delptr;
            int matchKey=match->key;
            int smallestInRightSubtree

        }
    }
    
    int FindSmallestPri(node* ptr)
    {
        while(ptr->left!=NULL)
            ptr=ptr->left;
        return ptr->key;   
    }

    int ExtractMinPrivate(node* ptr)
    {
        while(ptr->left!=NULL)
            ptr=ptr->left;
        int ans=ptr->key;
        Delete(key,ptr);
        return ans;       
    }
    
    void PrintInorderPrivate(node* ptr)
    {
        if(ptr->left!=NULL)
            PrintInorderPrivate(ptr->left);
        cout<<ptr->key<<endl;
        if(ptr->right!=NULL)
            PrintInorderPrivate(ptr->right);
    }
    
public:
    BST_HEAP()
    {
        root=NULL;
        flag=0;
    }
    
    void AddNode(int key)
    {
        flag=0;
        AddNodePrivate(key,root);
    }
    
    int ExtractMin()
    {
        int x=ExtractMinPrivate(root);
        return x;
    }
    
    bool isEmpty()
    {
        if(flag==1)
            return 1;
        else
            return 0;
    }
    
    void PrintInorder()
    {
        PrintInorderPrivate(root);
    }
};

int main()
{
    BST_HEAP pq;
    cout<<"Entering following values in Priority Queue\n";\
    int lim=10;
    for(int i=0;i<lim;i++)
    {
        int x=rand()%100;
        cout<<x<<endl;
        pq.AddNode(x);
    }
    cout<<"Inorder\n";
    pq.PrintInorder(); //WORKING!
    cout<<endl;
    cout<<"Extracting Value\n";
    while(!pq.isEmpty())
    {
        cout<<"Value Extracted: ";
        cout<<pq.ExtractMin()<<endl;
        cout<<"Want to Insert More? Press 1 else anything else\n";
        int choice;
        cin>>choice;
        if(choice==0)
        {
            cout<<"Enter the number of entries to add\n";
            int nc;
            cin>>nc;
            for(int i=0;i<nc;i++)
            {
                int x;
                cin>>x;
                pq.AddNode(x);
            }
        }
    }
    return 0;
}
