import queue
def BFS(n,s,g):#size,source,graph
	visited=[0]*(n+1)
	q=queue.Queue(0)
	q.put(s)
	visited[s]=1;
	bfslist=list()
	while not q.empty():
		x=q.get()
		bfslist.append(x)
		for i in g[x]:
			if visited[i]!=1:
				visited[i]=1;
				q.put(i)
	return bfslist

g=[[],[2,3],[1,3],[1,2]]
x=BFS(3,1,g)
print(x)
