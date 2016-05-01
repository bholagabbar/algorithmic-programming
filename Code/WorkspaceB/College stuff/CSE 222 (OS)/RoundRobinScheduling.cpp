#include <iostream>
#include <cstdio>
#include <utility>
#include <map>
using namespace std;

int main () {
    freopen("input.txt", "r", stdin);
    int n, customer, token, prints_needed;
    cin >> n;
    map<int, pair<int, int> > a;
    for (int i = 0; i < n; i++) {
        cin >> customer >> token >> prints_needed;
        a[token] = make_pair(customer, prints_needed);
    }
    int dec_value = 5;
    int ppl_completed = 0;
    int curr_time = 0;
    int ftime[n+1];
    while (ppl_completed != n) {
        for (int i = 1; i <= n; i++) {
            if (a[i].second != 0) {
                int prints_taken_now = min(a[i].second, dec_value);
                a[i].second -= prints_taken_now;
                if (a[i].second == 0) {
                    ppl_completed++;
                }
                curr_time += 4*prints_taken_now;
                ftime[a[i].first] = curr_time;    
            }
        }
    }
    int sum = 0;
    cout << "Turnaround time:\n";
    for (int i = 1; i <= n; i++) {
        cout << i << " : " << ftime[i] << endl;
        sum += ftime[i];
    }
    sum /= n;
    cout << "Average waiting time: " << sum << endl;
    return 0;
}