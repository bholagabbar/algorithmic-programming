import random, copy
data = open("E:/Shreyans/Documents/Coding Workspace/STDINPUT.txt","r")
G = {}
for line in data:
    lst = [int(s) for s in line.split()]
    G[lst[0]] = lst[1:]   
print ("Graph: ",G)

def choose_random_key(G):
    v1 = random.choice(list(G.keys()))
    v2 = random.choice(list(G[v1]))
    return v1, v2

def karger(G):
    length = []
    while len(G) > 2:
        v1, v2 = choose_random_key(G)
        G[v1].extend(G[v2])
        print (v1,v2,G[v1])
        for x in G[v2]:
            G[x].remove(v2)
            G[x].append(v1) 
        while v1 in G[v1]:
            G[v1].remove(v1)
        del G[v2]
        print(G)
    for key in G.keys():
        length.append(len(G[key]))
    return length[0]

def operation(n):
    i = 0
    count = 10000   
    while i < n:
        data = copy.deepcopy(G)
        min_cut = karger(data)
        if min_cut < count:
            count = min_cut
        i = i + 1
    return count


print(operation(100))