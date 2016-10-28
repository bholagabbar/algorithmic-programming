#Implementation of QuickSort in Python
def Partition(a,l,r):
	a[l],a[(l+r)//2]=a[(l+r)//2],a[l] #Middle Element as pivot. Getting to front
	pivot=a[l] # choosing pivot
	i=l+1 # partition between elements less than pivot and greater than pivot
	
	for j in range(l+1,r+1):
		if a[j]<pivot: # this indicates that element to the right is smaller and must be swapped
			a[i],a[j]=a[j],a[i] # swapping
			i+=1 # incrementing partition
	
	a[l],a[i-1]=a[i-1],a[l] # Placing the pivot at it's "rightful" intersection between larges and smaller values
	return i-1 # returning pivot position

def QuickSort(a,l,r):
	if(r-l<1):
		return

	p=Partition(a,l,r) # finding the pivot element
	QuickSort(a,l,p-1) # recursively solving left half
	QuickSort(a,p+1,r) # recursively solving right half

a=[8, 10, 1, 9, 7, 2, 6, 3, 5, 4,4,8] #test
print('Unsorted:',a)
QuickSort(a,0,len(a)-1)
print('Sorted:',a)