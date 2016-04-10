package CODECHEF.PRACTICE.EASY.src;import java.io.*;
class TSORT
{
    public static void main(String[] args)throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder str = new StringBuilder();
        int in=Integer.parseInt(br.readLine());
        int[] AF=new int[in];
        for(int i=0;i<in;i++)
        {
            AF[i]=Integer.parseInt(br.readLine());
        }
        AF=MergeSort(AF);

        for (int i : AF) {
            str.append(i + "\n");
        }
        System.out.println(str);
    }

    private static int[] MergeSort(int[] A)
    {
        int n = A.length;
        if (n < 2) {
            return(A);
        }

        int mid =(int)(n/2);
        int[] l = new int[mid];
        int[] r = new int[n - mid];
        for (int i = 0; i < l.length; i++) {
            l[i] = A[i];

        }
        for (int i = l.length; i < (l.length+ r.length); i++) {
            r[i - l.length] = A[i];

        }

        MergeSort(l);
        MergeSort(r);
        int k2[]=Merge(l, r, A);
        return(k2);
    }

    private static int[] Merge(int[] L,int[] R,int[] A1)
    {

        int nl = L.length;
        int nr = R.length;
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
}
/* FASTER Arrays.sort with 'for each loop'
import java.io.*;
import java.util.Arrays;
class PROGTEST {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder str = new StringBuilder();
        int in = Integer.parseInt(br.readLine());
        int[] AF = new int[in];
        for (int i = 0; i < in; i++) {
            AF[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(AF);

        for (int i : AF) {
            str.append(i + "\n");
        }
        System.out.println(str);
    }
}

 */