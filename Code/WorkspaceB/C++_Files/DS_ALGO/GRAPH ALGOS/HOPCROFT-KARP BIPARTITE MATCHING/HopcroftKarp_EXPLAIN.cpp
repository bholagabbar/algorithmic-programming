#include <bits/stdc++.h>
using namespace std;
#define NIL 0
#define INF INT_MAX

// References:
// 1. http://stackoverflow.com/questions/6366516/how-does-the-hopcroft-karp-algorithm-work
// 2. http://www.geeksforgeeks.org/hopcroft-karp-algorithm-for-maximum-matching-set-2-implementation/



// m and n are number of vertices on left
// and right sides of Bipartite Graph
int m, n;

// adj[u] stores adjacents of left side
// vertex 'u'. The value of u ranges from 1 to m.
// 0 is used for dummy vertex
vector<int> *adj;

// These are basically pointers to arrays needed
// for hopcroftKarp()
int *pairU, *pairV, *dist;

bool bfs();
bool dfs(int u);


// Returns size of maximum matching
int hopcroftKarp() {
    // pairU[u] stores pair of u in matching where u
    // is a vertex on left side of Bipartite Graph.
    // If u doesn't have any pair, then pairU[u] is NIL
    pairU = new int[m + 1];

    // pairV[v] stores pair of v in matching. If v
    // doesn't have any pair, then pairU[v] is NIL
    pairV = new int[n + 1];

    // dist[u] stores distance of left side vertices
    // dist[u] is one more than dist[u'] if u is next
    // to u'in augmenting path
    dist = new int[m + 1];

    // Initialize NIL as pair of all vertices
    for (int u = 0; u < m; u++)
        pairU[u] = NIL;
    for (int v = 0; v < n; v++)
        pairV[v] = NIL;

    // Initialize result
    int result = 0;

    // Keep updating the result while there is an
    // augmenting path.

    //The modified version of BFS marks shortest augmented paths available using dist array
    //When no more paths are available it returns false
    //Note that we need to find augmented paths starting from either only U or V because
    //that paths ends on other side anyway.

    while (bfs()) {
        // Find a free vertex
        for (int u = 1; u <= m; u++)

            // If current vertex is free and there is
            // an augmenting path from current vertex
            if (pairU[u] == NIL && dfs(u)) {

                //See if we have shotest augmnted path. If we do, then
                //Dfs will also mark vertices along that path unusable for
                //any other paths in next calls so that paths remain vertex disjoint.
                //Also if Dfs does find shortest augmnted path then it will do symmetric
                //difference along that path, setting proper pairs in pairU and pairV

                result++;
            }
    }
    return result;
}

// Returns true if there is an augmenting path, else returns
// false
bool bfs() {
    queue<int> Q; //an integer queue

    // First layer of vertices (set distance as 0)
    for (int u = 1; u <= m; u++) {
        // If this is a free vertex, add it to queue
        if (pairU[u] == NIL) {
            // u is not matched
            dist[u] = 0;
            Q.push(u);
        }

        // Else set distance as infinite so that this vertex
        // is considered next time
        else dist[u] = INF;
    }

    //Set distance of dummy node to infinite. When we find the shortest path, we would end at dummy node and BFS
    //would set its distance to the length of shortest path. We can use this length to eliminate any path that are
    //longer than. If more than one vertex has same length shortest path then for both of them we can follow the
    //dist array all the way to dummy node and when we get there we can check that length of path so far is the
    //same value as in dist[iNil].
    dist[NIL] = INF;

    // Q is going to contain vertices of left side only.
    while (!Q.empty()) {
        // Dequeue a vertex
        int u = Q.front();
        Q.pop();

        // If this node is not NIL and can provide a shorter path to NIL
        if (dist[u] < dist[NIL]) {
            //Go through our adjecency list of this node and
            //see if any of our neighbours for this node in V has an existing match in U OR is unmatched.
            //If it has existing matching then we will travel to next node in U and repeat the process.
            //If there was no existing matching then nextU is dummy node. In that case, if we are getting there
            //for the first time then we have found the shortest path and we mark dummy nodes dist as length of
            //shortest path we found. If it isn't our first time then either we have another shortest path of same
            //length or it's a longer path. In either case we can just ignore because if it was another shortest path
            //then dist of dummy node is already marked correctly. If it was not then dist of dummy node will be less than
            //dist[u] and it would ignored by Dfs.
            vector<int>::iterator i;
            for (i = adj[u].begin(); i != adj[u].end(); ++i) {
                int v = *i;

                // If pair of v is not considered so far
                // (v, pairV[V]) is not yet explored edge.
                if (dist[pairV[v]] == INF) {
                    // Consider the pair and add it to queue
                    dist[pairV[v]] = dist[u] + 1;
                    Q.push(pairV[v]);
                }
            }
        }
    }

    // If we could come back to NIL using alternating path of distinct
    // vertices then there is an augmenting path
    return (dist[NIL] != INF);
}

// Returns true if there is an augmenting path beginning with free vertex u
bool dfs(int u) {
    if (u != NIL) {
        vector<int>::iterator i;
        for (i = adj[u].begin(); i != adj[u].end(); ++i) {
            // Adjacent to u
            int v = *i;

            // Follow the distances set by BFS
            //The neigbour is next node in path if it's matching node is our distance + 1
            if (dist[pairV[v]] == dist[u] + 1) {
                //Recursively see if for this next node in path, we have shortest augmented path available
                if (dfs(pairV[v]) == true) {
                    //If so then time to do symmetric difference! Note that pairV[u] either has previous matching or is unmatched.
                    //If it had previous matching then setting pairV[v] to new value removes that matching and then adds a new matching
                    //which in essence is symmetric difference.
                    pairV[v] = u;
                    pairU[u] = v;
                    return true;
                }
            }
        }

        //Mark our node unusable for getting included in any other paths so that all shortest augmented paths are
        //vertex disjoint. For bipartiate case (but not for general graphs) it can be proved that doing this simple
        //vertex elimination results in maximal set of vertex disjoint paths. Why not for general graphs? Imagine
        //5 paths horizontally and one path vertical that cuts across the 5. If we choose vertices of vertical path then
        //we need to eliminate all horizontal paths resulting in non-maximal set.


        // If there is no augmenting path beginning with u.
        dist[u] = INF;
        return false;
    }
    return true;
}

// To add edge from u to v and v to u
void addEdge(int u, int v) {
    adj[u].push_back(v); // Add u to v’s list.
    adj[v].push_back(u); // Add u to v’s list.
}

// Driver Program
int main() {

    n = 4, m = 4;
    adj = new vector<int> [m + 1];
    addEdge(1, 2);
    addEdge(1, 3);
    addEdge(2, 1);
    addEdge(3, 2);
    addEdge(4, 2);
    addEdge(4, 4);
    int maxMatching = hopcroftKarp();
    cout << "Size of maximum matching is " << maxMatching;

    return 0;
}