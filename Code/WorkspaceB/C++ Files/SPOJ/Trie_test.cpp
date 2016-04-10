#include <iostream>
using namespace std;

class Trie
{
private:
	struct node
	{
		int data;
		bool end;
		
		list<node*> next;
	};
}