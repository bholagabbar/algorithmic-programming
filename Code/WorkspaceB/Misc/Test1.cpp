/*input
5
1 2 2
2 3 4
4 2 3
5 4 1
3
2 5 3
1 3 1
2 5 3
*/
#include <bits/stdc++.h>
using namespace std;
inline int scan(){
    char c = getchar();
    int x = 0;
    while(c<'0'||c>'9'){
        c=getchar();
    }
    while(c>='0'&&c<='9'){
        x=(x<<1)+(x<<3)+c-'0';
        c=getchar();
    }
    return x;
}
#define N 100001
#define LN 17
#define mp make_pair
#define pb push_back
int dp[LN][N];//for LCA
vector<int> v[N];//adj list
vector<int> edges[N];//cost of edges
vector<int> inde[N];//Indexes of edges
int chainno;//current chain number
int arr[N];//Base array for segtree
int segtree[N<<3];//asli_segtree
int chainhead[N];//stores the head of the head
int basepos[N];//store the position of the node in arr
int chainindex[N];//index of the current chain
int pos;//order in dfs
int subsize[N];//size of the subtree rooted at i
int depth[N];//depth from root
int endnode[N];//store the node at the other end of the edge
void dfs(int node,int parent,int level){
    depth[node]=level;
    dp[0][node]=parent;
    subsize[node]=1;
    int x=v[node].size();
    while(x--){
        int next=v[node][x];
        if(next!=parent){
            endnode[inde[node][x]]=next;
            dfs(next,node,level+1);
            subsize[node]+=subsize[next];
        }
    }
}
void hld(int node,int cost,int parent){
    if(chainhead[chainno]==-1){
        chainhead[chainno]=node;
    }
    chainindex[node]=chainno;
    basepos[node]=pos;
    arr[pos++]=cost;
    int specialchild=-1,edgecost=0;
    int x=v[node].size();
    while(x--){
        int next=v[node][x];
        if(next!=parent){
            if(specialchild==-1||subsize[next]>subsize[specialchild]){
                specialchild=next;
                edgecost=edges[node][x];
            }
        }
    }
    if(specialchild!=-1){
        hld(specialchild,edgecost,node);
    }
    x=v[node].size();
    while(x--){
        int next=v[node][x];
        if(next!=parent&&next!=specialchild){
            chainno++;
            hld(next,edges[node][x],node);
        }
    }
}
void build(int l,int r,int node){
    if(l==r){
        segtree[node]=arr[l];
        return ;
    }
    int mid = (l+r)>>1;
    int lc=node<<1;
    int rc=lc|1;
    build(l,mid,lc);
    build(mid+1,r,rc);
    segtree[node]=segtree[lc]+segtree[rc];
}
int lca(int l,int r){
    if(depth[l]<depth[r]){
        swap(l,r);
    }
    int dif=depth[l]-depth[r];
    for(int i=0;i<LN;i++){
        if((dif>>i)&1){
            l=dp[i][l];
        }
    }
    if(l==r)return l;
    for(int i=LN-1;i>=0;i--){
        if(dp[i][l]!=dp[i][r]){
            l=dp[i][l];
            r=dp[i][r];
        }
    }
    return dp[0][l];
}
int maximum(int l,int r,int node,int ql,int qr){
    if(ql>r||l>qr){
        return 0;
    }
    if(l>=ql&&r<=qr){
        return segtree[node];
    }
    int mid = (l+r)>>1;
    int lc = node<<1;
    int rc= lc|1;
    int lv = maximum(l,mid,lc,ql,qr);
    int rv = maximum(mid+1,r,rc,ql,qr);
    return rv+lv;
}
int queryup(int l,int r){
    if(l==r)return 0;
    int lchain,rchain=chainindex[r];
    int ans=0;
    while(1){
        lchain=chainindex[l];
        if(lchain==rchain){
            if(l==r){
                break;
            }
            int temp=maximum(1,pos,1,basepos[r]+1,basepos[l]);
            ans=ans+temp;
            break;
        }
        int temp=maximum(1,pos,1,basepos[chainhead[lchain]],basepos[l]);
        ans=ans+temp;
        l=chainhead[lchain];
        l=dp[0][l];
    }
    return ans;
}
int query(int l,int r){
    int lr=lca(l,r);
    int a=queryup(l,lr);
    int b=queryup(r,lr);
    return a+b;
}
void update(int l,int r,int node,int indice,int val){
    if(l==r){
        segtree[node]=val;
        return;
    }
    int mid = (l+r)>>1;
    int lc = node<<1;
    int rc= lc|1;
    if(indice<=mid){
        update(l,mid,lc,indice,val);
    }
    else{
        update(mid+1,r,rc,indice,val);
    }
    segtree[node]=segtree[lc]+segtree[rc];
}
void change(int indice,int val){
    int node=endnode[indice];
    update(1,pos,1,basepos[node],val);
}
int main(){
    int t=1;
    while(t--){
        int n=scan();//nodes
        for(int i=0;i<=n;i++){//reinitialize everything for new testcase
            v[i].clear();
            edges[i].clear();
            inde[i].clear();
            chainhead[i]=-1;
            for(int j=0;j<LN;j++){
                dp[j][i]=-1;
            }
        }
        for(int i=1;i<n;i++){
            int u=scan(),ve=scan(),w=scan();
            v[u].pb(ve);
            edges[u].pb(w);
            inde[u].pb(i);
            v[ve].pb(u);
            edges[ve].pb(w);
            inde[ve].pb(i);
        }
        pos=1;
        dfs(1,0,0);
        for(int j=1;j<LN;j++){
            for(int i=1;i<=n;i++){
                if(dp[j-1][i]!=-1){
                    dp[j][i]=dp[j-1][dp[j-1][i]];//DP code for LCA ( O(NlogN) )
                }
            }
        }
        chainno=1;
        hld(1,0,0);
        pos--;
        build(1,pos,1);
        int q=scan();
        while(q--){
            int type=scan();
            int l=scan(),r=scan();
            if(type==2){
                int temp=query(l,r);
                printf("%d\n",temp);
            }
            else{
                change(l,r);
            }
        }
    }
} 