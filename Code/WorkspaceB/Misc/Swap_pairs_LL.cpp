
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


struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

void printList(ListNode *A) {
    while (A != NULL) {
         cout << A->val<< " ";
         A = A->next;
    }
    cout << "\n";
}
 
ListNode* xswap(ListNode* next1, ListNode* next2) {
    next1->next = next2->next;
    next2->next = next1;
    return next2;
}
    
ListNode *swapPairs(ListNode *head) {
    ListNode* start = new ListNode(0); //make head no longer a special case
    start->next = head;
    ListNode *cur = start;
    while (cur->next != NULL && cur->next->next != NULL) {
        cur->next = xswap(cur->next, cur->next->next);
        cur = cur->next->next;
    }
    return start->next;
}



int main() {
    boostIO;
    ListNode* one = new ListNode(1);
    ListNode* two = new ListNode(2);
    ListNode* three = new ListNode(3);
    ListNode* four = new ListNode(4);
    
    one->next = two; 
    two->next = three;
    three->next = four;

    swapPairs(one);
    return 0;
}
