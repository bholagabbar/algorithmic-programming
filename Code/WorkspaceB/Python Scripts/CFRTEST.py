tc=eval(input())
for j in range(tc):
    n=eval(input())
    s=input().split(' ')
    a=set() 
    for i in range(n): a.add(eval(s[i])) #Keep adding elements to set and print the size in the end
    print(len(a))