
//Shreyans Sheth [bholagabbar]

#include <bits/stdc++.h>
using namespace std;
#define readFile freopen("E:/Shreyans/Documents/CP-algorithmic-programming-database/Code/WorkspaceB/C++ Files/INPUT.txt","r",stdin);
#define getPrecision(s,p) fixed<<setprecision(p)<<s
#define boostIO ios_base::sync_with_stdio(0), cin.tie(0)
#define CLR(s) memset(&s, 0, sizeof s)
#define hashset unordered_set
#define hashmap unordered_map
#define PB push_back
#define MP make_pair
#define N 1000001
#define F first
#define S second
#define endl '\n'

typedef long long int ll;
typedef long double ld;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

struct node {
    int data;
    node* next;
};

node* head;

void insertNode(int val) {
    if (head == NULL) {
        head = new node();
        head->data = val;
        head->next = NULL;
        return;
    }
    node* newNode = new node();
    newNode->data = val;
    newNode->next = head;
    head = newNode;
}

void printList() {
    node* curr = head;
    while (curr != NULL) {
        cout << curr->data << " ";
        curr = curr->next;
    }
    cout << endl;
}

void reverseList() {
    node* curr = head;
    node* prev = NULL;
    node* next = NULL;
    while (curr != NULL) {
        next = curr->next;
        curr->next = prev;
        prev = curr;
        curr = next;
    }
    head = prev;
}

void reverseListRecursion(node* curr, node* next, node* prev) {
    if (curr == NULL) {
        head = prev;
        return;
    }
    next = curr->next;
    curr->next = prev;
    prev = curr;
    curr = next;
    return reverseListRecursion(curr, next, prev);
}

int main() {
    boostIO;
    insertNode(2);
    insertNode(3);
    insertNode(4);
    insertNode(5);
    insertNode(6);
    printList();
    reverseListRecursion(head, NULL, NULL);
    printList();
    return 0;
}