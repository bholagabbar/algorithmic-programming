#include<stdio.h>

   int * MergeSort(int * A);
   int * Merge(int * L,int * R,int * A1);

    int main()
    {
       
        int in=0;
        scanf("%d",&in);
        int AF [in];
        for(int i=0;i<in;i++)
        {
        scanf("%d",&AF[i]);            
        }
        int *AFF[in];
        *AFF=MergeSort(AF);
        int len2=sizeof(AFF)/sizeof(int);
        for(int i=0;i<len2;i++)
        {
            printf("%d",& AFF[i]);
        }
    }

        int * MergeSort(int * A)
    {
        int n = sizeof(A)/sizeof(int);
        if (n < 2) {
            return(A);
        }

        int mid =(int)(n/2);
        int l [mid];
        int r [n - mid];
        int nl1=sizeof(l)/sizeof(int);    
        int nr1=sizeof(r)/sizeof(int);       
        for (int i = 0; i < nl1; i++) {
            l[i] = A[i];

        }
        for (int i = nl1; i < (nl1+nr1); i++) {
            r[i - nl1] = A[i];

        }

        MergeSort(l);
        MergeSort(r);
        int * k2[n];
        * k2=Merge(l, r, A);
        return(&k2);
    }

       int * Merge(int * L,int * R,int * A1)
    {

        int nl = sizeof(L)/sizeof(int);
        int nr = sizeof(R)/sizeof(int);
        int i = 0, j = 0, k = 0;
        while ((i < nl) && (j < nr)) {
            if (L[i] <= R[j]) {
                A1[k++] = L[i++];

            } else {
                A1[k++] = R[j++];

            }

        }

        while (i < nl) {
            A1[k++] = L[i++];

        }
        while (j < nr) {
            A1[k++] = R[j++];

        }
        return (A1);
    }
