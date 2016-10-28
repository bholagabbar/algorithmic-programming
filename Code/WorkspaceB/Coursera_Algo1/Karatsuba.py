def mult2(n, m): # manual recursive multiplication
    if n == 0 or m == 0: 
        return 0
    else:
        return n + mult2(n, m-1)

# Karatsuba Multiplication of n digits. x & y must have the same number of digits
def Karatsuba(x, y):
    n = max(len(str(x)),len(str(y)))
    
    if(n<=1):
    	return mult2(x,y)

    # split x & y into a, b, c, d components

    mb=10**(n//2)

    a = x // mb
    b = x %  mb
    c = y // mb
    d = y %  mb

    # if n is odd, subtract 1
    if n % 2 != 0:
        n -= 1
        
    # get recursive components    
    ac = Karatsuba(a,c) #calling Karatsuba recursively!!
    bd = Karatsuba(b,d)
    ad_plus_bc = Karatsuba(a+b,c+d) - ac - bd
    
    return ac * 10**n + bd + ad_plus_bc * mb  
    
    
print (Karatsuba(123, 456))
print (Karatsuba(1234, 5678))