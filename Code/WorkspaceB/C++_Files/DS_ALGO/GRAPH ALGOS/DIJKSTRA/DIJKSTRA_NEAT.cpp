/*input
7 9
1 2 4
2 3 10
2 5 7
3 5 3
3 4 4
3 6 6
4 5 12
4 7 8
6 7 12
1
*/

#include <iostream>
#include <vector>
#include <queue>
#include <climits>
using namespace std;

const int N = 1e5;
int dis[N + 1];
bool vis[N + 1] = {0};
vector<pair<int, int> > adj[N];

class cmp {
    public:
    bool operator() (const pair<int, int> &p1, const pair<int, int> &p2) {
        return p1.second > p2.second;
    }
};

void dijkstra(int s) {
    for(int i = 0; i <= N; i++) {
        dis[i] = INT_MAX;
    }
    dis[s] = 0;
    priority_queue<pair<int, int>, vector<pair<int, int> >, cmp> q;
    q.push(make_pair(s, 0));
    while (!q.empty()) {
        pair<int, int> currPair = q.top();
        q.pop();
        int currVertex = currPair.first;
        int currWeight = currPair.second;
        if (vis[currVertex]) {
            continue;
        }
        vis[currVertex] = true;
        for (int i = 0; i < adj[currVertex].size(); i++) {
            int nextVertex = adj[currVertex][i].first;
            int nextVertexWeight = adj[currVertex][i].second;
            if(!vis[nextVertex] && currWeight + nextVertexWeight < dis[nextVertex]) {
                dis[nextVertex] = currWeight + nextVertexWeight;
                q.push(make_pair(nextVertex, dis[nextVertex]));
            }
        }
    }
}

int main() {
    // freopen("/home/student/input.txt", "r", stdin);
    int n, m, v1, v2, w;
    cin >> n >> m;
    for (int i = 0; i < m; i++) {
        cin >> v1 >> v2 >> w;
        adj[v1].push_back(make_pair(v2, w));
        adj[v2].push_back(make_pair(v1, w));
    }
    int s;
    cin >> s;
    dijkstra(s);
    for (int i = 1; i <= n; i++) {
        cout << (char)(64 + s) << " " << (char)(64+ i) << " " <<dis[i] << "\n";
    }
    return 0;
}
