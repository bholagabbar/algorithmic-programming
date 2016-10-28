def Merge(l,r,a):
	
	i=j=k=0   #pointers for left,right and original array
	ll,lr,la=len(l),len(r),len(a)  #lengths of respective arrays
	
	while i<ll and j<lr:  #while atleast 1 reaches their limit
		if l[i]<=r[j]: 
			a[k]=l[i]
			i+=1
		else:
			a[k]=r[j]
			j+=1
		k+=1

	while i < ll: #leftovers for both
		a[k]=l[i]
		k+=1
		i+=1

	while j< lr:
		a[k]=r[j]
		k+=1
		j+=1

	return  #returning sorted (sub)array

def MergeSort(a):
	n=len(a)

	if n<2:
		return
	
	mid=n//2
	
	l=a[0:mid] #slicing left and right
	r=a[mid:n]
	
	MergeSort(l) #recursively solving left half
	MergeSort(r) #recursively solving right half
	Merge(l,r,a) #merging them to get theme in order
	
	return a  #returning a sorted array

inp=[2,6,4,8,9,10,2,2,6,3,11,13,14,1]
x=MergeSort(inp)
print(inp)