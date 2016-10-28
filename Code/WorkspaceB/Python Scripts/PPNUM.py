'''input
1
1 2

'''

def sumf(a):
    s=((a*(a+1))//2)# //->AC /->WA. 3 hours wasted. FML
    return s

t=list()
for i in range (10):
    t.append(10**i)

m=1000000007 
tc=eval(input())
while (tc>0):
    s1=input().split(' ')
    a=int(s1[0])
    b=int(s1[1])
    l1=len(s1[0])
    l2=len(s1[1])
    s=0
    if(l1==l2):
        s=((sumf(b)-sumf(a-1))%m*l1)
    
    else:
        x=((sumf(t[l1]-1)-sumf(a-1))%m*l1)%m
        y=((sumf(b)-sumf(t[l2-1]-1))%m*l2)%m
        s=x+y
        for i in range(l1+1,l2):
            s+=(sumf(t[i]-1)-sumf(t[i-1]-1))*i
    
    print (s%m)
    tc-=1  