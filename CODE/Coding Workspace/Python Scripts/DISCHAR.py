'''input
2
abc
aba
'''
tc=eval(input())
for j in range(tc):
    s=input()
    a=set() 
    for i in range(len(s)): 
    	a.add(s[i])
    print(len(a))