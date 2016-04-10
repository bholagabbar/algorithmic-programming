def Partition(a,l,r):
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

    pivot=a[l]
    i=l+1
    for j in range(l+1,r+1):
        if a[j]<pivot:
            a[i],a[j]=a[j],a[i]
            i+=1
    a[l],a[i-1]=a[i-1],a[l]
    return i-1

def RSelect(a, stat):
	if len(a)==1:
		return a[0]

	part=Partition(a,0,len(a)-1)
	if part+1==stat:
		return a[part]
	elif part>stat:
		RSelect(a[0:part], stat)
	else:
		RSelect(a[part:len(a)], stat-part+1)

a=[1,4,5,23,67]
print(RSelect(a,1), RSelect(a,2), RSelect (a,3))