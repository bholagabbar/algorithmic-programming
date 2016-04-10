#include <bits/stdc++.h>
using namespace std;

const int N=1001;

char grid [N][N];
int dx[] = {1,-1,0,0,-1,-1,1,1};
int dy[] = {0,0,1,-1,-1,1,1,-1};
bool vis[N][N] = {0};
int dist[N][N] = {0};

int bfs_max_time(int s1, int s2, int r, int c)
{   
	for (int i = 1; i <= r; i++) {
		for (int j=1; j <= c; j++) {
			vis[i][j] = 0;
		}
	}
    dist[s1][s2] = 1;
    vis[s1][s2] = 1;
    int res_dis = INT_MIN;
    queue<pair<int, int> > q;
    q.push(make_pair(s1, s2));
    while (!q.empty())
    {
        pair<int, int> curr = q.front();
        q.pop();
        int c1 = curr.first;
        int c2 = curr.second;
        int curr_dist = dist[c1][c2];
        if (grid[c1][c2] == '*') {
        	res_dis = max(res_dis, curr_dist);	
        }
        for (int i = 0;i < 8; i++) {
            if (c1+dx[i] >=1 && c1+dx[i] <= r && c2+dy[i] >= 1 && c2+dy[i] <= c && !vis[c1+dx[i]][c2+dy[i]]) {
                q.push(make_pair(c1 + dx[i], c2 + dy[i]));
                vis[c1+dx[i]][c2+dy[i]] = 1;
                dist[c1+dx[i]][c2+dy[i]] = curr_dist+1;
            }
        }
    }
    return res_dis;
}

int main() {
	ios_base::sync_with_stdio(0), cin.tie(0);
	int tc;
	cin >> tc;
	while (tc--) {
		int r, c, minr=INT_MAX, maxr=INT_MIN, minc=INT_MAX, maxc=INT_MIN;
		string curr_row;
		cin >> r >> c;
		for (int i = 1; i <= r; i++) {
			cin >> curr_row;
			for (int j = 1; j <= c; j++) {
				grid[i][j] = curr_row[j-1];
				if (grid[i][j] == '*') {
					minr = min(minr, i);
					maxr = max(maxr, i);
					minc = min(minc, j);
					maxc = max(maxc, j);
				}
			}
		}
		if (minr == INT_MAX) {
			cout<<"0\n";
			continue;
		}
		set<pair<int, int>> to_check;
		to_check.insert(make_pair((int)ceil((minr+maxr)/2.0), (int)ceil((minc+maxc)/2.0)));
		to_check.insert(make_pair((int)ceil((minr+maxr)/2.0), (int)floor((minc+maxc)/2.0)));
		to_check.insert(make_pair((int)floor((minr+maxr)/2.0), (int)ceil((minc+maxc)/2.0)));
		to_check.insert(make_pair((int)floor((minr+maxr)/2.0), (int)floor((minc+maxc)/2.0)));
		int min = INT_MAX;
		for (pair<int, int> points : to_check) {
			min = std::min(min, bfs_max_time(points.first, points.second, r, c));
		}
		cout << min <<"\n";
	}
	return 0;
}