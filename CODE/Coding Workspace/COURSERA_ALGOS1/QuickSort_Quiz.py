global cnt
def Partition(a,l,r):
    #a[l],a[r]=a[r],a[l] #last element
    if r-l+1 >=3: #medain of 3 which is fastest
        x,y,z=a[l],a[(r+l)//2],a[r]
        w=[x,y,z]
        w.sort();
        ind=0
        if w[1]==x:
            ind=l
        elif w[1]==z:
            ind=r
        else:
            ind=((r+l)//2)
        a[l],a[ind]=a[ind],a[l]

    pivot=a[l] #remove previous statements for default 1st element as pivot
    i=l+1
    for j in range(l+1,r+1):
        if a[j]<pivot:
            a[i],a[j]=a[j],a[i]
            i+=1
    a[l],a[i-1]=a[i-1],a[l]
    return i-1

def QuickSort(a,l,r):
    global cnt
    if(r-l<1):
        return
    cnt+=(r-l) #incrementing number of comparisions (size-1)
    p=Partition(a,l,r)
    QuickSort(a,l,p-1)
    QuickSort(a,p+1,r)

a=[]
with open("E:/Shreyans/Coursera Algos 1/Week 2/2-QuickSort Algorithm/QuickSort.txt","r") as f:
    a=[]
    for i in f:
        a.append(int(i))
cnt=0
QuickSort(a,0,len(a)-1)
print(cnt) #number of inversions
