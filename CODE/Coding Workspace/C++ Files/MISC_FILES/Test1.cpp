// lower_bound/upper_bound example
#include <iostream>     // std::cout
#include <algorithm>    // std::lower_bound, std::upper_bound, std::sort
#include <vector>       // std::vector
#include <set>
using namespace std;

int main () {
  int myints[] = {10,20,30,30,20,10,10,20};
  multiset<int> v;
  v.insert(10);
  v.insert(20);
  v.insert(30);

  std::multiset<int>::iterator low,up;
  low=--std::lower_bound (v.begin(), v.end(), 20); //          ^
  cout<<*low<<endl;

  return 0;
}